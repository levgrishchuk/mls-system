package mls.property;

public class Townhouse extends FamilyHome {

    /**
     * Copy constructor.
     */
    public Townhouse(Townhouse property) {
        super(property);
    }

    /**
     * Builder constructor
     */
    public Townhouse(Builder builder) {
        super(builder);
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
        public Townhouse build() {
            return new Townhouse(this);
        }
    }
}