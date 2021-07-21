package mls;
import com.google.gson.JsonObject;
import mls.property.*;
import java.util.Date;
import java.util.UUID;

/**
 * Represents a Listing
 * Mutable class
 * Builder design pattern (nested static Builder class)
 * Listing class has a default constructor and a copy constructor
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

    /**
     * enum type used for Status field
     */
    public enum Status {
        Active, Sold, Withdraw
    }

    public Listing(){} // default constructor

    /**
     * Builder constructor, see Builder class below
     */
    public Listing(Listing.Builder builder) {
        this.mlsNumber = builder.mlsNumber;
        this.listingPrice = builder.listingPrice;
        this.dateAdded = builder.dateAdded;
        this.dateSold = builder.dateSold;
        this.property = builder.property;
        this.description = builder.description;
        this.propertyOwner = builder.propertyOwner;
        this.broker = builder.broker;
        this.buyer = builder.buyer;
        this.status = builder.status;
    }

    /**
     * Copy constructor
     */
    public Listing(Listing other) {
        this.mlsNumber = other.mlsNumber;
        this.listingPrice = other.listingPrice;
        this.dateAdded = other.dateAdded;
        this.dateSold = other.dateSold;
        this.property = other.property;
        this.description = other.description;
        this.propertyOwner = other.propertyOwner;
        this.broker = other.broker;
        this.buyer = other.buyer;
        this.status = other.status;
    }

    /**
     * getters and setters
     */
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
     * Nested static Builder class (Builder design)
     * Each setter method returns the Builder instance
     * The Build() method calls a Listing constructor with it's fields
     */
    public static class Builder<T extends Property.Builder<T>> {
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
         * @throws RuntimeException when listing price <= 0
         */
        public Listing build() {

            if (this.listingPrice <= 0.0){
                throw new RuntimeException("listing price must be positive");
            }
            return new Listing(this);
        }
    }

}
