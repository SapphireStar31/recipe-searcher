package persistence;

import entity.Ingredients;
import entity.Recipes;
import utilities.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RecipesDaoTest {
    GenericDao recipeDao;
    GenericDao ingredientDao;

    @BeforeEach
    void setUp() {
        recipeDao = new GenericDao<>(Recipes.class);
        ingredientDao = new GenericDao<>(Ingredients.class);
        Database database = Database.getInstance();
        database.runSQL("recipeSearcherTestCleanFKModified.sql");
    }

    @Test
    void getAll() {
        List<Recipes> allRecipes = recipeDao.getAll();
        assertEquals(3, allRecipes.size());
    }

    @Test
    void getById() {
        Recipes retrievedRecipe = (Recipes)recipeDao.getById(1);
        assertNotNull(retrievedRecipe);
        assertEquals(recipeDao.getById(1), retrievedRecipe);
    }

    @Test
    void delete() {
        Recipes myRecipe = (Recipes)recipeDao.getById(2);
        Set<Ingredients> myIngredients = myRecipe.getIngredients();
        int ingredient1 = myIngredients.iterator().next().getIngredientID();

        recipeDao.delete(recipeDao.getById(2));
        assertNull(recipeDao.getById(2));

        assertNotNull(ingredientDao.getById(ingredient1));
    }

    @Test
    void insert() {
        Recipes newRecipe = new Recipes("Baked Chicken");
        int insertedRecipeID = recipeDao.insert(newRecipe);
        Recipes insertedRecipe = (Recipes)recipeDao.getById(insertedRecipeID);
        assertNotEquals(0, insertedRecipeID);
        assertEquals("Baked Chicken", insertedRecipe.getRecipeName());
    }

    @Test
    void insertWithIngredients() {
        Recipes newRecipe = new Recipes("Grilled Cheese");

        Set<Ingredients> listOfIngredients = new HashSet<Ingredients>();
        Ingredients newIngredient1 = new Ingredients("Bread");
        Ingredients newIngredient2 = new Ingredients("Cheddar Cheese");
        listOfIngredients.add(newIngredient1);
        listOfIngredients.add(newIngredient2);

//        for (Ingredients ingredient : listOfIngredients) {
//            ingredientDao.insert(ingredient);
//        }

        int insertedIngredient1 = ingredientDao.insert(newIngredient1);
        int insertedIngredient2 = ingredientDao.insert(newIngredient2);
        newRecipe.setIngredients(listOfIngredients);

        Ingredients addedIngredient1 = (Ingredients)ingredientDao.getById(insertedIngredient1);
        Ingredients addedIngredient2 = (Ingredients)ingredientDao.getById(insertedIngredient2);

        int insertedRecipeID = recipeDao.insert(newRecipe);
        Recipes insertedRecipe = (Recipes)recipeDao.getById(insertedRecipeID);

        assertNotEquals(0, insertedRecipeID);
        assertEquals("Grilled Cheese", insertedRecipe.getRecipeName());
        assertEquals("Bread", addedIngredient1.getIngredientName());
        assertEquals("Cheddar Cheese", addedIngredient2.getIngredientName());
    }

    @Test
    void update() {
        Recipes recipeToUpdate = (Recipes)recipeDao.getById(1);
        recipeToUpdate.setRecipeName("Skinny Pancakes");
        recipeDao.update(recipeToUpdate);
        Recipes updatedRecipe = (Recipes)recipeDao.getById(1);
        assertEquals("Skinny Pancakes", updatedRecipe.getRecipeName());
    }

    @Test
    void findByPropertyEqual() {
        List<Recipes> matchedRecipes = recipeDao.findByPropertyEqual("recipeName", "Crepes");
        assertEquals(1, matchedRecipes.size());
        assertEquals(1, matchedRecipes.get(0).getRecipeNameID());
    }

    @Test
    void getByPropertyLike() {
        List<Recipes> matchedRecipes = recipeDao.getByPropertyLike("recipeName", "s");
        assertEquals(2, matchedRecipes.size());
    }

    @Test
    void getIngredientsFromRecipe() {
        Recipes myRecipe = (Recipes)recipeDao.getById(1);

        // USED FOR DEBUGGING TO MAKE SURE FILLED WITH CORRECT INGREDIENTS
        Set<Ingredients> myIngredients = myRecipe.getIngredients();

        assertEquals(1, myRecipe.getRecipeNameID());
    }
}