package matc.madjava.persistence;

import matc.madjava.entity.Center;
import matc.madjava.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CenterDAOTest {

        private final Logger log = LogManager.getLogger(this.getClass());
        GenericDAO genericDAO;

        @BeforeEach
        void setUp() {
            Database database = matc.madjava.util.Database.getInstance();
            database.runSQL("cleandb.sql");

            genericDAO = new GenericDAO(Center.class);
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
            Center retrievedPlayer = (Center) genericDAO.getByID(1);
            assertEquals("Karl", retrievedPlayer.getFirstName());
            assertEquals("Anthony Towns", retrievedPlayer.getLastName());
        }

        /**
         * Verify successful insert of a user
         */
        @Test
        void insertSuccess() {

            Center newplayer = new Center(20,"John", "Cena", 1, 1,1,1,1,1);
            int id = genericDAO.insert(newplayer);
            assertNotEquals(0,id);
            Center insertedPG = (Center) genericDAO.getByID(id);
            assertEquals("John", insertedPG.getFirstName(), "first name is not equal");
            assertEquals("Cena", insertedPG.getLastName(), "Last name is not equal");

        }

        @Test
        void updateSuccess(){
            Center updatePlayer = (Center)genericDAO.getByID(1);
            updatePlayer.setLastName("Findme");
            genericDAO.update(updatePlayer);
            Center updatePlayerCheck = (Center)genericDAO.getByID(1);

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
            List<Center> players = genericDAO.getAll();
            assertEquals(1, players.size());
        }

        /**
         * Verify successful get by property (equal match)
         */
        @Test
        void getByPropertyEqualSuccess() {
            List<Center> players = genericDAO.getByPropertyLike("firstName", "Karl");
            assertEquals(1, players.size());
            assertEquals(1, players.get(0).getCenterID());
        }

        /**
         * Verify successful get by property (like match)
         */
        @Test
        void getByPropertyLikeSuccess() {
            List<Center> pls = genericDAO.getByPropertyLike("lastName", "t");
            for(Center pl : pls) {
                log.info(pl.getLastName());
            }
            assertEquals(1, pls.size());
        }

        /**
         * successful use of specific use case unique finder (equal match)
         */
        @Test
        void getByPropertyEqualUnique() {
            Center pl = (Center)genericDAO.getByPropertyEqualUnique("lastName", "Anthony Towns");
            assertEquals("Karl", pl.getFirstName() );
        }

        /**
         * Verify successful get by property (equal match)
         */
        @Test
        void getByPropertyNotEqualSuccess() {
            List<Center> pls = genericDAO.getAllExceptEntity("lastName", "Anthony Towns");
            for(Center pl : pls) {
                System.out.println(pl.getLastName());
            }
            assertEquals(0, pls.size());
        }
}