import com.google.common.collect.Lists;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import mls.*;
import mls.property.Farmhouse;
import mls.property.LeaseInformation;
import mls.property.Property;
import mls.property.structure.Building;
import mls.property.structure.Room;
import mls.property.structure.exterior.Exterior;
import mls.property.structure.exterior.Lawn;
import mls.property.structure.exterior.Pool;
import mls.property.structure.neighbourhoodfeatures.NeighbourhoodFeatures;
import mls.property.structure.neighbourhoodfeatures.School;
import java.io.*;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class GsonTestCreateRead {

    public static void create() throws IOException {
        // get path of A3 folder on your local machine
        String filePath = new File("").getAbsolutePath();
        // make reader using what is effectively relative pathing
        try (Writer writer = new FileWriter(filePath + "/src/test/java/sampleData.json")) {


            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .registerTypeAdapter(Exterior.class, new TypeAdapter<Exterior>())
                    .registerTypeAdapter(NeighbourhoodFeatures.class, new TypeAdapter<NeighbourhoodFeatures>())
                    .registerTypeAdapter(Property.class, new TypeAdapter<Property>())
                    .create();

            Property f = Farmhouse.builder()
                    .address(new Address(3495,
                            "Lawrence Ave.",
                            "Toronto",
                            "Ontario",
                            "M1H 1B3"))
                    .annualTax(1200.00)
                    .landSize(new Size(10.0, 10.0, "meter"))
                    .addExterior(new Lawn())
                    .addExterior(new Pool())
                    .building(new Building.Builder()
                            .setCategory(Building.BuildingCategory.MultiGenerational)
                            .setUnitCount(1)
                            .setStoryCount(1)
                            .setRooms(Arrays.asList(
                                    new Room(Room.RoomType.Bed,
                                            new Size(10.0, 10.0, "meter")),
                                    new Room(Room.RoomType.Bath,
                                            new Size(10.0, 10.0, "meter"))
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
                    .addNeighbourhoodFeature(new School())
                    .lease(new LeaseInformation("Strata", 550.0))
                    .build();

            Listing l = new Listing.Builder()
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

//        JsonObject o = (JsonObject) gson.toJsonTree(l);
            gson.toJson(l, writer);
            System.out.println(gson.toJson(l));

        }
    }

    public static void createCollection() throws IOException {
        // get path of A3 folder on your local machine
        String filePath = new File("").getAbsolutePath();
        // make reader using what is effectively relative pathing
        try (Writer writer = new FileWriter(filePath + "/src/test/java/sampleDataWithArray.json")) {


            Gson gson = new GsonBuilder()
                    .create();

            JsonArray array = new JsonArray();
            gson.toJson(array, writer);
//            System.out.println(gson.toJson(l));

        }
    }

    /**
     * finds listing by mls number
     * @param
     */
    public static void read() throws IOException {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(Exterior.class, new TypeAdapter<Exterior>())
                .registerTypeAdapter(NeighbourhoodFeatures.class, new TypeAdapter<NeighbourhoodFeatures>())
                .registerTypeAdapter(Property.class, new TypeAdapter<Property>())
                .create();
        // get path of A3 folder on your local machine
        String filePath = new File("").getAbsolutePath();
        // make reader using what is effectively relative pathing
        JsonReader reader = new JsonReader(new FileReader(filePath + "/src/test/java/sampleData.json"));

        Listing data = gson.fromJson(reader, Listing.class);

        System.out.println(data.getProperty().getClass().toString());


    }

    /**
     * search by uuid
     * @param
     * @throws IOException
//     */
    public static void read(int test1) throws IOException {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(Exterior.class, new TypeAdapter<Exterior>())
                .registerTypeAdapter(NeighbourhoodFeatures.class, new TypeAdapter<NeighbourhoodFeatures>())
                .registerTypeAdapter(Property.class, new TypeAdapter<Property>())
                .create();
        // get path of A3 folder on your local machine
        String filePath = new File("").getAbsolutePath();
        // make reader using what is effectively relative pathing
        JsonReader reader = new JsonReader(new FileReader(filePath + "/src/test/java/sampleDataWithArray.json"));

        Listing[] data = gson.fromJson(reader, Listing[].class);

        List<Listing> test = Arrays.stream(data).toList();
        test.add(sampleListing.getListing());

        System.out.println();


    }



    public static void main(String[] args) throws IOException {

        GsonTestCreateRead.create();
//        GsonTestCreateRead.readCol();
        GsonTestCreateRead.read();

    }

    /**
     * For serializing/deserializing abstract/interface/super classes
     * @param <T>
     */
    public static class TypeAdapter<T>
            implements JsonSerializer<T>, JsonDeserializer<T> {

        @Override
        public final JsonElement serialize(final T object, final Type type, final JsonSerializationContext context)
        {
            final JsonObject member = new JsonObject();

            member.addProperty("typeName", object.getClass().getName());

            member.add("data", context.serialize(object));

            return member;
        }

        @Override
        public final T deserialize(final JsonElement elem, final Type type, final JsonDeserializationContext context)
                throws JsonParseException
        {
            final JsonObject member = (JsonObject) elem;
            final JsonElement typeString = get(member, "typeName");
            final JsonElement data = get(member, "data");
            final Type actualType = typeForName(typeString);

            return context.deserialize(data, actualType);
        }

        private Type typeForName(final JsonElement typeElem)
        {
            try
            {
                return Class.forName(typeElem.getAsString());
            }
            catch (ClassNotFoundException e)
            {
                throw new JsonParseException(e);
            }
        }

        private JsonElement get(final JsonObject wrapper, final String memberName)
        {
            final JsonElement elem = wrapper.get(memberName);

            if (elem == null)
            {
                throw new JsonParseException(
                        "no '" + memberName + "' member found in json file.");
            }
            return elem;
        }
    }
}
