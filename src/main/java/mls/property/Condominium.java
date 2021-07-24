package mls.property;

public class Condominium extends FamilyHome {
    enum CondominiumType {SingleUnit, Duplex, Triplex, Multilex};

    /**
     * Copy constructor
     * @param property
     */
    public Condominium(Condominium property) {
        super(property);
    }

    /**
     * Builder constructor
     */
    protected Condominium(Builder builder) {
        super(builder);
    }

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

    /**
     * Returns true if obj is identical to this instance.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !obj.getClass().equals(this.getClass()))
            return false;

        Condominium p = (Condominium) obj;

        return super.equals(p);
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
        public Condominium build() {
            return new Condominium(this);
        }
    }
}

