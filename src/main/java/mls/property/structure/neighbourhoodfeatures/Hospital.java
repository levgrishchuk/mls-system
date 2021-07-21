package mls.property.structure.neighbourhoodfeatures;

/**
 * Implementation of interface, implements link features.
 * Also has separate phone number feature.
 */
public class Hospital implements NeighbourhoodFeatures {
    private String link;
    private String phoneNumber;


    public Hospital(Builder builder){
        this.link = builder.link;
        this.phoneNumber = builder.phoneNumber;
    }

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

    public static class Builder<T extends Builder<T>>{
        private String link;
        private String phoneNumber;

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setLink(String link){
            this.link = link;
            return this;
        }

        public Hospital build(){
            return new Hospital(this);
        }
    }
}
