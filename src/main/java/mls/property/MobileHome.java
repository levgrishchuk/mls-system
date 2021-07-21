package mls.property;

import mls.Address;
import mls.Size;
import mls.property.structure.exterior.Exterior;
import mls.property.structure.neighbourhoodfeatures.NeighbourhoodFeatures;

import java.util.List;

public class MobileHome extends Property {

    /**
     * Copy constructor
     */
    public MobileHome(MobileHome property) {
        super(property);
    }

    /**
     * Builder constructor
     */
    public MobileHome(Builder builder) {
        super(builder);
    }

    /**
     * Throws exception because mobile homes don't have the following properties.
     */

    @Override
    public Size getLandSize() {
        throw new UnsupportedOperationException("Mobile homes don't have land.");
    }

    @Override
    public List<Exterior> getExteriors() {
        throw new UnsupportedOperationException("Mobile homes don't have exteriors.");
    }

    @Override
    public List<NeighbourhoodFeatures> getNeighbourhood() {
        throw new UnsupportedOperationException("Mobile homes don't have fixed neighbourhood.");
    }

    @Override
    public void setLandSize(Size landSize) {
        throw new UnsupportedOperationException("Mobile homes don't have land.");
    }

    @Override
    public void setExteriors(List<Exterior> exteriors) {
        throw new UnsupportedOperationException("Mobile homes don't have exteriors.");
    }

    @Override
    public void setNeighbourhood(List<NeighbourhoodFeatures> neighbourhood) {
        throw new UnsupportedOperationException("Mobile homes don't have fixed neighbourhood.");
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
        public Builder landSize(Size landSize) {
            throw new UnsupportedOperationException("Mobile homes don't have land.");
        }

        @Override
        public Builder addExterior(Exterior exterior) {
            throw new UnsupportedOperationException("Mobile homes don't have exteriors.");
        }

        @Override
        public Builder addNeighbourhood(NeighbourhoodFeatures neighbourhoodFeatures) {
            throw new UnsupportedOperationException("Mobile homes don't have fixed neighbourhood.");
        }

        @Override
        public MobileHome build() {
            return new MobileHome(this);
        }
    }
}
