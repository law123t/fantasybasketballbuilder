package matc.madjava.controller;

import matc.madjava.entity.Team;
import matc.madjava.entity.User;
import matc.madjava.entity.UserRoles;
import matc.madjava.persistence.GenericDAO;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet(
        urlPatterns={"/deleteTeam"},
        name="deleteTeam"
)

public class DeleteTeam extends HttpServlet {
    private final Logger log = LogManager.getLogger(this.getClass());
    GenericDAO genericDAOTeam;
    Team team;

    /**
     * This method pulls the id of the team to be deleted and deletes it, it then redirects the user back
     * to the application launch page
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

        genericDAOTeam = new GenericDAO(Team.class);

        int toDelete =  Integer.parseInt(req.getParameter("deleteteam"));
        log.info(toDelete);

        team = (Team)genericDAOTeam.getByID(toDelete);
        String teamname = team.getTeamName();

        genericDAOTeam.delete(team);
        req.setAttribute("message", teamname + " has been delete!");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/appIndex.jsp");
        dispatcher.forward(req, resp);

    }
}
