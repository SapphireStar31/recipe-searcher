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
import java.util.List;

/**
 * A servlet to retrieve a users recipes that they have created and redirect
 * to a page that will show them.
 *
 * @author Karissa
 */
@WebServlet(
        name = "UserRecipesServlet",
        urlPatterns = {"/user-recipes"}
)

public class UserRecipes extends HttpServlet {
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
        HttpSession session = request.getSession();

        List<Recipes> usersRecipes = recipeDao.findByPropertyEqual("userInformation", session.getAttribute("userInfo"));

        request.setAttribute("userRecipes", usersRecipes);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/usersRecipes.jsp");
        dispatcher.forward(request, response);
    }
}
