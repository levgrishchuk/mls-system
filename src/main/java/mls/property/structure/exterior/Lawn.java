package mls.property.structure.exterior;

import mls.property.structure.exterior.Exterior;

public class Lawn extends Exterior {
    public Lawn(Builder builder) {
        super(builder);
    }
    public static class Builder extends Exterior.Builder<Backyard.Builder>{
        public Lawn build(){
            return new Lawn(this);
        }
    }
}
