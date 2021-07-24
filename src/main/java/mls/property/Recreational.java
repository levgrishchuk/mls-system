package mls.property;

public class Recreational extends Property{
    public enum RecreationalType {Cabin, Cottage, Park, Other};

    private RecreationalType type = RecreationalType.Other;

    /**
     * Copy constructor.
     */
    public Recreational(Recreational property) {
        super(property);
        this.setType(property.getType());
    }

    /**
     * Builder constructor
     */
    public Recreational(Builder builder) {
        super(builder);
        this.type = builder.type;
    }

    /**
     * Accessor/mutators
     */

    public RecreationalType getType() {
        return type;
    }

    public void setType(RecreationalType type) {
        this.type = type;
    }

    /**
     * toString
     * @return String
     */
    @Override
    public String toString() {
        return "Recreational{" +
                "type=" + type +
                "} " + super.toString();
    }

    /**
     * Returns true if obj is identical to this instance.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !obj.getClass().equals(this.getClass()))
            return false;

        Recreational p = (Recreational) obj;

        return super.equals(p) &&
                this.type == p.getType();
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
        private RecreationalType type = RecreationalType.Other;

        public Builder type(RecreationalType type) {
            this.type = type;
            return this;
        }

        @Override
        public Recreational build() {
            return new Recreational(this);
        }
    }
}
