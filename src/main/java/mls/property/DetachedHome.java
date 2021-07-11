package mls.property;

public class DetachedHome extends FamilyHome {
    private boolean isSemiDetached;

    public boolean isSemiDetached() {
        return isSemiDetached;
    }

    public void setSemiDetached(boolean semiDetached) {
        isSemiDetached = semiDetached;
    }
}
