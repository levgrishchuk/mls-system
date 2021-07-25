package mls.property.structure.neighbourhoodfeatures;

public class Subway implements NeighbourhoodFeatures{
    private String link;

    public Subway(){}
    public Subway(Subway other) {
        this.link = other.link;
    }
    public Subway(String link){
        this.link = link;
    }
    public void setLink(String link){
        this.link = link;
    }

    public String getLink(){
        return this.link;
    }
    public NeighbourhoodFeatures makeCopy(){
        return new Subway(this);
    }

    /**
     * compares attributes of other Subway classes
     * @param other
     * @return true if equal, false if not
     */
    @Override
    public boolean equals(Object other){
        if(other == null || other.getClass() != Subway.class){
            return false;
        }
        return (this.getLink().equals(((Subway) other).getLink()));
    }
}
