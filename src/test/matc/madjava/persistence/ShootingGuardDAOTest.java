package matc.madjava.persistence;

import matc.madjava.entity.ShootingGuard;
import matc.madjava.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShootingGuardDAOTest {
    private final Logger log = LogManager.getLogger(this.getClass());
    GenericDAO genericDAO;

    @BeforeEach
    void setUp() {
        Database database = matc.madjava.util.Database.getInstance();
        database.runSQL("cleandb.sql");

        genericDAO = new GenericDAO(ShootingGuard.class);
    }

    @AfterEach
    void tearDown() {
        Database database = matc.madjava.util.Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verify successful retrieval of a user
     */
    @Test
    void getByIdSuccess() {
        ShootingGuard retrievedPlayer = (ShootingGuard) genericDAO.getByID(1);
        assertEquals("James", retrievedPlayer.getFirstName());
        assertEquals("Harden", retrievedPlayer.getLastName());
    }

    /**
     * Verify successful insert of a user
     */
    @Test
    void insertSuccess() {

        ShootingGuard newplayer = new ShootingGuard(20,"John", "Cena", 1, 1,1,1,1,1);
        int id = genericDAO.insert(newplayer);
        assertNotEquals(0,id);
        ShootingGuard insertedPG = (ShootingGuard) genericDAO.getByID(id);
        assertEquals("John", insertedPG.getFirstName(), "first name is not equal");
        assertEquals("Cena", insertedPG.getLastName(), "Last name is not equal");

    }

    @Test
    void updateSuccess(){
        ShootingGuard updatePlayer = (ShootingGuard)genericDAO.getByID(1);
        updatePlayer.setLastName("Findme");
        genericDAO.update(updatePlayer);
        ShootingGuard updatePlayerCheck = (ShootingGuard)genericDAO.getByID(1);

        assertEquals("Findme", updatePlayerCheck.getLastName());

    }
    /**
     * Verify successful delete of user
     */
    @Test
    void deleteSuccess() {
        genericDAO.delete((genericDAO.getByID(1)));
        assertNull(genericDAO.getByID(1));
    }

    /**
     * Verify successful retrieval of all users
     */
    @Test
    void getAllSuccess() {
        List<ShootingGuard> players = genericDAO.getAll();
        assertEquals(2, players.size());
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<ShootingGuard> players = genericDAO.getByPropertyEqual("firstName", "James");
        assertEquals(1, players.size());
        assertEquals(1, players.get(0).getShootingGuardID());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<ShootingGuard> pls = genericDAO.getByPropertyLike("lastName", "H");
        for(ShootingGuard pl : pls) {
            log.info(pl.getLastName());
        }
        assertEquals(1, pls.size());
    }

    /**
     * successful use of specific use case unique finder (equal match)
     */
    @Test
    void getByPropertyEqualUnique() {
        ShootingGuard pl = (ShootingGuard)genericDAO.getByPropertyEqualUnique("lastName", "Harden");
        assertEquals("James", pl.getFirstName() );
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyNotEqualSuccess() {
        List<ShootingGuard> pls = genericDAO.getAllExceptEntity("lastName", "Harden");
        for(ShootingGuard pl : pls) {
            System.out.println(pl.getLastName());
        }
        assertEquals(1, pls.size());
    }
}