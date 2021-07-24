package app;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Entry point
 */
@Controller
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    /**
     * Creates a listing in database.
     * @param jsonString A valid listing json string.
     * @return An error or success json object.
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public @ResponseBody String addListing(@RequestParam(value = "data", required = false, defaultValue = "{}") String jsonString) {
        try {
            // return DBController.getInstance().add(jsonString);
            return "{\"succeed\": true}";
        }
        catch (Exception ex) {
            return getJsonFromEx(ex);
        }
    }

    /**
     * Returns a listing information as json.
     * @param mlsNo A valid UUID as string
     * @return Listing object as json, or an error json object.
     */
    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public @ResponseBody String readByMlsNumber(@RequestParam(value = "mls_no", required = true, defaultValue = "") String mlsNo) {
        try {
            UUID mlsNumber = UUID.fromString(mlsNo);
            // return DBController.getInstance().read(mlsNumber);
            return "";
        }
        catch (Exception ex) {
            return getJsonFromEx(ex);
        }
    }

    /**
     * Updates listing price of an existing listing.
     * @param mlsNo A valid UUID as string
     * @param newPrice New price.
     * @return An error or success json object.
     */
    @RequestMapping(value = "/update/price", method = RequestMethod.GET)
    public @ResponseBody String updateListingPrice(@RequestParam(value = "mls_no", required = true, defaultValue = "") String mlsNo,
            @RequestParam(value = "new_price", required = true, defaultValue = "0.0") Double newPrice) {
        try {
            UUID mlsNumber = UUID.fromString(mlsNo);
            // DBController.getInstance().updatePrice(mlsNumber, newPrice);
            return "{\"succeed\": true}";
        }
        catch (Exception ex) {
            return getJsonFromEx(ex);
        }
    }

    /**
     * Deletes a listing from database.
     * @param mlsNo A valid UUID as string
     * @return An error or success json object.
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public @ResponseBody String updateListingPrice(@RequestParam(value = "mls_no", required = true, defaultValue = "") String mlsNo) {
        try {
            UUID mlsNumber = UUID.fromString(mlsNo);
            // DBController.getInstance().delete(mlsNumber);
            return "{\"succeed\": true}";
        }
        catch (Exception ex) {
            return getJsonFromEx(ex);
        }
    }

    /**
     * Converts an exception to simple json string.
     * @param ex An Exception.
     * @return JSON object as string.
     */
    public static String getJsonFromEx(Exception ex) {
        JsonObject error = new JsonObject();
        error.addProperty("error", ex.getMessage());
        return error.toString();
    }
}
