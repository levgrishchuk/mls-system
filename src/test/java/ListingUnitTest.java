import mls.*;
import mls.property.*;
import mls.property.structure.*;
import mls.property.structure.exterior.*;
import mls.property.structure.neighbourhoodfeatures.Hospital;
import mls.property.structure.neighbourhoodfeatures.NeighbourhoodFeaturesContainer;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class ListingUnitTest {
    @Test
    public void TestBuilder() {
        Address address = new Address(3495,
                "Lawrence Ave.",
                "Toronto",
                "Ontario",
                "M1H 1B3");

        Size size = new Size(10.0, 10.0, "meter");

        Building building = new Building.Builder()
                .setCategory(Building.BuildingCategory.MultiGenerational)
                .addAppliance("Waching machine")
                .addRoom(
                        new Room(Room.RoomType.Bed,
                                new Size(10.0, 10.0, "meter")))
                .setExteriorDesign("Brick")
                .setUnitCount(1)
                .setStoryCount(1)
                .setHasBasement(false)
                .build();

        Farmhouse farmhouse = Farmhouse.builder()
                .address(address)
                .annualTax(1200.00)
                .underConstruction()
                .landSize(size)
                .building(building)
                .addNeighbourhoodFeature(new Hospital("1", "1"))
                .lease(new LeaseInformation("Strata", 550.0))
                .build();

        Participant owner = new Participant("John", address, "john@gmail.com", "123-456-7890");
        Participant buyer = new Participant("Tim", address, "tim@gmail.com", "124-456-7890");
        Broker broker = new Broker("Mary", address, "mary@gmail.com", "987-654-3210",
                new Brokerage("MyBrokerage", address));
        Date addedDate = new Date();
        Date soldDate = new Date();

        Listing l = Listing.builder()
                .setListingPrice(120000f)
                .setDateAdded(addedDate)
                .setProperty(farmhouse)
                .setDescription("Nice farmhouse.")
                .setPropertyOwner(owner)
                .setBroker(broker)
                .setSold(buyer, soldDate)
                .build();

        assertEquals(120000f, l.getListingPrice(), 0.00000001);
        assertEquals(addedDate, l.getDateAdded());
        assertEquals(farmhouse, l.getProperty());
        assertEquals("Nice farmhouse.", l.getDescription());
        assertEquals(owner, l.getPropertyOwner());
        assertEquals(broker, l.getBroker());
        assertEquals(soldDate, l.getDateSold());
        assertEquals(buyer, l.getBuyer());
        assertEquals(Listing.Status.Sold, l.getStatus());
    }

    @Test
    public void TestStatus() {
        Address address = new Address(3495,
                "Lawrence Ave.",
                "Toronto",
                "Ontario",
                "M1H 1B3");
        Participant buyer = new Participant("Tim", address, "tim@gmail.com", "124-456-7890");
        Listing l = Listing.builder()
                .setListingPrice(120000f).build();

        assertEquals(Listing.Status.Active, l.getStatus());

        l.setSold(buyer, new Date());
        assertEquals(Listing.Status.Sold, l.getStatus());
    }

    @Test
    public void TestMlsGeneration() {
        Listing l = Listing.builder()
                .setListingPrice(120000f).build();
        Object o = l.getMlsNumber();
        assertEquals(true, o != null && o instanceof UUID);
    }
}
