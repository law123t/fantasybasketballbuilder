package matc.madjava.persistence;

import matc.madjava.entity.*;
import matc.madjava.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TeamDAOTest {
    GenericDAO genericTeamDAO;


    private final Logger log = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        Database database = matc.madjava.util.Database.getInstance();
        database.runSQL("cleandb.sql");

        genericTeamDAO = new GenericDAO(Team.class);

    }

    @AfterEach
    void tearDown() {
        Database database = matc.madjava.util.Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verify successful retrieval of a team
     */
    @Test
    void getByIdSuccess() {
        Team retrievedUser = (Team)genericTeamDAO.getByID(1);
        assertEquals("Team One", retrievedUser.getTeamName());

    }

    /**
     * Verify successful insert of a team
     */
    @Test
    void insertSuccess() {
        GenericDAO genericDAOUser = new GenericDAO(User.class);
        GenericDAO genericDAOPG = new GenericDAO(PointGuard.class);
        GenericDAO genericDAOSG = new GenericDAO(ShootingGuard.class);
        GenericDAO genericDAOPF = new GenericDAO(PowerForward.class);
        GenericDAO genericDAOSF = new GenericDAO(SmallForward.class);
        GenericDAO genericDAOC = new GenericDAO(Center.class);

        Center c = (Center)genericDAOC.getByID(1);
        SmallForward sf = (SmallForward)genericDAOSF.getByID(1);
        PowerForward pf = (PowerForward)genericDAOPF.getByID(1);
        ShootingGuard sg = (ShootingGuard)genericDAOSG.getByID(1);
        PointGuard pg = (PointGuard)genericDAOPG.getByID(1);
        User user = (User)genericDAOUser.getByID(1);


        Team newTeam = new Team("testname",2, pg, sg, sf, pf, c, user);
        int id = genericTeamDAO.insert(newTeam);
        assertNotEquals(0,id);
        Team insertedTeam = (Team)genericTeamDAO.getByID(id);
        assertEquals("testname", insertedTeam.getTeamName(), "first name is not equal");
        assertEquals(2,genericTeamDAO.getAll().size());


    }

    /**
     * Verify successful delete of user
     */
    @Test
    void deleteSuccess() {
        genericTeamDAO.delete((genericTeamDAO.getByID(1)));
        assertNull(genericTeamDAO.getByID(1));
    }

    /**
     * Verify successful retrieval of all users
     */
    @Test
    void getAllSuccess() {
        List<Team> teams = genericTeamDAO.getAll();
        assertEquals(1, teams.size());
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Team> teams = genericTeamDAO.getByPropertyEqual("teamName", "Team One");
        assertEquals(1,teams.size());
        assertEquals(1, teams.get(0).getTeamID());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Team> teams = genericTeamDAO.getByPropertyLike("teamName", "Tea");
        assertEquals(1, teams.size());
    }

    /**
     * successful use of specific use case unique finder (equal match)
     */
    @Test
    void getByPropertyEqualUnique() {
        Team team= (Team)genericTeamDAO.getByPropertyEqualUnique("teamName", "Team One");
        assertEquals("Team One", team.getTeamName() );
    }

    @Test
    void getByPropertyEqualObject() {
        GenericDAO genericUserDAO = new GenericDAO(User.class);
        User user = (User)genericUserDAO.getByID(1);
        List<Team> userTeams = genericTeamDAO.getByPropertyEqualObject("userId", user);

        assertEquals(2, userTeams.size());
        assertNotNull(userTeams, "Teams are null");

    }

    @Test
    void getByPropertyNotEqualSuccess() {
        List<Team> teams = genericTeamDAO.getAllExceptEntity("teamName", "Team One");
        for(Team team : teams) {
            System.out.println(team.getTeamName());
        }
        assertEquals(0, teams.size());
    }
}
