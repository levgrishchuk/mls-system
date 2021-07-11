package mls.property.structure;

import java.util.List;

public class Building {
    private BuildingCategory category;
    private int unitCount;
    private int storyCount;
    private List<Room> rooms;
    private String exteriorDesign;
    private boolean hasBasement;
    private List<String> appliances;

    // enum type
    enum BuildingCategory {
        HighValue, MultiGenerational
    }

    public int getUnitCount() {
        return unitCount;
    }
}
