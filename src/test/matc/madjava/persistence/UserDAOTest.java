package matc.madjava.persistence;

import matc.madjava.entity.User;
import matc.madjava.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {
    private final Logger log = LogManager.getLogger(this.getClass());
    UserDAO userDAO;
    GenericDAO genericDAO;

    @BeforeEach
    void setUp() {
        userDAO = new UserDAO();
        genericDAO = new GenericDAO(User.class);

        Database database = matc.madjava.util.Database.getInstance();
        database.runSQL("cleandb.sql");

        userDAO = new UserDAO();
    }

    /**
     * Verify successful retrieval of a user
     */
    @Test
    void getByIdSuccess() {
        User retrievedUser = (User)genericDAO.getByID(3);
        assertEquals("Beth", retrievedUser.getFirstName());
        assertEquals("Seth", retrievedUser.getLastName());
        assertEquals("User", retrievedUser.getUserName());
        assertEquals("seth@beth.com", retrievedUser.getEmail());
    }

    /**
     * Verify successful insert of a user
     */
    @Test
    void insertSuccess() {

        User newUser = new User("testname","testpass","Test","name","test@pass.com");
        int id = userDAO.insertUser(newUser);
        assertNotEquals(0,id);
        User insertedUser = userDAO.getUserByID(id);
        assertEquals("Test", insertedUser.getFirstName());
        // Could continue comparing all values, but
        // it may make sense to use .equals()
    }

    /**
     * Verify successful delete of user
     */
    @Test
    void deleteSuccess() {
        userDAO.deleteUserByID(userDAO.getUserByID(1));
        assertNull(userDAO.getUserByID(1));
    }

    /**
     * Verify successful retrieval of all users
     */
    @Test
    void getAllSuccess() {
        List<User> users = userDAO.getAllUsers();
        assertEquals(3, users.size());
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<User> users = userDAO.getByPropertyLike("lastName", "Seth");
        assertEquals(1, users.size());
        assertEquals(3, users.get(0).getUserId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<User> users = userDAO.getByPropertyLike("lastName", "S");
        assertEquals(2, users.size());
    }
}