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
import java.util.Set;

@WebServlet(
        urlPatterns={"/deleteuser"},
        name="deleteuser"
)

public class DeleteUser extends HttpServlet {
    private final Logger log = LogManager.getLogger(this.getClass());
    GenericDAO genericDAOUser;
    GenericDAO getGenericDAOUserRole;
    User user;
    UserRoles userRoles;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        genericDAOUser = new GenericDAO(User.class);

        Principal principal = req.getUserPrincipal();
        String username = principal.getName();

        User user = (User)genericDAOUser.getByPropertyEqualUnique("userName",username);

        List<User> users = genericDAOUser.getAll();

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

        int toDelete =  Integer.parseInt(req.getParameter("deleteuser"));
        log.info(toDelete);

        User deleteUser = (User)genericDAOUser.getByID(toDelete);
        String user = deleteUser.getUserName();
        genericDAOUser.delete(deleteUser);

        req.setAttribute("message_admin", user + " has been delete!");
        RequestDispatcher dispatcher = req.getRequestDispatcher("basketballApp/basketballApp-Admin/admin.jsp");
        dispatcher.forward(req, resp);
    }
}
