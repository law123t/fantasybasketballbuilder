package matc.madjava.controller;

import matc.madjava.entity.*;
import matc.madjava.persistence.*;
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
import java.util.Set;

@WebServlet(
        urlPatterns = {"/teamSelector"},
        name = "teamSelector"
)
public class TeamSelector extends HttpServlet {

    private GenericDAO teamDAO;
    private GenericDAO userDAO;
    private final Logger log = LogManager.getLogger(this.getClass());

    /**
     * This method gets logged in user and all users teams, and returns them as a array of teams to the teamselector.jsp
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

        teamDAO = new GenericDAO(Team.class);
        userDAO = new GenericDAO(User.class);

        Principal principal = req.getUserPrincipal();
        String username = principal.getName();

        User user = (User)userDAO.getByPropertyEqualUnique("userName",username);


        Set<Team> teams = user.getTeams();

        List<String> teamsByName = new ArrayList<>();

        for (Team team : teams) {
            teamsByName.add(team.toString());
        }

        httpSession.setAttribute("team_data", teams);


        RequestDispatcher dispatcher = req.getRequestDispatcher("basketballApp/teamsSelector.jsp");
        dispatcher.forward(req, resp);
    }

}
