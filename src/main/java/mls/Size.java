package mls;

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
     * @param height
     * @param unit
     */
    public Size(Double length, Double width, Double height, String unit) {
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
}
