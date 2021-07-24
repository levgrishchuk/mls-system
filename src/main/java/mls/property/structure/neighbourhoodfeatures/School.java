package mls.property.structure.neighbourhoodfeatures;

/**
 * Implementation of interface, implements link features.
 * Also has separate phone number feature.
 */
public class School implements NeighbourhoodFeatures {
    private String link;
    private String phoneNumber;

    public School(){
        this.link = "";
        this.phoneNumber = "";
    }
    public School(String link, String phoneNumber){
        this.link = link;
        this.phoneNumber = phoneNumber;
    }
    public School(School other) {
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
        return new School(this);
    }
}
