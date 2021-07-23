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

    /**
     * copy constructor
     * @param other
     */
    public Parking(Parking other){
        super(other);
        this.type = other.getType();
        this.carSpace = other.carSpace;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCarSpace() {
        return carSpace;
    }

    public void setCarSpace(int carSpace) {
        this.carSpace = carSpace;
    }
}
