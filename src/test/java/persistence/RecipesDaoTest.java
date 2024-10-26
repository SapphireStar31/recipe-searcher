package persistence;

import entity.Ingredients;
import entity.Recipes;
import jakarta.transaction.Transactional;
import utilities.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecipesDaoTest {
    GenericDao recipeDao;
    GenericDao ingredients;
    Recipes recipe;

    @BeforeEach
    void setUp() {
        recipeDao = new GenericDao<>(Recipes.class);
        ingredients = new GenericDao<>(Ingredients.class);
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
    }

    @Test
    void update() {
    }

    @Test
    void findByPropertyEqual() {
    }

    @Test
    void testFindByPropertyEqual() {
    }
}