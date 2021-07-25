package mls;

import mls.property.structure.Room;

/**
 * Represents a Size object
 * Immutable class (final fields, no setters, Deep Copy constructor)
 */

public class Size {
    private final Double length;
    private final Double width;
    private final String unit; // imperial/metric

    /**
     * A Constructor
     * @param length
     * @param width
     * @param unit
     */
    public Size(Double length, Double width, String unit) {
        this.length = length;
        this.width = width;
        this.unit = unit;
    }

    /**
     * Copy constructor
     * @param size
     */
    public Size(Size size) {
        this.length = size.length;
        this.width = size.width;
        this.unit = size.unit;
    }

    public Double getArea() {
        return this.length * this.width;
    }

    public Double getLength() {
        return length;
    }

    public Double getWidth() {
        return width;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public boolean equals(Object other){
        if(other == null || other.getClass() != Size.class){
            return false;
        }
        return (this.getLength().equals(((Size) other).getLength())) &&
                (this.getWidth().equals(((Size) other).getWidth())) &&
                (this.getUnit().equals(((Size) other).getUnit()));
    }
}
