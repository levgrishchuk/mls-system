package mls.property.structure.neighbourhoodfeatures;

import mls.property.structure.Room;

/**
 * Implementation of interface, implements link features.
 * Also has separate phone number feature.
 */
public class Hospital implements NeighbourhoodFeatures {
    private String link;
    private String phoneNumber;

    public Hospital(){}
    public Hospital(String link, String phoneNumber){
        this.link = link;
        this.phoneNumber = phoneNumber;
    }

    /**
     * copy constructor
     * @param other
     */
    public Hospital(Hospital other) {
        this.link = other.link;
        this.phoneNumber = other.phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setLink(String link){
        this.link = link;
    }

    public String getLink(){
        return this.link;
    }

    public NeighbourhoodFeatures makeCopy(){
        return new Hospital(this);
    }

    @Override
    public boolean equals(Object other){
        if(other.getClass() != Hospital.class){
            return false;
        }
        return (this.getLink().equals(((Hospital) other).getLink()) &&
                this.getPhoneNumber().equals(((Hospital) other).getPhoneNumber()));
    }

}
