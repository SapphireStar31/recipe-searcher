package persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import spoonacularapi.ComplexSearch;
import spoonacularapi.ComplexSearchResults;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpoonacularAPITest {
//    @Test
//    public void testSpoonacularJSON() throws Exception {
//        Client client = ClientBuilder.newClient();
//        WebTarget target =
//                client.target("https://api.spoonacular.com/recipes/complexSearch?apiKey=3626f4a0278e4e72801180ab85ddda95&query=crepe&number=1&sort=popularity");
//        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
//
//        ObjectMapper mapper = new ObjectMapper();
//
//        ComplexSearch complexSearch = null;
//
//        try {
//            complexSearch = mapper.readValue(response, ComplexSearch.class);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//
//        List<ComplexSearchResults> allRecipeResults = complexSearch.getResults();
//        ComplexSearchResults searchResults = allRecipeResults.get(0);
//
//        int expectedResults = 16;
//        String expectedRecipeTitle = "Strawberry Cheesecake Chocolate Crepes";
//
//        assertEquals(expectedResults, complexSearch.getTotalResults());
//        assertEquals(expectedRecipeTitle, searchResults.getTitle());
//    }
}
