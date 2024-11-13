package controller;

import entity.Ingredients;
import persistence.GenericDao;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * A servlet to retrieve all ingredients and forward to a page to display
 * them all to the user.
 *
 * @author Karissa
 */
@WebServlet(
        name = "allIngredientsServlet",
        urlPatterns = {"/all-ingredients"}
)

public class AllIngredients extends HttpServlet {
    /**
     * This method will handle HTTP GET requests.
     * @param request the HttpServletRequest object
     * @param response the HttpServletResponse object
     * @exception ServletException if there is a Servlet failure
     * @exception IOException if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GenericDao ingredientDao = new GenericDao<>(Ingredients.class);

        request.setAttribute("ingredients", ingredientDao.getAll());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/allIngredients.jsp");
        dispatcher.forward(request, response);
    }
}
