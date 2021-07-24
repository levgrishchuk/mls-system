import mls.Address;
import mls.Listing;
import mls.Participant;
import mls.Size;
import mls.property.Farmhouse;
import mls.property.LeaseInformation;
import mls.property.Property;
import mls.property.structure.Building;
import mls.property.structure.Room;
import mls.property.structure.exterior.Lawn;
import mls.property.structure.exterior.Pool;
import mls.property.structure.neighbourhoodfeatures.School;

import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

public class sampleListing {
    static Property f = Farmhouse.builder()
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

    static Listing l = new Listing.Builder()
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

    public static Listing getListing(){
        return l;
    }
}
