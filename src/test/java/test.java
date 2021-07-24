import mls.Address;
import mls.Size;
import mls.property.DetachedHome;
import mls.property.Farmhouse;
import mls.property.LeaseInformation;
import mls.property.Property;
import mls.property.structure.Building;
import mls.property.structure.Room;
import mls.property.structure.exterior.Backyard;
import mls.property.structure.exterior.Exterior;
import mls.property.structure.exterior.Lawn;
import mls.property.structure.exterior.Pool;
import mls.property.structure.neighbourhoodfeatures.Hospital;
import mls.property.structure.neighbourhoodfeatures.NeighbourhoodFeatures;
import mls.property.structure.neighbourhoodfeatures.NeighbourhoodFeaturesContainer;
import mls.property.structure.neighbourhoodfeatures.School;
import org.junit.Test;
import java.util.Arrays;

public class test {
    @Test
    public void exteriorEquals(){
        Exterior e1 = new Backyard(new Size(1.0,2.0,"metric"));
        Exterior e2 = new Backyard(new Size(1.0,2.0,"metric"));
        Exterior e3 = new Backyard(new Size(99.0,99.0,"metric"));

        assert e1.equals(e1);
        assert e1.equals(e2);
        assert !e1.equals(e3);
    }

    @Test
    public void buildingEquals(){
        Building b1 = new Building.Builder()
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
                .build();
        Building b2 = new Building.Builder()
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
                .build();
        Building b3 = new Building(b2);
        b3.setStoryCount(99);

        assert b1.equals(b1);
        assert b1.equals(b2);
        assert !b1.equals(b3);

    }
    @Test
    public void neighbourhoodContainerEquals(){
        NeighbourhoodFeatures f1 = new Hospital("1", "2");
        NeighbourhoodFeatures f2 = new Hospital("1", "3");
        NeighbourhoodFeatures f3 = new Hospital("1", "4");
        NeighbourhoodFeatures f4 = new Hospital("1", "5");

        NeighbourhoodFeaturesContainer c1 = new NeighbourhoodFeaturesContainer();
        NeighbourhoodFeaturesContainer c2 = new NeighbourhoodFeaturesContainer();
        NeighbourhoodFeaturesContainer c3 = new NeighbourhoodFeaturesContainer();
        NeighbourhoodFeaturesContainer c4 = new NeighbourhoodFeaturesContainer();

        c1.add(f1);
        c1.add(f2);
        c1.add(f3);
        c1.add(f4);

        c2.add(f1);
        c2.add(f2);
        c2.add(f3);
        c2.add(f4);

        c3.add(f4);
        c3.add(f3);
        c3.add(f2);
        c3.add(f1);

        c4.add(f4);
        c4.add(f3);
        c4.add(f2);

        assert c1.equals(c1);
        assert c1.equals(c2);
        assert c1.equals(c3);
        assert !c1.equals(c4);


    }

    @Test
    public void addAppliance(){
//        Building f = new Building.Builder().build();
//        f.addRoom(new Room());



    }
}
