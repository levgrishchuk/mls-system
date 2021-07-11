package mls.property.structure;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a building
 * Mutable class
 */
public class Building {
    private BuildingCategory category;
    private int unitCount;
    private int storyCount;
    private List<Room> rooms;
    private String exteriorDesign;
    private boolean hasBasement;
    private List<String> appliances;

    /**
     * A constructor performing Deep Copy
     */
    public Building(BuildingCategory category, int unitCount, int storyCount, List<Room> rooms, String exteriorDesign, boolean hasBasement, List<String> appliances) {
        this.category = category;
        this.unitCount = unitCount;
        this.storyCount = storyCount;

        // list deep copy
        this.rooms = new ArrayList<>();
        for(Room room : rooms){
            this.rooms.add(new Room(room));
        }

        this.exteriorDesign = exteriorDesign;
        this.hasBasement = hasBasement;

        // list deep copy
        this.appliances = new ArrayList<>();
        for(String appliance : appliances){
            this.appliances.add(appliance);
        }
    }

    /**
     * Copy constructor
     * Calls first constructor
     * @param building
     */
    public Building(Building building) {
        this(building.getCategory(),
            building.getUnitCount(),
            building.getStoryCount(),
            building.getRooms(),
            building.getExteriorDesign(),
            building.HasBasement(),
            building.getAppliances());
    }

    public BuildingCategory getCategory() {
        return category;
    }

    public int getUnitCount() {
        return unitCount;
    }

    public int getStoryCount() {
        return storyCount;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public String getExteriorDesign() {
        return exteriorDesign;
    }

    public boolean HasBasement() {
        return hasBasement;
    }

    public List<String> getAppliances() {
        return appliances;
    }

    public void setCategory(BuildingCategory category) {
        this.category = category;
    }

    public void setUnitCount(int unitCount) {
        this.unitCount = unitCount;
    }

    public void setStoryCount(int storyCount) {
        this.storyCount = storyCount;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void setExteriorDesign(String exteriorDesign) {
        this.exteriorDesign = exteriorDesign;
    }

    public void setHasBasement(boolean hasBasement) {
        this.hasBasement = hasBasement;
    }

    public void setAppliances(List<String> appliances) {
        this.appliances = appliances;
    }

    /**
     * enum type
     */
    enum BuildingCategory {
        HighValue, MultiGenerational
    }
}
