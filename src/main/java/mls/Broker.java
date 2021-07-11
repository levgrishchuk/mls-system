package mls;

/**
 * Represents a broker
 * Mutable class
 */
public class Broker extends Participant {
    private Brokerage brokerage;

    public Broker(Brokerage brokerage) {
        this.brokerage = brokerage;
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
