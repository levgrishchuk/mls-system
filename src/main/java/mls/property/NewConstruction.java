package mls.property;

import mls.property.structure.Building;
import mls.property.structure.exterior.Exterior;

import java.util.List;

public class NewConstruction extends Property{

    /**
     * Throws exception because new construction doesn't have a building.
     */
    @Override
    public Building getBuilding() {
        throw new UnsupportedOperationException("New construction doesn't have a building.");
    }

    /**
     * Throws exception because new construction doesn't have exteriors.
     */
    @Override
    public List<Exterior> getExteriors() {
        throw new UnsupportedOperationException("New construction doesn't have exteriors.");
    }
}
