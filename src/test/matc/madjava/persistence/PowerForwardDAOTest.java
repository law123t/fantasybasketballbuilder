package matc.madjava.persistence;

import matc.madjava.entity.PowerForward;
import matc.madjava.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PowerForwardDAOTest {
    private final Logger log = LogManager.getLogger(this.getClass());
    GenericDAO genericDAO;

    @BeforeEach
    void setUp() {
        Database database = matc.madjava.util.Database.getInstance();
        database.runSQL("cleandb.sql");

        genericDAO = new GenericDAO(PowerForward.class);
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
        PowerForward retrievedPlayer = (PowerForward) genericDAO.getByID(1);
        assertEquals("Anthony", retrievedPlayer.getFirstName());
        assertEquals("Davis", retrievedPlayer.getLastName());
    }

    /**
     * Verify successful insert of a user
     */
    @Test
    void insertSuccess() {

        PowerForward newplayer = new PowerForward(20,"John", "Cena", 1, 1,1,1,1,1);
        int id = genericDAO.insert(newplayer);
        assertNotEquals(0,id);
        PowerForward insertedPG = (PowerForward) genericDAO.getByID(id);
        assertEquals("John", insertedPG.getFirstName(), "first name is not equal");
        assertEquals("Cena", insertedPG.getLastName(), "Last name is not equal");

    }

    @Test
    void updateSuccess(){
        PowerForward updatePlayer = (PowerForward)genericDAO.getByID(1);
        updatePlayer.setLastName("Findme");
        genericDAO.update(updatePlayer);
        PowerForward updatePlayerCheck = (PowerForward)genericDAO.getByID(1);

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
        List<PowerForward> players = genericDAO.getAll();
        assertEquals(1, players.size());
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<PowerForward> players = genericDAO.getByPropertyEqual("firstName", "Anthony");
        assertEquals(1, players.size());
        assertEquals(1, players.get(0).getPowerForwardID());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<PowerForward> pls = genericDAO.getByPropertyLike("lastName", "d");
        for(PowerForward pl : pls) {
            log.info(pl.getLastName());
        }
        assertEquals(1, pls.size());
    }

    /**
     * successful use of specific use case unique finder (equal match)
     */
    @Test
    void getByPropertyEqualUnique() {
        PowerForward pl = (PowerForward)genericDAO.getByPropertyEqualUnique("lastName", "Davis");
        assertEquals("Anthony", pl.getFirstName() );
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyNotEqualSuccess() {
        List<PowerForward> pls = genericDAO.getAllExceptEntity("lastName", "Davis");
        for(PowerForward pl : pls) {
            System.out.println(pl.getLastName());
        }
        assertEquals(0, pls.size());
    }
}