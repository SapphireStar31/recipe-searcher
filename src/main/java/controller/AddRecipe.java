package controller;

import entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import persistence.GenericDao;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
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
    private final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * This method will handle HTTP POST requests.
     * @param request the HttpServletRequest object
     * @param response the HttpServletResponse object
     * @exception ServletException if there is a Servlet failure
     * @exception IOException if there is an IO failure
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        GenericDao recipeDao = new GenericDao<>(Recipes.class);

        List<Recipes> matchingRecipe = recipeDao.getAll();
        for (Recipes recipeName : matchingRecipe) {
            if (recipeName.getRecipeName().equals(request.getParameter("recipeName"))) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/duplicateRecipe.jsp");
                dispatcher.forward(request, response);
                return;
            }
        }

        Recipes newRecipe = new Recipes();

        // SET RECIPE NAME
        newRecipe.setRecipeName(request.getParameter("recipeName"));

        // SET INGREDIENTS
        newRecipe.setIngredients(createIngredientList(request));

        // SET USER INFORMATION
        UserInformation userCreatingRecipe = (UserInformation)session.getAttribute("userInfo");
        newRecipe.setUserInformation(userCreatingRecipe);

        // FINALLY INSERT THE NEW RECIPE
        recipeDao.insert(newRecipe);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/successfullyAdded.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * This method will loop through the ingredient form parameters and add
     * them to the list of ingredients for the recipe.
     * @param request the HttpServletRequest object
     * @return a set of ingredients
     */
    private Set<Ingredients> createIngredientList(HttpServletRequest request) {
        Set<Ingredients> listOfIngredients = new HashSet<Ingredients>();
        int loopNumber = 1;
        String ingredientParameter = null;
        boolean moreIngredients = true;

        while (moreIngredients) {
            ingredientParameter = request.getParameter("ingredient" + loopNumber);

            if (ingredientParameter != null) {
                if (!ingredientParameter.isEmpty()) {
                    Ingredients newIngredient = addIngredientToDatabase(ingredientParameter);
                    listOfIngredients.add(newIngredient);

                    loopNumber++;
                }
            } else {
                moreIngredients = false;
            }
        }

        logger.debug("Here is the final list of ingredients: {}", listOfIngredients);
        return listOfIngredients;
    }

    /**
     * This method will figure out if the ingredient is in the database and
     * if it isn't it will add it.
     * @param sentIngredient the ingredient we are checking
     * @return the ingredient that is a part of the recipe
     */
    private Ingredients addIngredientToDatabase(String sentIngredient) {
        // GET ALL RECORDS FROM DATABASE
        GenericDao ingredientDao = new GenericDao<>(Ingredients.class);
        List<Ingredients> allIngredients = ingredientDao.getAll();

        // LOOPS THROUGH AND SEE IF THAT MATCHES ANY NAMES
        for (Ingredients currentIngredient : allIngredients) {
            if (sentIngredient.equals(currentIngredient.getIngredientName())) {
                // MEANS THAT IT WAS FOUND ALREADY IN THE DATABASE
                // WE DON'T WANT TO ADD IT SO JUST RETURN THE CURRENT INGREDIENT
                return currentIngredient;
            }
        }

        // DONE WITH LOOP SO IF IT MADE IT HERE MEANS NO INGREDIENTS MATCHED
        // IF NO NAMES MATCH ADD TO THE DATABASE
        Ingredients newIngredient = new Ingredients(sentIngredient);
        int insertedIngredientID = ingredientDao.insert(newIngredient);
        return (Ingredients)ingredientDao.getById(insertedIngredientID);
    }
}
