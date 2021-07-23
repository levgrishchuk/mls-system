package mls.property.structure.exterior;

import mls.Size;

public abstract class Exterior {
    private Size size;
    private Type type = Type.Other;
    public enum Type {
        Backyard, Deck, Lawn, Parking, Pool, Other
    }

    public Exterior(){
        this.size = null;
        this.type = Type.Other;
    }

    public Exterior(Exterior exterior){
        this.size = exterior.size;
        if(type != null){
            this.type = exterior.type;
        }
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
}
