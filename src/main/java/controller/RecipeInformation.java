package controller;

import entity.Recipes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import persistence.GenericDao;
import persistence.SpoonacularAPIDao;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

/**
 * A servlet to retrieve a recipe the user hit on and return more
 * detailed information.
 *
 * @author Karissa
 */

@WebServlet(
        name = "recipeInformationServlet",
        urlPatterns = {"/recipe-information"}
)

public class RecipeInformation extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * This method will handle HTTP GET requests.
     * @param request the HttpServletRequest object
     * @param response the HttpServletResponse object
     * @exception ServletException if there is a Servlet failure
     * @exception IOException if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String recipeName = request.getParameter("recipeName");
        GenericDao recipeDao = new GenericDao<>(Recipes.class);
        SpoonacularAPIDao apiDAO = new SpoonacularAPIDao();

        List<Recipes> findRecipe = recipeDao.findByPropertyEqual("recipeName", recipeName);
        Recipes requestedRecipe = findRecipe.get(0);

        request.setAttribute("recipeInfo", requestedRecipe);
        try {
            request.setAttribute("apiSearchInfo", apiDAO.searchAndGetResults(recipeName));
        } catch (RuntimeException e) {
            logger.error("Error processing and running JSON...{}", e.getMessage(), e);
        }


        RequestDispatcher dispatcher = request.getRequestDispatcher("/detailedRecipeInfo.jsp");
        dispatcher.forward(request, response);
    }
}
