package app;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import mls.*;
import mls.property.structure.exterior.Backyard;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;
import java.util.UUID;

/** This class controls database */
public class DBController {
    private static DBController instance;
    private static final String jsonPath = "src/main/resources/data.json";


    /** No instantiation allowed */
    private DBController() {};

    /**
     * Returns the singleton instance.
     */
    public static DBController getInstance() {
        if (instance == null) {
            instance = new DBController();
        }
        return instance;
    }

    public void create() throws IOException {
        // get path of A3 folder on your local machine
        String filePath = new File("").getAbsolutePath();
        // make reader using what is effectively relative pathing
        JsonReader reader = new JsonReader(new FileReader(filePath + "/src/main/resources/data.json"));

        Backyard test = new Backyard();


    }

    /**
     * finds listing by mls number
     * @param
     */
    public void read() throws IOException {
        Gson gson = new Gson();
        // get path of A3 folder on your local machine
        String filePath = new File("").getAbsolutePath();
        // make reader using what is effectively relative pathing
        JsonReader reader = new JsonReader(new FileReader(filePath + "/src/main/resources/data.json"));

        Brokerage[] data = gson.fromJson(reader, Brokerage[].class);

        System.out.println(data[0].getCorporateName() + '\n' + data[0].getAddress());


    }
}
