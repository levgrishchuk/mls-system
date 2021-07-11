package mls.property;

public class StackedTownhouse extends FamilyHome {
    private final Townhouse unitTownhouse;
    private Integer stackCount;

    public StackedTownhouse(Townhouse unitTownhouse, Integer stackCount) {
        this.unitTownhouse = unitTownhouse;
        this.stackCount = stackCount;
    }

    public Townhouse getUnitTownhouse() {
        return unitTownhouse;
    }

    public Integer getStackCount() {
        return stackCount;
    }

    public void setStackCount(Integer stackCount) {
        this.stackCount = stackCount;
    }
}