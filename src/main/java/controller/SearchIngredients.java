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
 * A servlet to search for an ingredient the user sends in.
 *
 * @author Karissa
 */
@WebServlet(
        name = "ingredientSearchServlet",
        urlPatterns = {"/ingredient-search"}
)

public class SearchIngredients extends HttpServlet {
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

        String matchingType = request.getParameter("ingredientMatching");
        String ingredientNameSearch = request.getParameter("ingredientSearchTerm");

        if (matchingType.equals("exactMatch")) {
            request.setAttribute("ingredients", ingredientDao.findByPropertyEqual("ingredientName", ingredientNameSearch));
        } else if (matchingType.equals("partialMatch")) {
            request.setAttribute("ingredients", ingredientDao.getByPropertyLike("ingredientName", ingredientNameSearch));
        } else {
            request.setAttribute("ingredients", ingredientDao.getAll());
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/ingredientResults.jsp");
        dispatcher.forward(request, response);
    }
}
