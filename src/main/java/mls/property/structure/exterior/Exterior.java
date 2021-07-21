package mls.property.structure.exterior;

import mls.Size;

public abstract class Exterior {
    private Size size;
    private Type type;
    public enum Type {
        Backyard, Deck, Lawn, Parking, Pool, Other
    }

    public Exterior(Builder builder){
        this.size = builder.size;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public static class Builder<T extends Builder<T>>{
        private Size size;

        public Builder setSize(Size size) {
            this.size = size;
            return this;
        }
    }
}
