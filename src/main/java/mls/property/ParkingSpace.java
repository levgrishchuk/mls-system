package mls.property;

import mls.property.structure.exterior.Exterior;

import java.util.List;

public class ParkingSpace extends Property {
    private Integer carSpace;

    /**
     * Copy constructor
     */
    public ParkingSpace(ParkingSpace property) {
        super(property);
        this.setCarSpace(property.getCarSpace());
    }

    /**
     * Builder constructor
     */
    public ParkingSpace(Builder builder) {
        super(builder);
    }

    /**
     * Accessors/mutators
     */
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

    @Override
    public void setExteriors(List<Exterior> exteriors) {
        throw new UnsupportedOperationException("New construction doesn't have exteriors.");
    }

    /**
     * Returns true if obj is identical to this instance.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !obj.getClass().equals(this.getClass()))
            return false;

        ParkingSpace p = (ParkingSpace) obj;

        return super.equals(p) &&
                Integer.compare(this.carSpace, p.getCarSpace()) == 0;
    }

    /**
     * Returns an instance of Builder.
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder
     */
    public static class Builder extends Property.Builder<Builder> {
        @Override
        public Builder addExterior(Exterior exterior) {
            throw new UnsupportedOperationException("New construction doesn't have exteriors.");
        }

        @Override
        public ParkingSpace build() {
            return new ParkingSpace(this);
        }
    }
}
