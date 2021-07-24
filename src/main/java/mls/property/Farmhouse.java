package mls.property;

public class Farmhouse extends Property{
    private boolean barn;
    private boolean courtyard;

    /**
     * Copy constructor
     */
    public Farmhouse(Farmhouse property) {
        super(property);
        this.setBarn(property.hasBarn());
        this.setCourtyard(property.hasCourtyard());
    }

    /**
     * Builder constructor
     */
    public Farmhouse(Builder builder) {
        super(builder);
        this.barn = builder.barn;
        this.courtyard = builder.courtyard;
    }

    /**
     * Accessors mutators
     */

    public boolean hasBarn() {
        return barn;
    }

    public void setBarn(boolean barn) {
        this.barn = barn;
    }

    public boolean hasCourtyard() {
        return courtyard;
    }

    public void setCourtyard(boolean courtyard) {
        this.courtyard = courtyard;
    }

    @Override
    public String toString() {
        return "Farmhouse{" +
                "barn=" + barn +
                ", courtyard=" + courtyard +
                "} " + super.toString();
    }

    /**
     * Returns true if obj is identical to this instance.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !obj.getClass().equals(this.getClass()))
            return false;

        Farmhouse p = (Farmhouse) obj;

        return super.equals(p) &&
                this.courtyard == p.hasCourtyard() &&
                this.barn == p.hasBarn();
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
        private boolean barn = false;
        private boolean courtyard = false;

        public Builder hasBarn() {
            this.barn = true;
            return this;
        }

        public Builder hasCourtyard() {
            this.courtyard = true;
            return this;
        }

        @Override
        public Farmhouse build() {
            return new Farmhouse(this);
        }
    }
}
