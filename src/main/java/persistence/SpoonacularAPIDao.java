package persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import spoonacularapi.*;
import utilities.PropertiesLoader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SpoonacularAPIDao implements PropertiesLoader {
    private final Logger logger = LogManager.getLogger(this.getClass());
    Properties properties;
    String SPOONACULAR_URL;
    String API_KEY;
    String NUMBER_OF_SEARCH_RESULTS;
    String SORT_CRITERIA;


    /**
     * This method will bring in a string of a recipe and use that to query the
     * Spoonacular API and return recipes related to it.
     * @param searchQuery the recipe being searched
     * @return a list of three related recipes
     */
    public List<ComplexSearchResults> searchAndGetResults(String searchQuery) {
        loadProperties();
        String encodedSearch = URLEncoder.encode(searchQuery, StandardCharsets.UTF_8);
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target(SPOONACULAR_URL + "apiKey=" + API_KEY
                        + "&query=" + encodedSearch
                        + "&number=" + NUMBER_OF_SEARCH_RESULTS
                        + "&sort=" + SORT_CRITERIA);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        ComplexSearch complexSearch = null;

        try {
            complexSearch = mapper.readValue(response, ComplexSearch.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return complexSearch.getResults();
    }


    /**
     * Read in the spoonacularapi properties file and loads up the api key.
     */
    private void loadProperties() {
        try {
            properties = loadProperties("/spoonacularapi.properties");
            SPOONACULAR_URL = properties.getProperty("spoonacular.url");
            API_KEY = properties.getProperty("api.key");
            NUMBER_OF_SEARCH_RESULTS = properties.getProperty("number.of.results.to.return");
            SORT_CRITERIA = properties.getProperty("sort.criteria");
        } catch (IOException ioException) {
            logger.error("Cannot load properties...{}", ioException.getMessage(), ioException);
        } catch (Exception e) {
            logger.error("Error loading properties {}", e.getMessage(), e);
        }
    }
}
