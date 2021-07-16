package mls.property;

public class CoopHome extends FamilyHome{
    /**
     * Copy constructor
     */
    public CoopHome(CoopHome property) {
        super(property);
    }

    /**
     * Builder constructor
     */
    public CoopHome(Builder builder) {
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
        public CoopHome build() {
            return new CoopHome(this);
        }
    }
}
