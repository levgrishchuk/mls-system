package app;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import mls.*;
import mls.property.Property;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

/**
 * Entry point
 */
@Controller
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class Main {
    private DBController db = DBController.getInstance();

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    /**
     * Creates a listing in database.
     * @param price Price as float
     * @param property A valid json string of Property instance
     * @param description Single line description
     * @param owner A valid json string of Participant instance
     * @param broker A valid json string of Broker instance
     * @return The mlsNumber on success. Otherwise, error message.
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public @ResponseBody String addListing(
            @RequestParam(value = "price", required = true, defaultValue = "0.0") float price,
            @RequestParam(value = "property", required = true, defaultValue = "{}") String property,
            @RequestParam(value = "desc", required = true, defaultValue = "") String description,
            @RequestParam(value = "owner", required = true, defaultValue = "{}") String owner,
            @RequestParam(value = "broker", required = true, defaultValue = "{}") String broker
        ) {
        try {
            Listing l = Listing.builder()
                    .setListingPrice(price)
                    .setProperty(db.getGson().fromJson(property, Property.class))
                    .setDescription(description)
                    .setPropertyOwner(db.getGson().fromJson(owner, Participant.class))
                    .setBroker(db.getGson().fromJson(broker, Broker.class))
                    .setDateAdded(new Date())
                    .build();

            db.update(l);
            return "{\"mlsNumber\": \"" + l.getMlsNumber() + "\"}";
        }
        catch (Exception ex) {
            return getJsonFromEx(ex);
        }
    }

    /**
     * Sets buyer information and sold date of an existing listing.
     * @param mlsNumber MLSnumber of the Listing.
     * @param buyer A valid json of Participant instance.
     * @return Success message, or error if listing not found.
     */
    @RequestMapping(value = "/sold", method = RequestMethod.GET)
    public @ResponseBody String setSold(
            @RequestParam(value = "mls_no", required = true, defaultValue = "") String mlsNumber,
            @RequestParam(value = "buyer", required = true, defaultValue = "{}") String buyer
    ) {
        try {
            Listing l = db.read(UUID.fromString(mlsNumber));

            if (l == null)
                throw new Exception("No listing found.");

            l.setSold(db.getGson().fromJson(buyer, Participant.class), new Date());
            db.update(l);

            return "{\"succeed\": true}";
        }
        catch (Exception ex) {
            return getJsonFromEx(ex);
        }
    }

    /**
     * Updates price of an existing listing
     * @param mlsNumber Mls number of the listing
     * @param price New price
     * @return Success message, or error message on error.
     */
    @RequestMapping(value = "/update-price", method = RequestMethod.GET)
    public @ResponseBody String changePrice(
            @RequestParam(value = "mls_no", required = true, defaultValue = "") String mlsNumber,
            @RequestParam(value = "new_price", required = true, defaultValue = "{}") float price
    ) {
        try {
            Listing l = db.read(UUID.fromString(mlsNumber));

            if (l == null)
                throw new Exception("No listing found.");

            l.setListingPrice(price);
            db.update(l);

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
