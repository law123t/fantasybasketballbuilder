package matc.madjava.controller;

import matc.madjava.entity.User;
import matc.madjava.entity.UserRoles;
import matc.madjava.persistence.GenericDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.Principal;

@WebServlet(
        urlPatterns={"/checkadmin"},
        name="checkadmin"
)
public class CheckAdmin extends HttpServlet {
    GenericDAO genericDAOUserRole;
    UserRoles userRoles;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

        genericDAOUserRole = new GenericDAO(UserRoles.class);

        Principal principal = req.getUserPrincipal();
        String username = principal.getName();

        userRoles = (UserRoles)genericDAOUserRole.getByPropertyEqualUnique("userName", username);

        String userRights = userRoles.getRoleName().trim();


        if (!userRights.equals("administrator")){
            req.setAttribute("message", username + " is not an Administrator");
            RequestDispatcher dispatcher = req.getRequestDispatcher("appIndex.jsp");
            dispatcher.forward(req, resp);
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("basketballApp/basketballApp-Admin/admin.jsp");
            dispatcher.forward(req, resp);
        }

    }

}
