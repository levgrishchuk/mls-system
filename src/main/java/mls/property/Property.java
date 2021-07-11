package mls.property;

import mls.*;
import mls.property.structure.*;
import mls.property.structure.exterior.*;

import java.rmi.dgc.Lease;
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
    private LeaseInformation leaseInformation;

    enum LeaseType { Freehold, Leasehold};

    enum NeighbourhoodFeatures {
        School, Subway, Hospital, Park
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Double getAnnualTax() {
        return annualTax;
    }

    public void setAnnualTax(Double annualTax) {
        this.annualTax = annualTax;
    }

    public boolean isUnderConstruction() {
        return isUnderConstruction;
    }

    public void setUnderConstruction(boolean underConstruction) {
        isUnderConstruction = underConstruction;
    }

    public boolean isNewConstruction() {
        return isNewConstruction;
    }

    public void setNewConstruction(boolean newConstruction) {
        isNewConstruction = newConstruction;
    }

    public Size getLandSize() {
        return landSize;
    }

    public void setLandSize(Size landSize) {
        this.landSize = landSize;
    }

    public List<Exterior> getExteriors() {
        return exteriors;
    }

    public void setExteriors(List<Exterior> exteriors) {
        this.exteriors = exteriors;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public List<NeighbourhoodFeatures> getNeighbourhood() {
        return neighbourhood;
    }

    public void setNeighbourhood(List<NeighbourhoodFeatures> neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

    /**
     * Sets property lease type to leasehold.
     * @param leaseInformation Lease information.
     */
    public void makeLeasehold(LeaseInformation leaseInformation) {
        this.leaseInformation = new LeaseInformation(leaseInformation);
    }

    /**
     * Sets property lease type to freehold.
     */
    public void makeFreehold() {
        this.leaseInformation = null;
    }

    /**
     * Returns property lease type.
     * @return Lease type.
     */
    public LeaseType getLeaseType() {
        return (this.leaseInformation == null) ? LeaseType.Freehold : LeaseType.Leasehold;
    }

}
