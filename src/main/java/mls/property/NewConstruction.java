package mls.property;

import mls.property.structure.Building;
import mls.property.structure.exterior.Exterior;

import java.util.List;

public class NewConstruction extends Property{

    /**
     * Copy constructor
     */
    public NewConstruction(NewConstruction property) {
        super(property);
    }

    /**
     * Builder constructor
     */
    public NewConstruction(Builder builder) {
        super(builder);
    }

    /**
     * Throws exception because new construction doesn't have a building.
     */
    @Override
    public Building getBuilding() {
        throw new UnsupportedOperationException("New construction doesn't have a building.");
    }

    @Override
    public void setBuilding(Building building) {
        throw new UnsupportedOperationException("New construction doesn't have a building.");
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
        public Builder building(Building building) {
            throw new UnsupportedOperationException("New construction doesn't have a building.");
        }

        @Override
        public NewConstruction build() {
            return new NewConstruction(this);
        }
    }
}
