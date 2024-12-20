package persistence;

import entity.Ingredients;
import entity.Recipes;
import utilities.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class IngredientsDaoTest {
    GenericDao ingredientDao;
    GenericDao recipeDao;

    @BeforeEach
    void setUp() {
        ingredientDao = new GenericDao<>(Ingredients.class);
        recipeDao = new GenericDao<>(Recipes.class);
        Database database = Database.getInstance();
        database.runSQL("recipeSearcherTestCleanWithUsers.sql");
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
        Ingredients myIngredient = (Ingredients)ingredientDao.getById(4);
        Set<Recipes> myRecipes = myIngredient.getRecipes();
        int recipe1 = myRecipes.iterator().next().getRecipeNameID();

        ingredientDao.delete(ingredientDao.getById(4));
        assertNull(ingredientDao.getById(4));

        assertNotNull(recipeDao.getById(recipe1));
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
    void getByPropertyLike() {
        List<Ingredients> matchedIngredients = ingredientDao.getByPropertyLike("ingredientName", "Sugar");
        assertEquals(2, matchedIngredients.size());
    }
}