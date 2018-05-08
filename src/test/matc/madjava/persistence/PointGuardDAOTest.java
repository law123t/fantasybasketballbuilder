package matc.madjava.persistence;

import matc.madjava.entity.PointGuard;
import matc.madjava.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PointGuardDAOTest {

        private final Logger log = LogManager.getLogger(this.getClass());
        GenericDAO genericDAO;

        @BeforeEach
        void setUp() {
            Database database = matc.madjava.util.Database.getInstance();
            database.runSQL("cleandb.sql");

            genericDAO = new GenericDAO(PointGuard.class);
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
            PointGuard retrievedUser = (PointGuard) genericDAO.getByID(1);
            assertEquals("Russel", retrievedUser.getFirstName());
            assertEquals("Westbrook", retrievedUser.getLastName());
        }

        /**
         * Verify successful insert of a user
         */
        @Test
        void insertSuccess() {

            PointGuard newpg = new PointGuard(20,"John", "Cena", 1, 1,1,1,1,1);
            int id = genericDAO.insert(newpg);
            assertNotEquals(0,id);
            PointGuard insertedPG = (PointGuard) genericDAO.getByID(id);
            assertEquals("John", insertedPG.getFirstName(), "first name is not equal");
            assertEquals("Cena", insertedPG.getLastName(), "Last name is not equal");

        }

        @Test
        void updateSuccess(){
            PointGuard updateUser = (PointGuard)genericDAO.getByID(1);
            updateUser.setLastName("Findme");
            genericDAO.update(updateUser);
            PointGuard updatePGCheck = (PointGuard)genericDAO.getByID(1);

            assertEquals("Findme", updatePGCheck.getLastName());

        }
        /**
         * Verify successful delete of user
         */
        @Test
        void deleteSuccess() {
            genericDAO.delete((genericDAO.getByID(2)));
            assertNull(genericDAO.getByID(2));
        }

        /**
         * Verify successful retrieval of all users
         */
        @Test
        void getAllSuccess() {
            List<PointGuard> users = genericDAO.getAll();
            assertEquals(2, users.size());
        }

        /**
         * Verify successful get by property (equal match)
         */
        @Test
        void getByPropertyEqualSuccess() {
            List<PointGuard> users = genericDAO.getByPropertyEqual("lastName", "Curry");
            assertEquals(1, users.size());
            assertEquals(2, users.get(0).getPointGuardID());
        }

        /**
         * Verify successful get by property (like match)
         */
        @Test
        void getByPropertyLikeSuccess() {
            List<PointGuard> pgs = genericDAO.getByPropertyLike("lastName", "c");
            for(PointGuard pg : pgs) {
                log.info(pg.getLastName());
            }
            assertEquals(1, pgs.size());
        }

        /**
         * successful use of specific use case unique finder (equal match)
         */
        @Test
        void getByPropertyEqualUnique() {
            PointGuard pg = (PointGuard)genericDAO.getByPropertyEqualUnique("lastName", "Curry");
            assertEquals("Stephen", pg.getFirstName() );
        }

        /**
         * Verify successful get by property (equal match)
         */
        @Test
        void getByPropertyNotEqualSuccess() {
            List<PointGuard> pgs = genericDAO.getAllExceptEntity("lastName", "Curry");
            for(PointGuard pg : pgs) {
                System.out.println(pg.getLastName());
            }
            assertEquals(1, pgs.size());
        }

    }