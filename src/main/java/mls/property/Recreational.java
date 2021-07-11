package mls.property;

public class Recreational {
    enum RecreationalType {Cabin, Cottage, Park};

    private RecreationalType type;

    public RecreationalType getType() {
        return type;
    }

    public void setType(RecreationalType type) {
        this.type = type;
    }
}
