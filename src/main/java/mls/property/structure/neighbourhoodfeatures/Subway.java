package mls.property.structure.neighbourhoodfeatures;

public class Subway implements NeighbourhoodFeatures{
    private String link;

    public Subway(Subway other) {
        this.link = other.link;
    }

    public Subway(){}
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

    @Override
    public boolean equals(Object other){
        if(other.getClass() != Subway.class){
            return false;
        }
        return (this.getLink().equals(((Subway) other).getLink()));
    }
}
