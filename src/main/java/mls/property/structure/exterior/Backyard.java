package mls.property.structure.exterior;

public class Backyard extends Exterior {
    public Backyard(Builder builder) {
        super(builder);
    }
    public static class Builder extends Exterior.Builder<Builder>{
        public Backyard build(){
            return new Backyard(this);
        }
    }
}
