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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * A servlet to search for a recipe the user sends in.
 *
 * @author Karissa
 */
@WebServlet(
        name = "recipeSearchServlet",
        urlPatterns = {"/recipe-search"}
)

public class SearchRecipes extends HttpServlet {
    /**
     * This method will handle HTTP GET requests.
     * @param request the HttpServletRequest object
     * @param response the HttpServletResponse object
     * @exception ServletException if there is a Servlet failure
     * @exception IOException if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Logger logger = LogManager.getLogger(this.getClass());
        GenericDao recipeDao = new GenericDao<>(Recipes.class);

        String matchingType = request.getParameter("recipeMatching");
        logger.debug("The matching type is: " + matchingType);
        String recipeNameSearch = request.getParameter("recipeSearchTerm");
        logger.debug("The search term is: " + recipeNameSearch);

        if (matchingType.equals("exactMatch")) {
            request.setAttribute("recipes", recipeDao.findByPropertyEqual("recipeName", recipeNameSearch));
        } else if (matchingType.equals("partialMatch")) {
            request.setAttribute("recipes", recipeDao.getByPropertyLike("recipeName", recipeNameSearch));
        } else {
            request.setAttribute("recipes", recipeDao.getAll());
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/recipeResults.jsp");
        dispatcher.forward(request, response);
    }
}
