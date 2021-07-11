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

    enum NeighbourhoodFeatures {
        School, Subway, Hospital, Park
    }
}
