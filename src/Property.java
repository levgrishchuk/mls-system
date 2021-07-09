import java.util.HashMap;
import java.util.List;

public class Property {
    // fields
    private Address address;
    private Double annualTax;
    private boolean isUnderConstruction;
    private boolean isNewConstruction;
    private Size landSize;
    private List<Exterior> exteriors;
    private Building building;
    private List<NeighbourhoodFeatures> neighbourhood;

    public Property(HashMap<String, Object> record) {
        this.address = record.get("address");
        this.annualTax = annualTax;
        this.isUnderConstruction = isUnderConstruction;
        this.isNewConstruction = isNewConstruction;
        this.landSize = landSize;
        this.exteriors = exteriors;
        this.building = building;
        this.neighbourhood = neighbourhood;
    }
}
