package persistence;

import entity.Ingredients;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilities.Database;

import java.util.List;

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
        List<Ingredients> allIngredients = ingredientDao.getAll();
        assertEquals(17, allIngredients.size());
    }

    @Test
    void getById() {
        Ingredients retrievedIngredient = (Ingredients)ingredientDao.getById(3);
        assertNotNull(retrievedIngredient);
        assertEquals(ingredientDao.getById(3), retrievedIngredient);
    }

    @Test
    void delete() {
        ingredientDao.delete(ingredientDao.getById(4));
        assertNull(ingredientDao.getById(4));
    }

    @Test
    void insert() {
        Ingredients newIngredient = new Ingredients("Potato");
        int insertedIngredientID = ingredientDao.insert(newIngredient);
        Ingredients insertedIngredient = (Ingredients)ingredientDao.getById(insertedIngredientID);
        assertNotEquals(0, insertedIngredientID);
        assertEquals("Potato", insertedIngredient.getIngredientName());
    }

    @Test
    void update() {
        Ingredients ingredientToUpdate = (Ingredients)ingredientDao.getById(2);
        ingredientToUpdate.setIngredientName("Cage-free Eggs");
        ingredientDao.update(ingredientToUpdate);
        Ingredients updatedIngredient = (Ingredients)ingredientDao.getById(2);
        assertEquals("Cage-free Eggs", updatedIngredient.getIngredientName());
    }

    @Test
    void findByPropertyEqual() {
        List<Ingredients> matchedIngredients = ingredientDao.findByPropertyEqual("ingredientName", "White Sugar");
        assertEquals(1, matchedIngredients.size());
        assertEquals(4, matchedIngredients.get(0).getIngredientID());
    }

    @Test
    void testFindByPropertyEqual() {
    }
}