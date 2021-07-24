//import app.Adapter;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.google.gson.JsonObject;
//import mls.*;
//import mls.property.DetachedHome;
//import mls.property.Farmhouse;
//import mls.property.LeaseInformation;
//import mls.property.Property;
//import mls.property.structure.Building;
//import mls.property.structure.Room;
//import mls.property.structure.exterior.Exterior;
//import mls.property.structure.neighbourhoodfeatures.Hospital;
//import mls.property.structure.neighbourhoodfeatures.NeighbourhoodFeatures;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.UUID;
//
//public class GsonTest {
//    public static Gson gson = new GsonBuilder()
//            .registerTypeAdapter(Property.class, new Adapter<Property>())
//            .registerTypeAdapter(Property.class, new Adapter<Exterior>())
//            .registerTypeAdapter(Property.class, new Adapter<NeighbourhoodFeatures>())
//            .setPrettyPrinting()
//            .create();
//
//    public static void main(String[] args) throws IOException {
//
//        TestToJson();
//
//    }
//
//    public static void TestFromJson() throws IOException {
//
//
//        String j = Files.readString(Path.of("src/test/java/l.json"));
//
//        Listing l = gson.fromJson(j, Listing.class);
//        System.out.println(l.getProperty());
//    }
//
//    public static void TestToJson() {
//
//        Farmhouse f = Farmhouse.builder()
//                .address(new Address(3495,
//                        "Lawrence Ave.",
//                        "Toronto",
//                        "Ontario",
//                        "M1H 1B3"))
//                .annualTax(1200.00)
//                .landSize(new Size(10.0, 10.0, 10.0, "meter"))
//                /*.addExterior(new Lawn())
//                .addExterior(new Pool())*/
//                .building(new Building.Builder()
//                        .setCategory(Building.BuildingCategory.MultiGenerational)
//                        .addAppliance("Waching machine")
//                        .addAppliance("Dish washer")
//                        .addRoom(
//                                new Room(Room.RoomType.Bed,
//                                        new Size(10.0, 10.0, 10.0, "meter")))
//                        .addRoom(new Room(Room.RoomType.Bath,
//                                new Size(10.0, 10.0, 10.0, "meter")))
//                        .setExteriorDesign("Brick")
//                        .setUnitCount(1)
//                        .setStoryCount(1)
//                        .setHasBasement(false)
//                        .build())
//                /*.addNeighbourhood(new Hospital())*/
//                /*.addNeighbourhood(Property.NeighbourhoodFeatures.School)*/
//                .lease(new LeaseInformation("Strata", 550.0))
//                .build();
//
//                System.out.println(f.getBuilding().getAppliances());
//                System.out.println(f.getNeighbourhood());
//
//        Listing listing = new Listing.Builder()
//                .setMlsNumber(UUID.randomUUID())
//                .setListingPrice(1000000.0F)
//                .setDateAdded(new Date())
//                .setProperty(f)
//                .setDescription("Nice farmhouse.")
//                .setPropertyOwner(new Participant(
//                        "Me",
//                        new Address(1, "2", "3", "4", "5"),
//                        "abc@gmail.com",
//                        "123-345-5678"
//                ))
//                .setStatus(Listing.Status.Active)
//                .build();
//
//        JsonObject o = (JsonObject) gson.toJsonTree(listing);
//        /*o.addProperty("typeName", Farmhouse.class.getSimpleName());*/
//        System.out.println(gson.toJson(o));
//    }
//}
