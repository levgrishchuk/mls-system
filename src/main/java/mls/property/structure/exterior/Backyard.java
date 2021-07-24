package mls.property.structure.exterior;

import mls.Size;

public class Backyard extends Exterior {
    public Backyard(){}
    public Backyard(Size size) {
        super(size);
    }

    /**
     * copy constructor
     * @param other
     */
    public Backyard(Backyard other){
        super(other);
    }
}
