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

        Recipes recipeToUpdate = (Recipes)session.getAttribute("recipeEdit");
        session.removeAttribute("recipeEdit");

        // SET RECIPE NAME
        recipeToUpdate.setRecipeName(request.getParameter("recipeName"));

        // SET INGREDIENTS
        recipeToUpdate.setIngredients(updateIngredientList(request));

        // FINALLY UPDATE THE RECIPE
        recipeDao.update(recipeToUpdate);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/user-recipes");
        dispatcher.forward(request, response);
    }

    /**
     * This method will take the ingredient form parameters and put
     * them in a list to add to the recipe.
     * @param request the HttpServletRequest object
     * @return a set of ingredients in the recipe
     */
    private Set<Ingredients> updateIngredientList(HttpServletRequest request) {
        Set<Ingredients> listOfIngredients = new HashSet<Ingredients>();
        int loopNumber = 1;
        boolean moreIngredients = true;

        while (moreIngredients) {
            if (request.getParameter("ingredient" + loopNumber) != null) {
                Ingredients newIngredient = new Ingredients(request.getParameter("ingredient" + loopNumber));

                // TEST IF IN DATABASE OR NOT
                listOfIngredients.add(checkIfInDatabase(newIngredient));

                loopNumber++;
            } else {
                moreIngredients = false;
            }
        }

        return listOfIngredients;
    }

    /**
     * This method will check if the ingredient sent in is in the database
     * already or not and if it isn't in the database it adds it.
     * @param newIngredient the ingredient form parameter
     * @return the ingredient object in the database
     */
    private Ingredients checkIfInDatabase(Ingredients newIngredient) {
        GenericDao ingredientDao = new GenericDao<>(Ingredients.class);
        List<Ingredients> allIngredients = ingredientDao.getAll();
        int insertedIngredient = 0;
        boolean inDatabase = false;

        for (Ingredients currentIngredient : allIngredients) {
            if (newIngredient.getIngredientName().equals(currentIngredient.getIngredientName())) {
                insertedIngredient = currentIngredient.getIngredientID();
                inDatabase = true;
            }
        }

        if (!inDatabase) {
            insertedIngredient = ingredientDao.insert(newIngredient);
        }

        return (Ingredients)ingredientDao.getById(insertedIngredient);
    }
}
