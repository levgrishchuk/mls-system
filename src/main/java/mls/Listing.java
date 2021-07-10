package mls;

import mls.property.*;

import java.util.Date;
import java.util.UUID;

public class Listing {
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

    // no constructor (default)

    // methods

    // enum type
    enum Status {
        Active, Sold, Withdraw
    }

    // Builder design
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

        public Builder(UUID mlsNumber){
            this.mlsNumber = mlsNumber;
        }

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
