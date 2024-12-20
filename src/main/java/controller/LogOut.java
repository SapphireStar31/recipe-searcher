package controller;

import utilities.PropertiesLoader;
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
import java.util.Properties;


/**
 * Begins the log-out process using AWS Cognito.
 *
 * @author Karissa
 */
@WebServlet(
        urlPatterns = {"/log-out"}
)

public class LogOut extends HttpServlet implements PropertiesLoader {
    Properties properties;
    private final Logger logger = LogManager.getLogger(this.getClass());
    public static String CLIENT_ID;
    public static String LOGOUT_URL;
    public static String REDIRECT_URL;

    @Override
    public void init() throws ServletException {
        super.init();
        loadProperties();
    }

    /**
     * Read in the cognito props file and get the client id and required urls
     * for logging out a user.
     */
    // 4 to do this work a single time and put the properties in the application scope
    private void loadProperties() {
        try {
            properties = loadProperties("/cognito.properties");
            CLIENT_ID = properties.getProperty("client.id");
            LOGOUT_URL = properties.getProperty("logoutURL");
            REDIRECT_URL = properties.getProperty("logoutURI");
        } catch (IOException ioException) {
            logger.error("Cannot load properties...{}", ioException.getMessage(), ioException);
        } catch (Exception e) {
            logger.error("Error loading properties{}", e.getMessage(), e);
        }
    }

    /**
     * Route to the aws-hosted cognito log out page.
     * @param req servlet request
     * @param resp servlet response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (properties.isEmpty() || CLIENT_ID == null || LOGOUT_URL == null || REDIRECT_URL == null) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/error.jsp");
            dispatcher.forward(req, resp);
        }
        HttpSession session = req.getSession();
        session.removeAttribute("userName");
        session.removeAttribute("fullName");
        session.removeAttribute("userEmail");
        session.removeAttribute("userInfo");

        String url = LOGOUT_URL + "?client_id=" + CLIENT_ID + "&logout_uri=" + REDIRECT_URL;
        resp.sendRedirect(url);
    }
}

