package matc.madjava.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.youtube.APIResponse;
import com.google.youtube.ItemsItem;
import matc.madjava.entity.UserRoles;
import matc.madjava.persistence.GenericDAO;
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
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


@WebServlet(
        urlPatterns = {"/loadapi"},
        name ="loadapi"
)
public class LoadAPI extends HttpServlet {

    private final Logger log = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        HttpSession session = req.getSession();
        ServletContext context      = getServletContext();
        Properties properties = (Properties)context.getAttribute("fbbProperties");

        String key = properties.getProperty("key");
        String part = properties.getProperty("part");
        String maxResults = properties.getProperty("maxResults");
        String channelId = properties.getProperty("channelId");
        int playlistIDDetermine = Integer.parseInt(properties.getProperty("playlistIDDetermine"));


        Client client = ClientBuilder.newClient();


        WebTarget target = client.target("https://www.googleapis.com/youtube/v3/playlists?key=AIzaSyD6O_2WJ-IlAjmAB_cd7hL9t4mX4b7WDUo%0D%0A&part=snippet&maxResults=20&channelId=UCoh_z6QB0AGB1oxWufvbDUg");

        String webResponse = target.request(MediaType.APPLICATION_JSON).get(String.class);

        log.info(webResponse);

        APIResponse response = mapper.readValue(webResponse, APIResponse.class);
        String playlistId = response.getItems().get(playlistIDDetermine).getId();


        session.setAttribute("playlistID", playlistId);
        resp.sendRedirect("appIndex.jsp");

    }
}