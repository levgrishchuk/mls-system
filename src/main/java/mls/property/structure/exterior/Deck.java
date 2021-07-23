package mls.property.structure.exterior;

import mls.Size;
import mls.property.structure.exterior.Exterior;

public class Deck extends Exterior {
    public Deck(){}
    public Deck(Size size) {
        super(size);
    }

    /**
     * copy constructor
     * @param other
     */
    public Deck(Deck other){
        super(other);
    }

}
