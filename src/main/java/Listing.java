package main.java;

import java.util.Date;
import java.util.UUID;

public class Listing {
    // fields
    private UUID mlsNnumber;
    private float listingPrice;
    private Date dateAdded;
    private Date dateSold;
    private Property property;
    private String description;
    private Participant propertyOwner;
    private Broker broker;
    private Participant buyer;
    private String status;

    // methods
    // getters
    public String getStatus(){
        return this.status;
    }

}
