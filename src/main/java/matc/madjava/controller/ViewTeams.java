package matc.madjava.controller;

import matc.madjava.entity.*;
import matc.madjava.persistence.*;
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
import java.security.Principal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@WebServlet(
        urlPatterns = {"/viewTeams"},
        name = "viewTeams"
)
public class ViewTeams extends HttpServlet {

    private Team myteam;
    private Functions functions;
    private GenericDAO teamDAO;
    private final Logger log = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

        String validation = req.getParameter("team");

        if (validation.equals("")|| validation == null) {

            httpSession.setAttribute("message", "Create a Team First!");

            RequestDispatcher dispatcher = req.getRequestDispatcher("basketballApp/createTeam.jsp");
            dispatcher.forward(req, resp);

        } else {
            functions = new Functions();

            myteam = new Team();
            teamDAO = new GenericDAO(Team.class);

            int team = Integer.parseInt(req.getParameter("team"));
            log.info(team);
            log.info(req.getParameter("team"));
            myteam = (Team) teamDAO.getByID(team);
            DecimalFormat df = new DecimalFormat("#.00");

            PointGuard pointGuard = myteam.getPointGuard();
            ShootingGuard shootingGuard = myteam.getShootingGuard();
            SmallForward smallForward = myteam.getSmallForward();
            PowerForward powerForward = myteam.getPowerForward();
            Center center = myteam.getCenter();
            String teamName = myteam.getTeamName();

            String pgFirstName = pointGuard.getFirstName();
            String pgLastName = pointGuard.getLastName();
            int pgPoints = pointGuard.getPoints();
            int pgAssists = pointGuard.getAssists();
            int pgRebounds = pointGuard.getRebounds();
            int pgSteals = pointGuard.getSteals();
            int pgBlocks = pointGuard.getBlocks();
            int pgTurnovers = pointGuard.getTurnovers();
            long rawPGTotal = functions.calculatePlayerPoints(pgPoints, pgAssists, pgRebounds, pgSteals, pgBlocks, pgTurnovers);
            String pgTotal = df.format(rawPGTotal);

            String sgFirstName = shootingGuard.getFirstName();
            String sgLastName = shootingGuard.getLastName();
            int sgPoints = shootingGuard.getPoints();
            int sgAssists = shootingGuard.getAssists();
            int sgRebounds = shootingGuard.getRebounds();
            int sgSteals = shootingGuard.getSteals();
            int sgBlocks = shootingGuard.getBlocks();
            int sgTurnovers = shootingGuard.getTurnovers();
            long rawSGTotal = functions.calculatePlayerPoints(sgPoints, sgAssists, sgRebounds, sgSteals, sgBlocks, sgTurnovers);
            String sgTotal = df.format(rawSGTotal);

            String sfFirstName = smallForward.getFirstName();
            String sfLastName = smallForward.getLastName();
            int sfPoints = smallForward.getPoints();
            int sfAssists = smallForward.getAssists();
            int sfRebounds = smallForward.getRebounds();
            int sfSteals = smallForward.getSteals();
            int sfBlocks = smallForward.getBlocks();
            int sfTurnovers = smallForward.getTurnovers();
            long rawSFTotal = functions.calculatePlayerPoints(sfPoints, sfAssists, sfRebounds, sfSteals, sfBlocks, sfTurnovers);
            String sfTotal = df.format(rawSFTotal);

            String pfFirstName = powerForward.getFirstName();
            String pfLastName = powerForward.getLastName();
            int pfPoints = powerForward.getPoints();
            int pfAssists = powerForward.getAssists();
            int pfRebounds = powerForward.getRebounds();
            int pfSteals = powerForward.getSteals();
            int pfBlocks = powerForward.getBlocks();
            int pfTurnovers = powerForward.getTurnovers();
            long rawPFTotal = functions.calculatePlayerPoints(pfPoints, pfAssists, pfRebounds, pfSteals, pfBlocks, pfTurnovers);
            String pfTotal = df.format(rawPFTotal);

            String cFirstName = center.getFirstName();
            String cLastName = center.getLastName();
            int cPoints = center.getPoints();
            int cAssists = center.getAssists();
            int cRebounds = center.getRebounds();
            int cSteals = center.getSteals();
            int cBlocks = center.getBlocks();
            int cTurnovers = center.getTurnovers();
            long rawCTotal = functions.calculatePlayerPoints(cPoints, cAssists, cRebounds, cSteals, cBlocks, cTurnovers);
            String cTotal = df.format(rawCTotal);

            long rawTeamTotal = functions.calculateTotalPoints(rawPGTotal, rawSGTotal, rawSFTotal, rawPFTotal, rawCTotal);
            String teamPoints = df.format(rawTeamTotal);


            httpSession.setAttribute("teamName", teamName);
            httpSession.setAttribute("pgFirstName", pgFirstName);
            httpSession.setAttribute("pgLastName", pgLastName);
            httpSession.setAttribute("pgPoints", pgPoints);
            httpSession.setAttribute("pgAssists", pgAssists);
            httpSession.setAttribute("pgRebounds", pgRebounds);
            httpSession.setAttribute("pgSteals", pgSteals);
            httpSession.setAttribute("pgBlocks", pgBlocks);
            httpSession.setAttribute("pgTurnovers", pgTurnovers);
            httpSession.setAttribute("pgTotal", pgTotal);

            httpSession.setAttribute("sgFirstName", sgFirstName);
            httpSession.setAttribute("sgLastName", sgLastName);
            httpSession.setAttribute("sgPoints", sgPoints);
            httpSession.setAttribute("sgAssists", sgAssists);
            httpSession.setAttribute("sgRebounds", sgRebounds);
            httpSession.setAttribute("sgSteals", sgSteals);
            httpSession.setAttribute("sgBlocks", sgBlocks);
            httpSession.setAttribute("sgTurnovers", sgTurnovers);
            httpSession.setAttribute("sgTotal", sgTotal);

            httpSession.setAttribute("sfFirstName", sfFirstName);
            httpSession.setAttribute("sfLastName", sfLastName);
            httpSession.setAttribute("sfPoints", sfPoints);
            httpSession.setAttribute("sfAssists", sfAssists);
            httpSession.setAttribute("sfRebounds", sfRebounds);
            httpSession.setAttribute("sfSteals", sfSteals);
            httpSession.setAttribute("sfBlocks", sfBlocks);
            httpSession.setAttribute("sfTurnovers", sfTurnovers);
            httpSession.setAttribute("sfTotal", sfTotal);

            httpSession.setAttribute("pfFirstName", pfFirstName);
            httpSession.setAttribute("pfLastName", pfLastName);
            httpSession.setAttribute("pfPoints", pfPoints);
            httpSession.setAttribute("pfAssists", pfAssists);
            httpSession.setAttribute("pfRebounds", pfRebounds);
            httpSession.setAttribute("pfSteals", pfSteals);
            httpSession.setAttribute("pfBlocks", pfBlocks);
            httpSession.setAttribute("pfTurnovers", pfTurnovers);
            httpSession.setAttribute("pfTotal", pfTotal);

            httpSession.setAttribute("cFirstName", cFirstName);
            httpSession.setAttribute("cLastName", cLastName);
            httpSession.setAttribute("cPoints", cPoints);
            httpSession.setAttribute("cAssists", cAssists);
            httpSession.setAttribute("cRebounds", cRebounds);
            httpSession.setAttribute("cSteals", cSteals);
            httpSession.setAttribute("cBlocks", cBlocks);
            httpSession.setAttribute("cTurnovers", cTurnovers);
            httpSession.setAttribute("cTotal", cTotal);

            httpSession.setAttribute("teamPoints", teamPoints);

            RequestDispatcher dispatcher = req.getRequestDispatcher("basketballApp/viewTeams.jsp");
            dispatcher.forward(req, resp);
        }
    }

}
