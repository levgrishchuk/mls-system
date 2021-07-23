package mls.property.structure.exterior;

import mls.property.structure.exterior.Exterior;

public class Parking extends Exterior {
    private String type;
    private int carSpace;

    /**
     * default constructor
     */
    public Parking(){}

    public Parking(Exterior exterior, String type, int carSpace) {
        super(exterior);
        this.type = type;
        this.carSpace = carSpace;
    }
}
