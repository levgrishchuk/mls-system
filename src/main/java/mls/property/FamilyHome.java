package mls.property;

public abstract class FamilyHome extends Property{

    public boolean isMultiFamily() {
        return this.getBuilding().getUnitCount() > 1;
    }
}
