package matc.madjava.controller;

import matc.madjava.entity.*;
import matc.madjava.persistence.GenericDAO;
import matc.madjava.util.Functions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet (
        urlPatterns = {"/viewUser"},
        name="viewUser"
)

public class ViewUser  extends HttpServlet {

    private Team myteam;
    private Functions functions;
    private GenericDAO teamDAO;
    private final Logger log = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        functions = new Functions();

        myteam = new Team();
        teamDAO = new GenericDAO(Team.class);

        int team = Integer.parseInt(req.getParameter("team"));
        log.info(team);
        log.info(req.getParameter("team"));
        myteam = (Team)teamDAO.getByID(team);

        PointGuard pointGuard = myteam.getPointGuard();
        ShootingGuard shootingGuard = myteam.getShootingGuard();
        SmallForward smallForward = myteam.getSmallForward();
        PowerForward powerForward = myteam.getPowerForward();
        Center center = myteam.getCenter();
        String teamName = myteam.getTeamName();

        String pgFirstName = pointGuard.getFirstName();
        String pgLastName = pointGuard.getLastName();

        String sgFirstName = shootingGuard.getFirstName();
        String sgLastName = shootingGuard.getLastName();

        String sfFirstName = smallForward.getFirstName();
        String sfLastName = smallForward.getLastName();

        String pfFirstName = powerForward.getFirstName();
        String pfLastName = powerForward.getLastName();

        String cFirstName = center.getFirstName();
        String cLastName = center.getLastName();

        httpSession.setAttribute("teamName", teamName);
        httpSession.setAttribute("pgFirstName", pgFirstName);
        httpSession.setAttribute("pgLastName", pgLastName);

        httpSession.setAttribute("sgFirstName", sgFirstName);
        httpSession.setAttribute("sgLastName", sgLastName);

        httpSession.setAttribute("sfFirstName", sfFirstName);
        httpSession.setAttribute("sfLastName", sfLastName);

        httpSession.setAttribute("pfFirstName", pfFirstName);
        httpSession.setAttribute("pfLastName", pfLastName);

        httpSession.setAttribute("cFirstName", cFirstName);
        httpSession.setAttribute("cLastName", cLastName);

        //httpSession.setAttribute("teamPoints", teamPoints);

        RequestDispatcher dispatcher = req.getRequestDispatcher("basketballApp/viewTeams.jsp");
        dispatcher.forward(req, resp);
    }
}
