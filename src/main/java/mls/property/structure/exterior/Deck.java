package mls.property.structure.exterior;

import mls.property.structure.exterior.Exterior;

public class Deck extends Exterior {
    public Deck(Builder builder) {
        super(builder);
    }
    public static class Builder extends Exterior.Builder<Backyard.Builder>{
        public Deck build(){
            return new Deck(this);
        }
    }
}
