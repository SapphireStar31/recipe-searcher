package persistence;

import entity.Recipes;
import utilities.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class RecipesDaoTest {
    GenericDao recipeDao;

    @BeforeEach
    void setUp() {
        recipeDao = new GenericDao(Recipes.class);
        Database database = Database.getInstance();
        database.runSQL("recipeSearcherTestClean.sql");
    }

    @Test
    void getAll() {
        List<Recipes> allRecipes = recipeDao.getAll();
        assertEquals(3, allRecipes.size());
    }

    @Test
    void getById() {
    }

    @Test
    void delete() {
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