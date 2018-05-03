package matc.madjava.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


/**
 *
 *
 *@author    Your Name Here
 */
@WebServlet(
        name = "appStartup",
        urlPatterns = {"/appStartup"},
        loadOnStartup = 1
) public class AppStartup extends HttpServlet {
    private final Logger log = LogManager.getLogger(this.getClass());
    private Properties properties;
    /**
     *  Handles HTTP GET requests.
     *
     *@param  request               the HttpRequest
     *@param  response              the HttpResponse
     *@exception  ServletException  if there is a general
     *                              servlet exception
     *@exception  IOException       if there is a general
     *                              I/O exception
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    public void init() throws ServletException {

        loadProperties("/fantasybasketballbuilder.properties");
        ServletContext context = getServletContext();
        context.setAttribute("fbbProperties", properties);
    }


    private void loadProperties(String propertiesFilePath) {
        properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream(propertiesFilePath));
        } catch (IOException ioException) {
            log.error(ioException);
        } catch (Exception exception) {
            log.error(exception);
        }
    }
}