package matc.madjava.persistence;

import matc.madjava.entity.SmallForward;
import matc.madjava.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SmallForwardDAOTest {
    private final Logger log = LogManager.getLogger(this.getClass());
    GenericDAO genericDAO;

    @BeforeEach
    void setUp() {
        Database database = matc.madjava.util.Database.getInstance();
        database.runSQL("cleandb.sql");

        genericDAO = new GenericDAO(SmallForward.class);
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
        SmallForward retrievedPlayer = (SmallForward) genericDAO.getByID(1);
        assertEquals("Lebron", retrievedPlayer.getFirstName());
        assertEquals("James", retrievedPlayer.getLastName());
    }

    /**
     * Verify successful insert of a user
     */
    @Test
    void insertSuccess() {

        SmallForward newplayer = new SmallForward(20,"John", "Cena", 1, 1,1,1,1,1);
        int id = genericDAO.insert(newplayer);
        assertNotEquals(0,id);
        SmallForward insertedPG = (SmallForward) genericDAO.getByID(id);
        assertEquals("John", insertedPG.getFirstName(), "first name is not equal");
        assertEquals("Cena", insertedPG.getLastName(), "Last name is not equal");

    }

    @Test
    void updateSuccess(){
        SmallForward updatePlayer = (SmallForward)genericDAO.getByID(1);
        updatePlayer.setLastName("Findme");
        genericDAO.update(updatePlayer);
        SmallForward updatePlayerCheck = (SmallForward)genericDAO.getByID(1);

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
        List<SmallForward> players = genericDAO.getAll();
        assertEquals(2, players.size());
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<SmallForward> players = genericDAO.getByPropertyEqual("firstName", "Lebron");
        assertEquals(1, players.size());
        assertEquals(1, players.get(0).getSmallForwardID());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<SmallForward> pls = genericDAO.getByPropertyLike("lastName", "J");
        for(SmallForward pl : pls) {
            log.info(pl.getLastName());
        }
        assertEquals(1, pls.size());
    }

    /**
     * successful use of specific use case unique finder (equal match)
     */
    @Test
    void getByPropertyEqualUnique() {
        SmallForward pl = (SmallForward)genericDAO.getByPropertyEqualUnique("lastName", "James");
        assertEquals("Lebron", pl.getFirstName() );
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyNotEqualSuccess() {
        List<SmallForward> pls = genericDAO.getAllExceptEntity("lastName", "James");
        for(SmallForward pl : pls) {
            System.out.println(pl.getLastName());
        }
        assertEquals(1, pls.size());
    }
}