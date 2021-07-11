package mls.property;

import mls.property.structure.exterior.Exterior;

import java.util.List;

public class ParkingSpace extends Property {
    private Integer carSpace;

    public Integer getCarSpace() {
        return carSpace;
    }

    public void setCarSpace(Integer carSpace) {
        this.carSpace = carSpace;
    }
    /**
     * Throws exception because new construction doesn't have exteriors.
     */
    @Override
    public List<Exterior> getExteriors() {
        throw new UnsupportedOperationException("New construction doesn't have exteriors.");
    }
}
