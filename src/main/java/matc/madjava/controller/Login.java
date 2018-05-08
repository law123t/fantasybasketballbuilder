package matc.madjava.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.youtube.ItemsItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.Response;
import java.io.IOException;
import java.util.Properties;

/**
 * This Class is a controller that allows for TOMCAT authorization
 */

@WebServlet(
        urlPatterns = {"/login"}
)
public class Login extends HttpServlet {

    private final Logger log = LogManager.getLogger(this.getClass());

    /**
     * Redirect to login landing page
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        resp.sendRedirect("loadapi");

    }
}