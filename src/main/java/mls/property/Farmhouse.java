package mls.property;

public class Farmhouse extends Property{
    private boolean barn;
    private boolean courtyard;

    public boolean hasBarn() {
        return barn;
    }

    public void setBarn(boolean barn) {
        this.barn = barn;
    }

    public boolean hasCourtyard() {
        return courtyard;
    }

    public void setCourtyard(boolean courtyard) {
        this.courtyard = courtyard;
    }
}
