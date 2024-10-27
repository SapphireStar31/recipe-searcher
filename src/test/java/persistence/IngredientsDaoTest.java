package persistence;

import entity.Ingredients;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilities.Database;
import static org.junit.jupiter.api.Assertions.*;

class IngredientsDaoTest {
    GenericDao ingredientDao;

    @BeforeEach
    void setUp() {
        ingredientDao = new GenericDao<>(Ingredients.class);
        Database database = Database.getInstance();
        database.runSQL("recipeSearcherTestCleanFKModified.sql");
    }

    @Test
    void getAll() {
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