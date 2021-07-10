package mls.property;

import mls.*;
import mls.property.structure.*;
import mls.property.structure.exterior.*;

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

//    public Property(HashMap<String, Object> record) {
//        this.address = (Address) record.get("address");
//        this.annualTax = annualTax;
//        this.isUnderConstruction = isUnderConstruction;
//        this.isNewConstruction = isNewConstruction;
//        this.landSize = landSize;
//        this.exteriors = exteriors;
//        this.building = building;
//        this.neighbourhood = neighbourhood;
//    }

    enum NeighbourhoodFeatures {
        School, Subway, Hospital, Park
    }
}
