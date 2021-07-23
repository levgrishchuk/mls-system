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
     * enum type
     */
    public enum BuildingCategory {
        HighValue, MultiGenerational, Other
    }

    /**
     * A constructor performing Deep Copy
     */
    public Building(Building building) {
        // error check, default value null
        if (building.getCategory() != null){
            this.category = building.getCategory();
        }
        else {
            this.category = BuildingCategory.Other;
        }

        this.unitCount = building.getUnitCount();
        this.storyCount = building.getStoryCount();

        // list deep copy
        this.rooms = new ArrayList<>();
        for(Room room : building.getRooms()){
            this.rooms.add(new Room(room));
        }

        this.exteriorDesign = building.getExteriorDesign();
        this.hasBasement = building.HasBasement();

        // list deep copy
        this.appliances = new ArrayList();
        for(String appliance : building.getAppliances()){
            this.appliances.add(appliance);
        }
    }

    /**
     * Copy constructor
     */
    public Building(Builder builder) {
        // error check, default value null
        if (builder.category != null){
            this.category = builder.category;
        }
        else {
            this.category = BuildingCategory.Other;
        }
        this.unitCount = builder.unitCount;
        this.storyCount = builder.storyCount;

        // list deep copy
        this.rooms = new ArrayList<>();
        for(Room room : builder.rooms){
            this.rooms.add(new Room(room));
        }

        this.exteriorDesign = builder.exteriorDesign;
        this.hasBasement = builder.hasBasement;

        // list deep copy
        this.appliances = new ArrayList<>();
        for(String appliance : builder.appliances){
            this.appliances.add(appliance);
        }
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
        // list deep copy
        List<Room> result = new ArrayList<>();
        for(Room room : this.rooms){
            result.add(new Room(room));
        }
        return result;
    }

    public String getExteriorDesign() {
        return exteriorDesign;
    }

    public boolean HasBasement() {
        return hasBasement;
    }

    public List<String> getAppliances() {
        // list deep copy
        List<String> result = new ArrayList<>();
        for(String appliance : this.appliances){
            result.add(appliance);
        }
        return result;
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
        // list deep copy
        this.rooms = new ArrayList<>();
        for(Room room : rooms){
            this.rooms.add(new Room(room));
        }
    }

    public void addRoom(Room room){
        // list deep copy
        this.rooms.add(new Room(room));
    }

    public void setExteriorDesign(String exteriorDesign) {
        this.exteriorDesign = exteriorDesign;
    }

    public void setHasBasement(boolean hasBasement) {
        this.hasBasement = hasBasement;
    }

    public void setAppliances(List<String> appliances) {
        // list deep copy
        this.appliances = new ArrayList<>();
        for(String appliance : appliances){
            // String immutable, no need for new object
            this.appliances.add(appliance);
        }
    }

    public void addAppliance(String appliance){
        // String immutable, no need for new object
        this.appliances.add(appliance);
    }

    public static class Builder<T extends Builder<T>> {
        private BuildingCategory category = BuildingCategory.Other;
        private int unitCount;
        private int storyCount;
        private List<Room> rooms = new ArrayList<>();
        private String exteriorDesign;
        private boolean hasBasement;
        private List<String> appliances = new ArrayList<>();

        public T setCategory(BuildingCategory category) {
            this.category = category;
            return (T) this;
        }

        public T setUnitCount(int unitCount) {
            this.unitCount = unitCount;
            return (T) this;
        }

        public T setStoryCount(int storyCount) {
            this.storyCount = storyCount;
            return (T) this;
        }

        public T setRooms(List<Room> rooms) {
            // list deep copy
            this.rooms = new ArrayList<>();
            for(Room room : rooms){
                this.rooms.add(new Room(room));
            }
            return (T) this;
        }

        public T addRoom(Room room){
            // list deep copy
            this.rooms.add(new Room(room));
            return (T) this;
        }

        public T setExteriorDesign(String exteriorDesign) {
            this.exteriorDesign = exteriorDesign;
        }

        public T setHasBasement(boolean hasBasement) {
            this.hasBasement = hasBasement;
            return (T) this;
        }

        public T setAppliances(List<String> appliances) {
            this.appliances = appliances;
            return (T) this;
        }

        public T addAppliance(String appliance){
            // String immutable, no need for new object
            this.appliances.add(appliance);
            return (T) this;
        }

        /**
         * Build method
         * @return building instance
         * @throws RuntimeException if fields are not set correctly
         */
        public Building build(){
            if(this.unitCount <= 0 ||
            this.storyCount <= 0){
                throw new RuntimeException("Please enter positive integers for unit count and story count");
            }
            return new Building(this);
        }
    }
}
