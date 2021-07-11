package mls.property;

import mls.Address;
import mls.Size;
import mls.property.structure.exterior.Exterior;

import java.util.List;

public class MobileHome extends Property {

    /**
     * Throws exception because mobile homes don't have the following properties.
     */

    @Override
    public Address getAddress() {
        throw new UnsupportedOperationException("Mobile homes don't have address.");
    }

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
}
