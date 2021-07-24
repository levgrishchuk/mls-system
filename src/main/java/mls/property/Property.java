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
    private Double annualTax = 0.0;
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
            setLeasehold(property.leaseInformation);
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
    public void addExterior(Exterior exterior) {
        this.exteriors.add(exterior);
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

    public LeaseInformation getLeaseInformation() {
        return new LeaseInformation(this.leaseInformation);
    }

    public void addNeighbourhoodFeature(NeighbourhoodFeatures neighbourhoodFeatures) {
        this.neighbourhood.add(neighbourhoodFeatures);
    }

    /**
     * Sets property lease type to leasehold.
     * @param leaseInformation Lease information.
     */
    public void setLeasehold(LeaseInformation leaseInformation) {
        this.leaseInformation = new LeaseInformation(leaseInformation);
    }

    /**
     * Sets property lease type to freehold.
     */
    public void setFreehold() {
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
     * Returns true if obj is identical to this instance.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Property))
            return false;

        Property p = (Property) obj;

        boolean addrEq = true;
        boolean sizeEq = true;
        boolean builEq = true;
        boolean neigEq = true;
        boolean leasEq = true;

        // check leaseinfo
        if(this.leaseInformation == null) {
            if (p.leaseInformation != null)
                return false;
        }
        else
            leasEq = this.leaseInformation.equals(p.getLeaseInformation());

        // check neighborhood
        if(this.neighbourhood == null) {
            if (p.neighbourhood != null)
                return false;
        }
        else
            neigEq = this.neighbourhood.equals(p.getNeighbourhood());

        // check building
        if(this.building == null) {
            if (p.building != null)
                return false;
        }
        else
            builEq = this.building.equals(p.getBuilding());

        // check size
        if(this.landSize == null) {
            if (p.landSize != null)
                return false;
        }
        else
            sizeEq = this.landSize.equals(p.getLandSize());

        // check address
        if(this.address == null) {
            if (p.address != null)
                return false;
        }
        else
            addrEq = this.address.equals(p.getAddress());

        // check others
        return Double.compare(this.annualTax, p.getAnnualTax()) == 0 &&
                this.isUnderConstruction == p.isUnderConstruction() &&
                this.exteriors.equals(p.getExteriors()) &&
                addrEq &&
                sizeEq &&
                neigEq &&
                builEq &&
                leasEq;
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
        private NeighbourhoodFeaturesContainer neighbourhood = new NeighbourhoodFeaturesContainer();
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

        public T neighbourhoodFeaturesList(List<NeighbourhoodFeatures> list){
            this.neighbourhood = new NeighbourhoodFeaturesContainer(list);
            return (T) this;
        }

        public T addNeighbourhoodFeature(NeighbourhoodFeatures neighbourhoodFeatures) {
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
