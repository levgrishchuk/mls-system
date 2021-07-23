package mls.property.structure.exterior;

import mls.Size;

public abstract class Exterior {
    private Size size;

    public Exterior(){
        this.size = null;
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

//    public boolean equals(Exterior other){
//        if(this == other){
//            return true;
//        }
//
//        if()
//    }

}
