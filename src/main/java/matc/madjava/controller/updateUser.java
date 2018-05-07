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
import java.util.List;

@WebServlet(
        urlPatterns = {"/updateUser"},
        name="updateUser"
)
public class updateUser extends HttpServlet {
    GenericDAO genericDAOUser;
    GenericDAO genericDAOTeam;
    User user;
    private final Logger log = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        user = new User();
        genericDAOUser = new GenericDAO(User.class);
        GenericDAO genericDAOUserRoles = new GenericDAO(UserRoles.class);

        Principal principal = req.getUserPrincipal();
        String username = principal.getName();
        user = (User)genericDAOUser.getByPropertyEqualUnique("userName",username);
        UserRoles userRole = (UserRoles)genericDAOUserRoles.getByPropertyEqualUnique("userName",username);
        log.info(user);
        String itemToUpdate = req.getParameter("updatedata").trim();
        String updateTo = req.getParameter("updatevalue").trim();
        String checkPass = req.getParameter("checkpassword").trim();
        log.info(updateTo);

        if(itemToUpdate.equals("firstname")) {
            user.setFirstName(updateTo);
            genericDAOUser.update(user);
            httpSession.setAttribute("message", "First Name Updated To " + updateTo);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/appIndex.jsp");
            dispatcher.forward(req, resp);

        } else if(itemToUpdate.equals("lastname")){
            user.setLastName(updateTo);
            genericDAOUser.update(user);
            httpSession.setAttribute("message", "Last Name Updated To " + updateTo);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/appIndex.jsp");
            dispatcher.forward(req, resp);

        } else if(itemToUpdate.equals("email")) {
            user.setEmail(updateTo);
            genericDAOUser.update(user);
            httpSession.setAttribute("message", "Email Updated To " + updateTo);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/appIndex.jsp");
            dispatcher.forward(req, resp);

        } else if(itemToUpdate.equals("password")) {
            if (checkPass.equals(user.getUserPass())) {
                user.setUserPass(updateTo);
                genericDAOUser.update(user);
                httpSession.setAttribute("message", "Password has been Updated");
                RequestDispatcher dispatcher = req.getRequestDispatcher("/appIndex.jsp");
                dispatcher.forward(req, resp);
            } else {
                httpSession.setAttribute("message", "Enter Correct Password");
                RequestDispatcher dispatcher = req.getRequestDispatcher("/appIndex.jsp");
                dispatcher.forward(req, resp);
            }
        } else {
            httpSession.setAttribute("message_update", "Something Went Wrong!");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/fantasybasketballbuilder/appIndex.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
