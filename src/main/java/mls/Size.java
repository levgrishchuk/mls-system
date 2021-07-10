package mls;

public class Size {
    // fields
    private Double length;
    private Double width;
    private Double height;
    private String unit; // imperial/metric

    // methods
    // getters
    public Double getArea() {
        return this.length * this.width;
    }

    public Double getLength() {
        return length;
    }

    public Double getWidth() {
        return width;
    }

    public Double getHeight() {
        return height;
    }

    public String getUnit() {
        return unit;
    }

    // setters

    public void setLength(Double length) {
        this.length = length;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
