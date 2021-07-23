import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import mls.*;
import mls.property.Farmhouse;
import mls.property.LeaseInformation;
import mls.property.MobileHome;
import mls.property.Property;
import mls.property.structure.Building;
import mls.property.structure.Room;
import mls.property.structure.exterior.Lawn;
import mls.property.structure.exterior.Pool;

import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

public class GsonTest {
    public static void main(String[] args) {
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
                .building(new Building(
                            Building.BuildingCategory.MultiGenerational,
                            1,
                            1,
                            Arrays.asList(
                                    new Room(Room.RoomType.Bed,
                                            new Size(10.0, 10.0, 10.0, "meter")),
                                    new Room(Room.RoomType.Bath,
                                            new Size(10.0, 10.0, 10.0, "meter"))
                            ),
                            "Brick",
                            false,
                            Arrays.asList("Washing machine", "Dish washer")
                ))
                .addNeighbourhood(Property.NeighbourhoodFeatures.Hospital)
                .addNeighbourhood(Property.NeighbourhoodFeatures.School)
                .lease(new LeaseInformation("Strata", 550.0))
                .build();

        Listing l = new Listing.Builder(UUID.randomUUID())
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


        System.out.println(gson.toJson(o));
    }
}
