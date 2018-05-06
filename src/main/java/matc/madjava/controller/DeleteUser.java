package matc.madjava.controller;

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
        urlPatterns={"/deleteUser"},
        name="deleteUser"
)

public class DeleteUser extends HttpServlet {
    private final Logger log = LogManager.getLogger(this.getClass());
    GenericDAO genericDAOUser;
    GenericDAO genericDAOUserRole;
    UserRoles userRoles;
    User user;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        genericDAOUser = new GenericDAO(User.class);

        Principal principal = req.getUserPrincipal();
        String username = principal.getName();

        List<User> users = genericDAOUser.getAllExceptEntity("userName", username);

        List<String> userByName = new ArrayList<>();

        for (User userName : users) {
            userByName.add(userName.toString());
        }

        httpSession.setAttribute("user_data", users);


        RequestDispatcher dispatcher = req.getRequestDispatcher("basketballApp/basketballApp-Admin/deleteUser.jsp");
        dispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

        genericDAOUser = new GenericDAO(User.class);
        genericDAOUserRole = new GenericDAO(UserRoles.class);

        int toDelete =  Integer.parseInt(req.getParameter("deleteuser"));
        log.info(toDelete);

        Principal principal = req.getUserPrincipal();
        String username = principal.getName();

        user = (User)genericDAOUser.getByPropertyEqualUnique("userName",username);
        int userID = user.getUserId();

        User deleteUser = (User)genericDAOUser.getByID(toDelete);
        int deleteUserId = deleteUser.getUserId();
        String deleteUserName = deleteUser.getUserName();
        String user = deleteUser.getUserName();

        userRoles = (UserRoles)genericDAOUserRole.getByPropertyEqualUnique("userName", username);

        String userRights = userRoles.getRoleName().trim();

        if (userRights.equals("user")) {
            genericDAOUser.delete(deleteUser);
            req.setAttribute("message_admin", user + " has been delete!");
            RequestDispatcher dispatcher = req.getRequestDispatcher("basketballApp/basketballApp-Admin/admin.jsp");
            dispatcher.forward(req, resp);
        } else if (userRights.equals("administrator")) {
            req.setAttribute("adminvalue",  deleteUser);
            RequestDispatcher dispatcher = req.getRequestDispatcher("basketballApp/basketballApp-Admin/adminpasscheck.jsp");
            dispatcher.forward(req, resp);
        } else {
            req.setAttribute("message_admin", "Something Went Wrong!");
            RequestDispatcher dispatcher = req.getRequestDispatcher("basketballApp/basketballApp-Admin/admin.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
