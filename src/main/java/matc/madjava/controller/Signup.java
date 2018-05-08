package matc.madjava.controller;

import matc.madjava.entity.*;
import matc.madjava.persistence.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * Servlet for team
 * @author lthao
 */

@WebServlet(
        urlPatterns = {"/signup"},
        name = "signup"
)

public class Signup extends HttpServlet {
    private final Logger log = LogManager.getLogger(this.getClass());
    GenericDAO genericDAOUser;
    GenericDAO getGenericDAOUserRole;
    User user;
    UserRoles userRoles;

    /**
     * Simple redirect to signup.jsp
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("signup.jsp");
        dispatcher.forward(req, resp);
    }

    /**
     * This method gets parameters and inserts user. Servlet also contains form validation and redirects
     * back to the form with various related error messages. based on adminkey field which's value is
     * determined by the application properties, user is either set to an Admin or a regular user
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

        ServletContext context      = getServletContext();
        Properties properties = (Properties)context.getAttribute("fbbProperties");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String validifier = req.getParameter("admin");

        genericDAOUser = new GenericDAO(User.class);
        getGenericDAOUserRole = new GenericDAO(UserRoles.class);
        user = new User();
        userRoles = new UserRoles();

        List<User> usersEmail = genericDAOUser.getByPropertyEqual("userName", username);
        List<User> usersUsername = genericDAOUser.getByPropertyEqual("email", email);

        int emailBoolean = usersEmail.size();
        int usersBoolean = usersUsername.size();
        boolean key = false;

        if(validifier.equals(properties.getProperty("adminkey"))){
            key = true;
        }

        if (emailBoolean == 0 && usersBoolean == 0 && key) {

            user.setUserName(username);
            user.setUserPass(password);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);

            userRoles.setRoleName("administrator");
            userRoles.setUserName(username);
            userRoles.setUserId(user);

            genericDAOUser.insert(user);
            getGenericDAOUserRole.insert(userRoles);

            log.info(username + " added, redirecting to index");
            String message = username + " Has been Successfully Added as Admin!";
            httpSession.setAttribute("errormessage", message);

            RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
            dispatcher.forward(req, resp);

        } else if (emailBoolean == 0 && usersBoolean == 0) {

            user.setUserName(username);
            user.setUserPass(password);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);

            userRoles.setRoleName("user");
            userRoles.setUserName(username);
            userRoles.setUserId(user);

            genericDAOUser.insert(user);
            getGenericDAOUserRole.insert(userRoles);
            log.info(username + " added, redirecting to index");
            String message = username + " Has been Successfully Added as a User!";
            httpSession.setAttribute("errormessage", message);

            RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
            dispatcher.forward(req, resp);

        } else if(emailBoolean == 0 && usersBoolean == 1) {
            log.info("User exists! redirecting to signup");
            String message = "Email exists! Please Try again";
            httpSession.setAttribute("errormessage", message);
            RequestDispatcher dispatcher = req.getRequestDispatcher("signup.jsp");
            dispatcher.forward(req, resp);

        } else if(emailBoolean == 1 && usersBoolean == 0) {
            log.info("Email exists! redirecting to signup");
            String message = " User exists! please Try again";
            httpSession.setAttribute("errormessage", message);
            RequestDispatcher dispatcher = req.getRequestDispatcher("signup.jsp");
            dispatcher.forward(req, resp);

        } else if(emailBoolean == 1 && usersBoolean == 1){
            log.info("Email and Username exists! redirecting to signup");
            String message = "Email and Username exists! please Try again";
            httpSession.setAttribute("errormessage", message);
            RequestDispatcher dispatcher = req.getRequestDispatcher("signup.jsp");
            dispatcher.forward(req, resp);

        } else if(emailBoolean > 1 && usersBoolean > 1){
            log.info("Number of emails and users are over 1. fix database.");
            String message = "Username and Emails are out of Whack! contact the DB admin!!!";
            httpSession.setAttribute("errormessage", message);
            RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
            dispatcher.forward(req, resp);
        } else {
            log.info("uh oh. you're in trouble.");
            String message = "An extremely unexpected error has occurred somehow!";
            httpSession.setAttribute("errormessage", message);
            RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
            dispatcher.forward(req, resp);
        }

    }
}
