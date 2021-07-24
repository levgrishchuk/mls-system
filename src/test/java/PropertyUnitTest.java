import mls.*;
import mls.property.*;
import mls.property.structure.*;
import mls.property.structure.exterior.*;
import mls.property.structure.neighbourhoodfeatures.Hospital;
import mls.property.structure.neighbourhoodfeatures.NeighbourhoodFeaturesContainer;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class PropertyUnitTest {
    @Test
    public void TestPropertyBuilder() {
        Address a = new Address(3495,
                "Lawrence Ave.",
                "Toronto",
                "Ontario",
                "M1H 1B3");

        Size s = new Size(10.0, 10.0, "meter");

        Building b = new Building.Builder()
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

        Farmhouse f = Farmhouse.builder()
                .address(a)
                .annualTax(1200.00)
                .underConstruction()
                .landSize(s)
                .building(b)
                .addNeighbourhoodFeature(new Hospital("1", "1"))
                .lease(new LeaseInformation("Strata", 550.0))
                .build();

        assertEquals(true,
                f.getAddress().equals(a) &&
                Double.compare(f.getAnnualTax(), 1200.00) == 0 &&
                f.isUnderConstruction() &&
                f.getLandSize().equals(s) &&
                f.getBuilding().equals(b) &&
                f.getNeighbourhood().equals(new NeighbourhoodFeaturesContainer(Arrays.asList(new Hospital("1", "1")))) &&
                f.getLeaseInformation().equals(new LeaseInformation("Strata", 550.0))
        );
    }

    @Test
    public void TestLeaseType() {
        Farmhouse f = Farmhouse.builder().build();
        f.setFreehold();
        assertEquals(Property.LeaseType.Freehold, f.getLeaseType());

        f.setLeasehold(new LeaseInformation("Strata", 550.0));
        assertEquals(Property.LeaseType.Leasehold, f.getLeaseType());
    }

    @Test
    public void TestEquals() {
        Address a = new Address(3495,
                "Lawrence Ave.",
                "Toronto",
                "Ontario",
                "M1H 1B3");

        Size s = new Size(10.0, 10.0, "meter");

        Building b = new Building.Builder()
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

        Farmhouse f1 = Farmhouse.builder()
                .address(a)
                .annualTax(1200.00)
                .underConstruction()
                .landSize(s)
                .building(b)
                .addNeighbourhoodFeature(new Hospital("1", "1"))
                .lease(new LeaseInformation("Strata", 550.0))
                .build();

        Farmhouse f2 = Farmhouse.builder()
                .address(a)
                .annualTax(1200.00)
                .underConstruction()
                .landSize(s)
                .building(b)
                .addNeighbourhoodFeature(new Hospital("1", "1"))
                .lease(new LeaseInformation("Strata", 550.0))
                .build();

        Farmhouse f3 = Farmhouse.builder()
                .address(a)
                .annualTax(1200.00)
                .underConstruction()
                .landSize(s)
                .building(b)
                .addNeighbourhoodFeature(new Hospital("1", "1"))
                .lease(new LeaseInformation("Strata", 550.0))
                .build();
        f3.getBuilding().setStoryCount(2);

        assertEquals(false, f1.equals(f3));
        assertEquals(true, f1.equals(f2));
    }
}
