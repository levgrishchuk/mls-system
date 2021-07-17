package app;

/** This class controls database */
public class DBController {
    private DBController instance;
    private final String jsonPath = "src/main/resources/data.json";


    /** No instantiation allowed */
    private DBController() {};

    /**
     * Returns the singleton instance.
     */
    public DBController getInstance() {
        if (instance == null) {
            instance = new DBController();
        }
        return instance;
    }
}
