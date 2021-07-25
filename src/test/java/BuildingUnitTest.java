import mls.*;
import mls.property.structure.Building;
import mls.property.structure.Room;
import mls.property.structure.neighbourhoodfeatures.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class BuildingUnitTest {
    @Test
    public void TestBuilderException(){
        mls.property.structure.Building.Builder b1 = new Building.Builder()
                .setCategory(mls.property.structure.Building.BuildingCategory.MultiGenerational)
                .setUnitCount(-2)
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
                );

        Throwable exception = assertThrows(RuntimeException.class, () ->
                b1.build()
        );

        assertEquals("Please enter positive integers for unit count and story count",
                exception.getMessage());

    }

    @Test
    public void BuildingBuilder(){
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

        assertEquals(true,
                b1.getCategory() == Building.BuildingCategory.MultiGenerational &&
                b1.getUnitCount() == 1 &&
                b1.getStoryCount() == 1 &&
                b1.getRooms().equals(Arrays.asList(
                        new Room(Room.RoomType.Bed,
                                new Size(10.0, 10.0, "meter")),
                        new Room(Room.RoomType.Bath,
                                new Size(10.0, 10.0, "meter")))
                        ) &&
                b1.getExteriorDesign().equals("Brick") &&
                b1.HasBasement() == false &&
                b1.getAppliances().equals(Arrays.asList(
                        "Washing machine",
                        "Dish washer")
                        ));
    }

    @Test
    public void BuildingEquals(){
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

        assertEquals(true, b1.equals(b1));
        assertEquals(true, b1.equals(b2));
        assertEquals(false, b1.equals(b3));
    }

    @Test
    public void SetRoomsDeepCopyTest(){
        Building c1 = new Building.Builder()
                .setUnitCount(1)
                .setStoryCount(1)
                .build();

        List<Room> l1 = Arrays.asList(
                new Room(Room.RoomType.Bed,
                        new Size(10.0, 10.0, "meter")),
                new Room(Room.RoomType.Bath,
                        new Size(10.0, 10.0, "meter"))
        );

        c1.setRooms(l1);

        boolean flag = false;

        // check that no element in the new list has the same address as the first one in l1
        for(int i = 0; i < l1.size(); i++){
            if(l1.get(0) == c1.getRooms().get(i)){
                flag = true;
            }
        }
        assertFalse(flag);
    }

}
