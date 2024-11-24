package persistence;

import entity.UserInformation;
import entity.Recipes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilities.Database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserInformationDaoTest {
    GenericDao userInfoDao;
    GenericDao recipeDao;

    @BeforeEach
    void setUp() {
        userInfoDao = new GenericDao<>(UserInformation.class);
        recipeDao = new GenericDao<>(Recipes.class);
        Database database = Database.getInstance();
        database.runSQL("recipeSearcherTestCleanWithUsers.sql");
    }

    @Test
    void getAll() {
        List<UserInformation> allUsers = userInfoDao.getAll();
        assertEquals(3, allUsers.size());
    }

    @Test
    void getById() {
        UserInformation retrievedUser = (UserInformation)userInfoDao.getById(1);
        assertNotNull(retrievedUser);
        assertEquals(userInfoDao.getById(1), retrievedUser);
    }

    @Test
    void delete() {
        UserInformation myUser = (UserInformation)userInfoDao.getById(3);
        List<Recipes> userRecipes = myUser.getRecipes();
        int recipe1 = userRecipes.get(0).getRecipeNameID();

        for (Recipes recipe : userRecipes) {
            recipe.setUserInformation(null);
            recipeDao.update(recipe);
        }

        userInfoDao.delete(userInfoDao.getById(3));
        assertNull(userInfoDao.getById(3));

        assertNotNull(recipeDao.getById(recipe1));
    }

    @Test
    void insert() {
        UserInformation newUser = new UserInformation("Jimmy Narita", "blahblah@gmail.com", "iLoveEaTing");
        int insertedUserID = userInfoDao.insert(newUser);
        UserInformation insertedUser = (UserInformation)userInfoDao.getById(insertedUserID);
        assertNotEquals(0, insertedUserID);
        assertEquals(newUser, insertedUser);
    }

    @Test
    void update() {
        UserInformation userToUpdate = (UserInformation)userInfoDao.getById(1);
        userToUpdate.setFullName("Jojo Brano");
        userInfoDao.update(userToUpdate);
        UserInformation updatedUser = (UserInformation)userInfoDao.getById(1);
        assertEquals(userToUpdate, updatedUser);
    }
}





















