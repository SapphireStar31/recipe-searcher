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
 * A servlet to delete a recipe that a user wants deleted.
 *
 * @author Karissa
 */
@WebServlet(
        name = "UserDeleteRecipeServlet",
        urlPatterns = {"/delete-recipe"}
)

public class UserDeleteRecipe extends HttpServlet {
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
        int recipeToDeleteID = Integer.parseInt(request.getParameter("recipeToDeleteID"));

        Recipes recipeToDelete = (Recipes)recipeDao.getById(recipeToDeleteID);

        recipeDao.delete(recipeToDelete);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/user-recipes");
        dispatcher.forward(request, response);
    }
}
