package mls.property;

public class Condominium extends FamilyHome {
    enum CondominiumType {SingleUnit, Duplex, Triplex, Multilex};

    /**
     * Returns the type of condominium (i.e. single unit, duplex, triplex, multilex).
     * @return CondominiumType
     */
    public CondominiumType getCondominiumType() {
        switch (this.getBuilding().getUnitCount()) {
            case 1: return CondominiumType.SingleUnit;
            case 2: return CondominiumType.Duplex;
            case 3: return CondominiumType.Triplex;
            default: return CondominiumType.Multilex;
        }
    }
}

