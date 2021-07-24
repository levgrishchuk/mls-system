package mls;

import mls.property.Property;

/**
 * Represents a broker
 * Mutable class
 */
public class Broker extends Participant {
    private Brokerage brokerage;

    /**
     * A constructor performing Deep Copy (brokerage object)
     * Uses super() to instantiate Participant fields
     * @param name
     * @param address
     * @param email
     * @param phone
     * @param brokerage
     */
    public Broker(String name, Address address, String email, String phone, Brokerage brokerage) {
        super(name, address, email, phone);
        this.brokerage = new Brokerage(brokerage);
    }

    /**
     * Copy constructor
     * Uses super() to instantiate Participant fields
     */
    public Broker(Broker broker){
        super(broker.getName(), broker.getAddress(), broker.getEmail(), broker.getPhone());
        this.brokerage = broker.brokerage;
    }

    public Brokerage getBrokerage(){
        return this.brokerage;
    }

    /**
     * Overrides Participant's getAddress(),
     * to return the brokerage's address
     * @return an Address object from Brokerage
     */
    public Address getAddress(){
        return brokerage.getAddress();
    }

    public void setBrokerage(Brokerage brokerage) {
        this.brokerage = brokerage;
    }

    /**
     * Returns true if obj is identical to this instance.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Broker))
            return false;

        Broker p = (Broker) obj;
        return super.equals(p) && this.brokerage.equals(p.getBrokerage());
    }
}
