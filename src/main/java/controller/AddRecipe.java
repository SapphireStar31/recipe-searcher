package controller;

import entity.Ingredients;
import entity.Recipes;
import persistence.GenericDao;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A servlet to add a recipe the user sends in.
 *
 * @author Karissa
 */
@WebServlet(
        name = "addRecipeServlet",
        urlPatterns = {"/add-recipe"}
)

public class AddRecipe extends HttpServlet {
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
        GenericDao ingredientDao = new GenericDao<>(Ingredients.class);

        List<Recipes> matchingRecipe = recipeDao.getAll();
        for (Recipes recipeName : matchingRecipe) {
            if (recipeName.getRecipeName().equals(request.getParameter("recipeName"))) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/duplicateRecipe.jsp");
                dispatcher.forward(request, response);
                return;
            }
        }

        String ingredientParameter = null;
        boolean moreIngredients = true;
        int loopNumber = 1;

        Recipes newRecipe = new Recipes();

        Set<Ingredients> listOfIngredients = new HashSet<Ingredients>();

        newRecipe.setRecipeName(request.getParameter("recipeName"));

        while (moreIngredients) {
            ingredientParameter = request.getParameter("ingredient" + loopNumber);

            if (ingredientParameter != null) {
                if (!ingredientParameter.isEmpty()) {
                    Ingredients newIngredient = new Ingredients();
                    newIngredient.setIngredientName(ingredientParameter);

                    ingredientDao.insert(newIngredient);
                    listOfIngredients.add(newIngredient);

                    loopNumber++;
                }
            } else {
                moreIngredients = false;
            }
        }

        newRecipe.setIngredients(listOfIngredients);

        recipeDao.insert(newRecipe);


        request.setAttribute("recipes", recipeDao.getAll());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/allRecipes.jsp");
        dispatcher.forward(request, response);
    }
}
