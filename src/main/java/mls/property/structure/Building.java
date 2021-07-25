package mls.property.structure;
import mls.property.structure.neighbourhoodfeatures.NeighbourhoodFeatures;

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
        this.appliances = new ArrayList<>();
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

    @Override
    public boolean equals(Object other){
        // if not building object, automatically not equals
        if(other.getClass() != Building.class){
            return false;
        }

        // compare addresses
        if(this == other){
            return true;
        }

        // results accumulated here
        boolean flag = true;

        // compare simple attributes
        flag = flag &&
                (this.getCategory() == ((Building) other).getCategory()) &&
                (this.getStoryCount() == ((Building) other).getUnitCount()) &&
                (this.getStoryCount() == ((Building) other).getStoryCount()) &&
                (this.HasBasement() == ((Building) other).HasBasement()) &&
                (this.getExteriorDesign().equals(((Building) other).getExteriorDesign())) &&
                (this.getAppliances().equals(((Building) other).getAppliances()));

        // compare rooms lists
        // compare addresses
        if(this.getRooms() == ((Building) other).getRooms()){
            return flag && true;
        }

        // short form variables
        List<Room> thisList = this.getRooms();
        List<Room> otherList = ((Building) other).getRooms();

        // if lists have different lengths
        if(thisList.size() != otherList.size()){
            return false;
        }

        // iteratively check if all the objects have the same attributes
        // result accumulated in flag, check if each individual object has different attributes
        // O(n^2) time complexity, pretty bad, but did not find another option. Would need to be able to sort
        // rooms to do better.
        boolean roomFlag = true;
        for(int i = 0; i < thisList.size(); i++){
            boolean rowFlag = false;
            for(int j = 0; j < otherList.size(); j++){
                rowFlag = rowFlag || thisList.get(i).equals(otherList.get(j));
            }
            roomFlag = roomFlag && rowFlag;
        }
        // result of simple attributes and room list
        return flag && roomFlag;
    }

    public static class Builder {
        private BuildingCategory category = BuildingCategory.Other;
        private int unitCount;
        private int storyCount;
        private List<Room> rooms = new ArrayList<>();
        private String exteriorDesign;
        private boolean hasBasement;
        private List<String> appliances = new ArrayList<>();

        public Builder setCategory(BuildingCategory category) {
            this.category = category;
            return this;
        }

        public Builder setUnitCount(int unitCount) {
            this.unitCount = unitCount;
            return this;
        }

        public Builder setStoryCount(int storyCount) {
            this.storyCount = storyCount;
            return this;
        }

        public Builder setRooms(List<Room> rooms) {
            // list deep copy
            this.rooms = new ArrayList<>();
            for(Room room : rooms){
                this.rooms.add(new Room(room));
            }
            return this;
        }

        public Builder addRoom(Room room){
            // list deep copy
            this.rooms.add(new Room(room));
            return this;
        }

        public Builder setExteriorDesign(String exteriorDesign) {
            this.exteriorDesign = exteriorDesign;
            return this;
        }

        public Builder setHasBasement(boolean hasBasement) {
            this.hasBasement = hasBasement;
            return this;
        }

        public Builder setAppliances(List<String> appliances) {
            this.appliances = appliances;
            return this;
        }

        public Builder addAppliance(String appliance){
            // String immutable, no need for new object
            this.appliances.add(appliance);
            return this;
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
