package mls.property;

public class TripleDecker extends FamilyHome {

    /**
     * Copy constructor
     */
    public TripleDecker(TripleDecker property) {
        super(property);
    }

    /**
     * Builder constructor
     */
    public TripleDecker(Builder builder) {
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
        public TripleDecker build() {
            return new TripleDecker(this);
        }
    }
}
