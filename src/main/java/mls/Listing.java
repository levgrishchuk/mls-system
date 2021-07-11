package mls;
import mls.property.*;

import java.util.Date;
import java.util.UUID;

/**
 * Represents a Listing
 * Mutable class
 * Builder design pattern (nested static Builder class)
 * Listing class uses a default constructor
 * Nested enum type
 */
public class Listing {
    private UUID mlsNumber;
    private float listingPrice;
    private Date dateAdded;
    private Date dateSold;
    private Property property;
    private String description;
    private Participant propertyOwner;
    private Broker broker;
    private Participant buyer;
    private Status status;

    // no constructor (default)

    public UUID getMlsNumber() {
        return mlsNumber;
    }

    public float getListingPrice() {
        return listingPrice;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public Date getDateSold() {
        return dateSold;
    }

    public Property getProperty() {
        return property;
    }

    public String getDescription() {
        return description;
    }

    public Participant getPropertyOwner() {
        return propertyOwner;
    }

    public Broker getBroker() {
        return broker;
    }

    public Participant getBuyer() {
        return buyer;
    }

    public Status getStatus() {
        return status;
    }

    public void setMlsNumber(UUID mlsNumber) {
        this.mlsNumber = mlsNumber;
    }

    public void setListingPrice(float listingPrice) {
        this.listingPrice = listingPrice;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public void setDateSold(Date dateSold) {
        this.dateSold = dateSold;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPropertyOwner(Participant propertyOwner) {
        this.propertyOwner = propertyOwner;
    }

    public void setBroker(Broker broker) {
        this.broker = broker;
    }

    public void setBuyer(Participant buyer) {
        this.buyer = buyer;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * enum type used for Status field
     */
    enum Status {
        Active, Sold, Withdraw
    }

    /**
     * Nested static Builder class (Builder design)
     * Each setter method returns the Builder instance
     * The Build() method assigns the set fields of the Builder to a new Listing object
     */
    public static class Builder {
        // fields
        private UUID mlsNumber;
        private float listingPrice;
        private Date dateAdded;
        private Date dateSold;
        private Property property;
        private String description;
        private Participant propertyOwner;
        private Broker broker;
        private Participant buyer;
        private Status status;

        /**
         * Builder constructor
         * @param mlsNumber A UUID
         */
        public Builder(UUID mlsNumber){
            this.mlsNumber = mlsNumber;
        }

        /**
         * An example of a setter method
         * @param mlsNumber A UUID
         * @return Current Builder instance
         */
        public Builder setMlsNumber(UUID mlsNumber) {
            this.mlsNumber = mlsNumber;
            return this;
        }

        public Builder setListingPrice(float listingPrice) {
            this.listingPrice = listingPrice;
            return this;
        }

        public Builder setDateAdded(Date dateAdded) {
            this.dateAdded = dateAdded;
            return this;
        }

        public Builder setDateSold(Date dateSold) {
            this.dateSold = dateSold;
            return this;
        }

        public Builder setProperty(Property property) {
            this.property = property;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setPropertyOwner(Participant propertyOwner) {
            this.propertyOwner = propertyOwner;
            return this;
        }

        public Builder setBroker(Broker broker) {
            this.broker = broker;
            return this;
        }

        public Builder setBuyer(Participant buyer) {
            this.buyer = buyer;
            return this;
        }

        public Builder setStatus(Status status) {
            this.status = status;
            return this;
        }

        /**
         * Assigns all fields of the current Builder instance to a new Listing object
         * @return A Listing object
         */
        public Listing build() {
            Listing mls = new Listing();
            mls.mlsNumber = this.mlsNumber;
            mls.listingPrice = this.listingPrice;
            mls.dateAdded = this.dateAdded;
            mls.dateSold = this.dateSold;
            mls.property = this.property;
            mls.description = this.description;
            mls.propertyOwner = this.propertyOwner;
            mls.broker = this.broker;
            mls.buyer = this.buyer;
            mls.status = this.status;
            return mls;
        }
    }

}
