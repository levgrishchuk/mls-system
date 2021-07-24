package app;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import mls.*;
import mls.property.Property;
import mls.property.structure.exterior.Backyard;
import mls.property.structure.exterior.Exterior;
import mls.property.structure.neighbourhoodfeatures.NeighbourhoodFeatures;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/** This class controls database */
public class DBController {
    public static final String JSONPATH = "src/main/resources/data.json";

    private static DBController instance;
    private Gson gson;

    /** No instantiation allowed */
    private DBController() {};

    /**
     * Returns the singleton instance, and initiates gsonbuilder.
     */
    public static DBController getInstance() {
        if (instance == null) {
            instance = new DBController();
            instance.gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .registerTypeAdapter(Exterior.class, new TypeAdapter<Exterior>())
                    .registerTypeAdapter(NeighbourhoodFeatures.class, new TypeAdapter<NeighbourhoodFeatures>())
                    .registerTypeAdapter(Property.class, new TypeAdapter<Property>())
                    .create();
        }
        return instance;
    }

    /**
     * Returns an instance of Gson.
     */
    public Gson getGson() {
        return gson;
    }

    /**
     * Searches listing by mls number in database.
     * @param mlsNumber
     * @return Returns Listing if found, otherwise null.
     * @throws IOException
     */
    public Listing read(UUID mlsNumber) throws IOException {
        return readAll().stream()
                .filter(l -> l.getMlsNumber().equals(mlsNumber))
                .findFirst().orElse(null);
    }

    /**
     * Returns a List of all Listing available in database.
     * @throws IOException
     */
    public List<Listing> readAll() throws IOException {
        Listing[] arr = gson.fromJson(
                Files.readString(Path.of(DBController.JSONPATH)),
                Listing[].class
        );
        List<Listing> arrL;

        if (arr == null)
            arrL = new ArrayList<>();
        else
            arrL = new ArrayList<>(Arrays.asList(arr));

        return arrL;
    }

    /**
     * Adds listing to database. If already exists, then replaces it.
     * @param listing A Listing object
     * @return whether succeeded
     */
    public boolean update(Listing listing) throws IOException {
        List<Listing> arrL = readAll();

        // remove if already exists.
        arrL.removeAll(List.of(listing));

        arrL.add(listing);
        Files.writeString(Path.of(DBController.JSONPATH), gson.toJson(arrL));
        return true;
    }

    /**
     * Clears the database.
     */
    public void clear() throws IOException {
        Files.writeString(Path.of(DBController.JSONPATH), "");
    }
}
