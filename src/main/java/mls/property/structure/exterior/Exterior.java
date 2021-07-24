package mls.property.structure.exterior;

import mls.Size;
import mls.property.structure.Room;

public abstract class Exterior {
    private Size size;

    public Exterior(){
        this.size = null;
    }

    /**
     * copy constructor
     * @param exterior
     */
    public Exterior(Exterior exterior){
        this.size = exterior.size;
    }

    public Exterior(Size size){
        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object other){
        if(other.getClass().getSuperclass() != Exterior.class){
            return false;
        }
        if(this == other){
            return true;
        }

        return this.getSize().equals(((Exterior) other).getSize());
    }

}
