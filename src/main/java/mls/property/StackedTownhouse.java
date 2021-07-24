package mls.property;

public class StackedTownhouse extends FamilyHome {
    private Townhouse unitTownhouse;
    private Integer stackCount;

    /**
     * Copy constructor
     * @param property An instance of stacked townhouse.
     */
    public StackedTownhouse(StackedTownhouse property) {
        super(property);
        this.setUnitTownhouse(property.getUnitTownhouse());
        this.setStackCount(property.getStackCount());
    }

    /**
     * Builder constructor
     */
    public StackedTownhouse(Builder builder) {
        super(builder);
        this.unitTownhouse = builder.unitTownhouse;
        this.stackCount = builder.stackCount;
    }

    /**
     * Accessors/mutators
     */
    public Townhouse getUnitTownhouse() {
        return unitTownhouse;
    }

    public Integer getStackCount() {
        return stackCount;
    }

    public void setStackCount(Integer stackCount) {
        this.stackCount = stackCount;
    }

    public void setUnitTownhouse(Townhouse unitTownhouse) {
        this.unitTownhouse = new Townhouse(unitTownhouse);
    }

    /**
     * To string
     */
    @Override
    public String toString() {
        return "StackedTownhouse{" +
                "unitTownhouse=" + unitTownhouse +
                ", stackCount=" + stackCount +
                "} " + super.toString();
    }

    /**
     * Returns true if obj is identical to this instance.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !obj.getClass().equals(this.getClass()))
            return false;

        StackedTownhouse p = (StackedTownhouse) obj;

        return super.equals(p) &&
                Integer.compare(this.stackCount, p.getStackCount()) == 0 &&
                this.getUnitTownhouse().equals(p.getUnitTownhouse());
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
        private Townhouse unitTownhouse;
        private Integer stackCount;

        public Builder unit(Townhouse unitTownhouse) {
            this.unitTownhouse = new Townhouse(unitTownhouse);
            return this;
        }

        public Builder stack(Integer stackCount) {
            this.stackCount = stackCount;
            return this;
        }

        @Override
        public StackedTownhouse build() {
            if (stackCount == null || stackCount <= 1 || unitTownhouse == null)
                throw new RuntimeException("Some necessary fields hasn't been set correctly.");

            return new StackedTownhouse(this);
        }
    }
}