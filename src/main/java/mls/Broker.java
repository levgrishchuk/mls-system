package mls;

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
}
