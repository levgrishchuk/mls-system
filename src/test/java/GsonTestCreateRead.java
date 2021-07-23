import app.DBController;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import mls.*;
import mls.property.Farmhouse;
import mls.property.LeaseInformation;
import mls.property.Property;
import mls.property.structure.Building;
import mls.property.structure.Room;
import mls.property.structure.exterior.Backyard;
import mls.property.structure.exterior.Lawn;
import mls.property.structure.exterior.Pool;
import mls.property.structure.neighbourhoodfeatures.Hospital;
import mls.property.structure.neighbourhoodfeatures.School;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

public class GsonTestCreateRead {

    public static void create() throws IOException {
        // get path of A3 folder on your local machine
        String filePath = new File("").getAbsolutePath();
        // make reader using what is effectively relative pathing
//        try (JsonWriter writer = new JsonWriter(new FileWriter(filePath + "/src/main/resources/data.json"))) {
//        }


        Gson gson = new GsonBuilder().create();

        Farmhouse f = Farmhouse.builder()
                .address(new Address(3495,
                        "Lawrence Ave.",
                        "Toronto",
                        "Ontario",
                        "M1H 1B3"))
                .annualTax(1200.00)
                .landSize(new Size(10.0, 10.0, 10.0, "meter"))
                .addExterior(new Lawn())
                .addExterior(new Pool())
                .building(new Building.Builder()
                        .setCategory(Building.BuildingCategory.MultiGenerational)
                        .setUnitCount(1)
                        .setStoryCount(1)
                        .setRooms(Arrays.asList(
                                new Room(Room.RoomType.Bed,
                                        new Size(10.0, 10.0, 10.0, "meter")),
                                new Room(Room.RoomType.Bath,
                                        new Size(10.0, 10.0, 10.0, "meter"))
                            )
                        )
                        .setExteriorDesign("Brick")
                        .setHasBasement(false)
                        .setAppliances(Arrays.asList(
                                "Washing machine",
                                "Dish washer"
                            )
                        )
                        .build()
                )
                .addNeighbourhood(new Hospital())
                .addNeighbourhood(new School())
                .lease(new LeaseInformation("Strata", 550.0))
                .build();

        Listing l = new Listing.Builder()
                .setMlsNumber(UUID.randomUUID())
                .setListingPrice(1000000.0F)
                .setDateAdded(new Date())
                .setProperty(f)
                .setDescription("Nice farmhouse.")
                .setPropertyOwner(new Participant(
                        "Me",
                        new Address(1, "2", "3", "4", "5"),
                        "abc@gmail.com",
                        "123-345-5678"
                ))
                .setStatus(Listing.Status.Active)
                .build();

        JsonObject o = (JsonObject) gson.toJsonTree(l);


    }

    /**
     * finds listing by mls number
     * @param
     */
    public static void read() throws IOException {
        Gson gson = new Gson();
        // get path of A3 folder on your local machine
        String filePath = new File("").getAbsolutePath();
        // make reader using what is effectively relative pathing
        JsonReader reader = new JsonReader(new FileReader(filePath + "/src/main/resources/data.json"));

        Brokerage[] data = gson.fromJson(reader, Brokerage[].class);

        System.out.println(data[0].getCorporateName() + '\n' + data[0].getAddress());


    }

    public static void main(String[] args) throws IOException {

        GsonTestCreateRead.create();



    }
}
