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
@WebServlet(
        urlPatterns = {"/deleteAdmin"},
        name="deleteAdmin"
)
public class DeleteAdmin extends HttpServlet {
    private final Logger log = LogManager.getLogger(this.getClass());
    GenericDAO genericDAOUser;
    GenericDAO genericDAOUserRole;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

        genericDAOUser = new GenericDAO(User.class);
        genericDAOUserRole = new GenericDAO(UserRoles.class);

        String checkPass = req.getParameter("checkpass").trim();
        int toDelete = Integer.parseInt(req.getParameter("passadmin"));
        User user = (User)genericDAOUser.getByID(toDelete);
        String userName = user.getUserName();
        String userPass = user.getUserPass();

        if(checkPass.equals(userPass)) {
            genericDAOUser.delete(user);
            req.setAttribute("message_admin", userName + " has been deleted!");
            RequestDispatcher dispatcher = req.getRequestDispatcher("basketballApp/basketballApp-Admin/admin.jsp");
            dispatcher.forward(req, resp);
        } else {
            req.setAttribute("message_admin", "Passwords dont match!");
            RequestDispatcher dispatcher = req.getRequestDispatcher("basketballApp/basketballApp-Admin/admin.jsp");
            dispatcher.forward(req, resp);
        }

    }
}
