package matc.madjava.controller;

import matc.madjava.entity.*;
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
import java.util.List;

@WebServlet (
        urlPatterns = {"/viewUser"},
        name="viewUser"
)

public class ViewUser  extends HttpServlet {

    private User user;
    private GenericDAO genericDAOUser;
    private GenericDAO genericDAOTeam;
    private final Logger log = LogManager.getLogger(this.getClass());

    /**
     * Gets User Data and Team Data as objects and sends it to the View Team JSP for displaying and
     * for Updating and Deleting forms
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        user = new User();
        genericDAOUser = new GenericDAO(User.class);
        genericDAOTeam = new GenericDAO(Team.class);
        Principal principal = req.getUserPrincipal();
        String username = principal.getName();

        user = (User)genericDAOUser.getByPropertyEqualUnique("userName",username);
        int userID = user.getUserId();
        user = (User)genericDAOUser.getByID(userID);

        log.info(user);
        log.info(req.getParameter("team"));

        List<Team> userTeams = genericDAOTeam.getByPropertyEqualObject("user", user);
        req.setAttribute("user", user);
        req.setAttribute("userTeams", userTeams);
        req.setAttribute("userTeamsNumber", userTeams.size());

        RequestDispatcher dispatcher = req.getRequestDispatcher("basketballApp/viewUser.jsp");
        dispatcher.forward(req, resp);
    }
}
