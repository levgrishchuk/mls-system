package mls.property.structure.exterior;

import mls.Size;
import mls.property.structure.exterior.Exterior;

public class Lawn extends Exterior {
    public Lawn(){}
    public Lawn(Size size) {
        super(size);
    }

    /**
     * copy constructor
     * @param other
     */
    public Lawn(Lawn other){
        super(other);
    }
}
