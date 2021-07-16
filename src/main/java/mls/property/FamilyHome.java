package mls.property;

public abstract class FamilyHome extends Property{

    /**
     * Copy constructor
     * @param property
     */
    public FamilyHome(FamilyHome property) {
        super(property);
    }

    /**
     * Builder constructor
     */
    public FamilyHome(Property.Builder builder) {
        super(builder);
    }

    /**
     * Retunrs if multifamily. A property is multifamily if it's building has more than one unit.
     */
    public boolean isMultiFamily() {
        return this.getBuilding().getUnitCount() > 1;
    }
}
