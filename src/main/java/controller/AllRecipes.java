package controller;

import entity.Recipes;
import persistence.GenericDao;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * A servlet to retrieve all recipes and forward to a page to display
 * them all to the user.
 *
 * @author Karissa
 */

@WebServlet(
        name = "allRecipesServlet",
        urlPatterns = {"/all-recipes"}
)

public class AllRecipes extends HttpServlet {
    /**
     * This method will handle HTTP GET requests.
     * @param request the HttpServletRequest object
     * @param response the HttpServletResponse object
     * @exception ServletException if there is a Servlet failure
     * @exception IOException if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GenericDao recipeDao = new GenericDao<>(Recipes.class);

        request.setAttribute("recipes", recipeDao.getAll());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/allRecipes.jsp");
        dispatcher.forward(request, response);
    }
}
