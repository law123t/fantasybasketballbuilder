package matc.madjava.controller;

        import matc.madjava.entity.*;
        import matc.madjava.persistence.*;
        import org.apache.logging.log4j.LogManager;
        import org.apache.logging.log4j.Logger;

        import javax.servlet.RequestDispatcher;
        import javax.servlet.ServletException;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import javax.servlet.annotation.*;
        import javax.servlet.http.HttpSession;
        import java.io.IOException;
        import java.security.Principal;
        import java.util.ArrayList;
        import java.util.List;

/**
 * Servlet for team
 * @author lthao
 */

@WebServlet(
        urlPatterns = {"/createTeam"},
        name = "createTeam"
)

public class CreateTeam extends HttpServlet {
    private final Logger log = LogManager.getLogger(this.getClass());
    private Team team;
    private GenericDAO teamDAO;
    private GenericDAO centerDAO;
    private GenericDAO pointGuardDAO;
    private GenericDAO shootingGuardDAO;
    private GenericDAO smallForwardDAO;
    private GenericDAO powerForwardDAO;
    private GenericDAO userDAO;

    /**
     * This method pulls all players from the database and converts them to string and passes
     * along the Array of objects to be available for the createTeam.jsp
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

        powerForwardDAO = new GenericDAO(PowerForward.class);
        pointGuardDAO = new GenericDAO(PointGuard.class);
        shootingGuardDAO = new GenericDAO(ShootingGuard.class);
        smallForwardDAO = new GenericDAO(SmallForward.class);
        centerDAO = new GenericDAO(Center.class);

        List<PointGuard> pointGuards = pointGuardDAO.getAll();
        List<ShootingGuard> shootingGuards = shootingGuardDAO.getAll();
        List<SmallForward> smallForwards = smallForwardDAO.getAll();
        List<PowerForward> powerForwards = powerForwardDAO.getAll();
        List<Center> centers = centerDAO.getAll();

        List<String> pgByName = new ArrayList<>();
        List<String> sgByName = new ArrayList<>();
        List<String> sfByName = new ArrayList<>();
        List<String> pfByName = new ArrayList<>();
        List<String> cByName = new ArrayList<>();

        for (PointGuard pg : pointGuards) {
            pgByName.add(pg.toString());
        }

        for (ShootingGuard sg : shootingGuards) {
            sgByName.add(sg.toString());
        }
        for (SmallForward sf : smallForwards) {
            sfByName.add(sf.toString());
        }
        for (PowerForward pf : powerForwards) {
            pfByName.add(pf.toString());
        }

        for (Center c : centers) {
            cByName.add(c.toString());
        }

        httpSession.setAttribute("pg_data", pointGuards);
        httpSession.setAttribute("sg_data", shootingGuards);
        httpSession.setAttribute("sf_data", smallForwards);
        httpSession.setAttribute("pf_data", powerForwards);
        httpSession.setAttribute("c_data", centers);

        RequestDispatcher dispatcher = req.getRequestDispatcher("basketballApp/createTeam.jsp");
        dispatcher.forward(req, resp);
    }

    /**
     * This method gets called by an Ajax Post on the createTeam.jsp page and gets player/team
     * information via the Droppable form and inserts a new team accordingly
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

        teamDAO = new GenericDAO(Team.class);
        userDAO = new GenericDAO(User.class);
        powerForwardDAO = new GenericDAO(PowerForward.class);
        pointGuardDAO = new GenericDAO(PointGuard.class);
        shootingGuardDAO = new GenericDAO(ShootingGuard.class);
        smallForwardDAO = new GenericDAO(SmallForward.class);
        centerDAO = new GenericDAO(Center.class);

        team = new Team();

        int idPG = Integer.parseInt(req.getParameter("pointGuard"));
        int idSG = Integer.parseInt(req.getParameter("shootingGuard"));
        int idSF = Integer.parseInt(req.getParameter("smallForward"));
        int idPF = Integer.parseInt(req.getParameter("powerForward"));
        int idC = Integer.parseInt(req.getParameter("center"));
        String teamName = req.getParameter("teamName");

        PointGuard playerOnePG = (PointGuard)pointGuardDAO.getByID(idPG);
        ShootingGuard playerTwoSG = (ShootingGuard)shootingGuardDAO.getByID(idSG);
        SmallForward playerThreeSF = (SmallForward)smallForwardDAO.getByID(idSF);
        PowerForward playerFourPF = (PowerForward)powerForwardDAO.getByID(idPF);
        Center playerFiveC = (Center)centerDAO.getByID(idC);

        Principal principal = req.getUserPrincipal();
        String username = principal.getName();

        User id = (User)userDAO.getByPropertyEqualUnique("userName",username);

        team.setTeamName(teamName);
        team.setPointGuard(playerOnePG);
        team.setShootingGuard(playerTwoSG);
        team.setSmallForward(playerThreeSF);
        team.setPowerForward(playerFourPF);
        team.setCenter(playerFiveC);
        team.setUser(id);

        teamDAO.insert(team);

    }
}
