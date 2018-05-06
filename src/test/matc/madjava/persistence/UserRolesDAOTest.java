package matc.madjava.persistence;

import matc.madjava.entity.User;
import matc.madjava.entity.UserRoles;
import matc.madjava.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserRolesDAOTest {

    private final Logger log = LogManager.getLogger(this.getClass());
    GenericDAO genericDAO;

    @BeforeEach
    void setUp() {
        Database database = matc.madjava.util.Database.getInstance();
        database.runSQL("cleandb.sql");

        genericDAO = new GenericDAO(UserRoles.class);
    }

    @AfterEach
    void tearDown() {
        Database database = matc.madjava.util.Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verify successful retrieval of a role
     */
    @Test
    void getByIdSuccess() {
        UserRoles retrievedRole = (UserRoles)genericDAO.getByID(1);
        assertEquals("administrator", retrievedRole.getRoleName());
        assertEquals(1, retrievedRole.getUserRoleId());
        assertEquals("admin", retrievedRole.getUserName());
    }

    /**
     * Verify successful insert of a user role
     */
    @Test
    void insertSuccess() {
        User newUser = new User("testname","testpass","Test","name","test@pass.com");
        UserRoles newRole = new UserRoles(1, "administrator", newUser, "testname");
        int id = genericDAO.insert(newRole);
        assertNotEquals(0,id);
        UserRoles insertedRole = (UserRoles)genericDAO.getByID(id);
        assertEquals("administrator", insertedRole.getRoleName(), "role is not equal");
    }

    /**
     * Verify successful delete of user role
     */
    @Test
    void deleteSuccess() {
        genericDAO.delete(genericDAO.getByID(2));
        assertNull(genericDAO.getByID(2));
    }

    /**
     * Verify successful retrieval of all users role
     */
    @Test
    void getAllSuccess() {
        List<UserRoles> roles = genericDAO.getAll();
        assertEquals(3, roles.size());
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<UserRoles> roles = genericDAO.getByPropertyLike("userName", "admin");
        assertEquals(2, roles.size());
        assertEquals(1, roles.get(0).getUserRoleId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<UserRoles> roles = genericDAO.getByPropertyLike("userName", "a");
        for(UserRoles role : roles) {
            log.info(role.getUserName());
        }
        assertEquals(2, roles.size());
    }

    /**
     * successful use of specific use case unique finder (equal match)
     */
    @Test
    void getByPropertyEqualUnique() {
        UserRoles role = (UserRoles)genericDAO.getByPropertyEqualUnique("userName", "admin");
        assertEquals("admin", role.getUserName());
    }
}