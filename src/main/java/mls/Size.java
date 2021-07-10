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

    // setters
    public void setUnit(String unit) {
        this.unit = unit;
    }
}
