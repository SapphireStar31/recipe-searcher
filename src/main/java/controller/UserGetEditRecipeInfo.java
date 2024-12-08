package controller;

import entity.Recipes;
import persistence.GenericDao;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * A servlet to get information on a recipe the user wants to edit.
 *
 * @author Karissa
 */
@WebServlet(
        name = "UserGetEditRecipeInfo",
        urlPatterns = {"/edit-recipe-info"}
)

public class UserGetEditRecipeInfo extends HttpServlet {
    /**
     * This method will handle HTTP GET requests.
     *
     * @param request  the HttpServletRequest object
     * @param response the HttpServletResponse object
     * @throws ServletException if there is a Servlet failure
     * @throws IOException      if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        GenericDao recipeDao = new GenericDao<>(Recipes.class);
        int recipeToEditID = Integer.parseInt(request.getParameter("recipeToEditID"));

        Recipes recipeToEdit = (Recipes)recipeDao.getById(recipeToEditID);

        request.setAttribute("recipeInfo", recipeToEdit);
        session.setAttribute("recipeEdit", recipeToEdit);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/userEditRecipe.jsp");
        dispatcher.forward(request, response);
    }
}
