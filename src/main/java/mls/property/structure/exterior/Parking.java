package mls.property.structure.exterior;

import mls.Size;
import mls.property.structure.exterior.Exterior;

public class Parking extends Exterior {
    private String type;
    private int carSpace;

    /**
     * default constructor
     */
    public Parking(){}

    public Parking(Size size, String type, int carSpace) {
        super(size);
        this.type = type;
        this.carSpace = carSpace;
    }
}
