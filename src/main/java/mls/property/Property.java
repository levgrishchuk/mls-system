package mls.property;

import mls.*;
import mls.property.structure.*;
import mls.property.structure.exterior.*;
import mls.property.structure.neighbourhoodfeatures.NeighbourhoodFeatures;
import mls.property.structure.neighbourhoodfeatures.NeighbourhoodFeaturesContainer;

import java.util.ArrayList;
import java.util.List;

public class Property {
    private Address address;
    private Double annualTax;
    private boolean isUnderConstruction = false;
    private Size landSize;
    private List<Exterior> exteriors = new ArrayList<>();
    private Building building;
    private NeighbourhoodFeaturesContainer neighbourhood = new NeighbourhoodFeaturesContainer();
    private LeaseInformation leaseInformation;

    public enum LeaseType { Freehold, Leasehold};



    private Property() {};

    /**
     * Copy constructor
     * @param property
     */
    public Property(Property property) {
        this.setAddress(property.getAddress());
        this.setAnnualTax(property.getAnnualTax());
        this.setUnderConstruction(property.isUnderConstruction());
        this.setLandSize(property.getLandSize());
        this.setExteriors(property.getExteriors());
        this.setBuilding(property.getBuilding());
        this.setNeighbourhood(property.getNeighbourhood());

        if (property.leaseInformation != null)
            makeLeasehold(property.leaseInformation);
    }

    /**
     * Builder constructor
     * @param builder
     */
    protected Property(Property.Builder builder) {
        this.address = builder.address;
        this.annualTax = builder.annualTax;
        this.isUnderConstruction = builder.isUnderConstruction;
        this.landSize = builder.landSize;
        this.exteriors = builder.exteriors;
        this.building = builder.building;
        this.neighbourhood = builder.neighbourhood;
        this.leaseInformation = builder.leaseInformation;
    }

    /**
     * Accessors and mutators
     */

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
        this.exteriors.clear();
        this.exteriors.addAll(exteriors);
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = new Building(building);
    }

    public NeighbourhoodFeaturesContainer getNeighbourhood() {
        return neighbourhood;
    }

    public void setNeighbourhood(NeighbourhoodFeaturesContainer neighbourhood) {
        this.neighbourhood.setNeighbourhood(neighbourhood);
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

    /**
     * Returns an instance of Property.Builder.
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * To string
     * @return
     */
    @Override
    public String toString() {
        return "Property{" +
                "address=" + address +
                ", annualTax=" + annualTax +
                ", isUnderConstruction=" + isUnderConstruction +
                ", landSize=" + landSize +
                ", exteriors=" + exteriors +
                ", building=" + building +
                ", neighbourhood=" + neighbourhood +
                ", leaseInformation=" + leaseInformation +
                '}';
    }

    /**
     * PropertyBuilder class
     */
    public static class Builder<T extends Builder<T>> {
        private Address address;
        private Double annualTax;
        private boolean isUnderConstruction = false;
        private Size landSize;
        private List<Exterior> exteriors = new ArrayList<>();
        private Building building;
        private NeighbourhoodFeaturesContainer neighbourhood = new NeighbourhoodFeaturesContainer();;
        private LeaseInformation leaseInformation;

        public T address(Address address) {
            this.address = address;
            return (T) this;
        }

        public T annualTax(Double annualTax) {
            this.annualTax = annualTax;
            return (T) this;
        }

        public T underConstruction() {
            this.isUnderConstruction = true;
            return (T) this;
        }

        public T landSize(Size landSize) {
            this.landSize = landSize;
            return (T) this;
        }

        public T addExterior(Exterior exterior) {
            this.exteriors.add(exterior);
            return (T) this;
        }

        public T building(Building building) {
            this.building = new Building(building);
            return (T) this;
        }

        public T neighbourhoodFeature(List<NeighbourhoodFeatures> list){
            this.neighbourhood = new NeighbourhoodFeaturesContainer(list);
            return (T) this;
        }

        public T addNeighbourhood(NeighbourhoodFeatures neighbourhoodFeatures) {
            this.neighbourhood.add(neighbourhoodFeatures);
            return (T) this;
        }

        public T lease(LeaseInformation leaseInformation) {
            this.leaseInformation = new LeaseInformation(leaseInformation);
            return (T) this;
        }

        public Property build() {
            // Validate
            if (address == null ||
                    annualTax <= 0 ||
                    landSize == null
            )
                throw new RuntimeException("Some necessary fields contains invalid data.");

            return new Property(this);
        }
    }
}
