package persistence;

import entity.Recipes;
import utilities.Database;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecipesDaoTest {
    GenericDao recipeDao;

    @BeforeEach
    void setUp() {
        recipeDao = new GenericDao<>(Recipes.class);
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
        recipeDao.delete(recipeDao.getById(2));
        assertNull(recipeDao.getById(2));
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
    void testFindByPropertyEqual() {
    }
}