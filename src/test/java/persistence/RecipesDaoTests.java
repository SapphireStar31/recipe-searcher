package persistence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilities.Database;
import entity.Recipes;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class RecipesDaoTests {
    RecipesDao recipesDao;

    @BeforeEach
    void setUp() {
        recipesDao = new RecipesDao();
        Database database = Database.getInstance();
        database.runSQL("recipeSearcherTestClean.sql");
    }

    @Test
    void getById() {
    }

    @Test
    void update() {
    }

    @Test
    void insert() {
    }

    @Test
    void delete() {
    }

    @Test
    void getAll() {
        List<Recipes> allRecipes = recipesDao.getAll();
        assertEquals(3, allRecipes.size());
    }
}