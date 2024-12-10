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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A servlet to update a recipe.
 *
 * @author Karissa
 */
@WebServlet(
        name = "UserUpdateRecipeInfo",
        urlPatterns = {"/update-recipe"}
)

public class UpdateRecipe extends HttpServlet {
    /**
     * This method will handle HTTP POST requests.
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
        GenericDao ingredientDao = new GenericDao<>(Ingredients.class);

        boolean moreIngredients = true;
        int loopNumber = 1;

        Recipes recipeToUpdate = (Recipes)session.getAttribute("recipeEdit");
        session.removeAttribute("recipeEdit");

        // SET RECIPE NAME
        recipeToUpdate.setRecipeName(request.getParameter("recipeName"));

        // SET INGREDIENTS
        Set<Ingredients> listOfIngredients = new HashSet<Ingredients>();
        List<Ingredients> allIngredients = ingredientDao.getAll();
        int insertedIngredient = 0;
        boolean inDatabase = false;

        while (moreIngredients) {
            if (request.getParameter("ingredient" + loopNumber) != null) {
                Ingredients newIngredient = new Ingredients(request.getParameter("ingredient" + loopNumber));

                // TEST IF IN DATABASE OR NOT
                for (Ingredients currentIngredient : allIngredients) {
                    if (newIngredient.getIngredientName().equals(currentIngredient.getIngredientName())) {
                        insertedIngredient = currentIngredient.getIngredientID();
                        inDatabase = true;
                    }
                }
                if (!inDatabase) {
                    insertedIngredient = ingredientDao.insert(newIngredient);
                }

                listOfIngredients.add((Ingredients)ingredientDao.getById(insertedIngredient));

                loopNumber++;
                inDatabase = false;
            } else {
                moreIngredients = false;
            }
        }

        recipeToUpdate.setIngredients(listOfIngredients);

        // FINALLY UPDATE THE RECIPE
        recipeDao.update(recipeToUpdate);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/user-recipes");
        dispatcher.forward(request, response);
    }
}
