package mls;

/**
 * Represents a brokerage
 * Mutable class
 */
public class Brokerage {
    private String corporateName;
    private Address address;

    public Brokerage(String corporateName, Address address) {
        this.corporateName = corporateName;
        this.address = new Address(address);
    }

    /**
     * Copy constructor
     * @param brokerage
     */
    public Brokerage(Brokerage brokerage){
        this.corporateName = brokerage.getCorporateName();
        this.address = new Address(brokerage.getAddress());
    }

    /**
     * Gets the corporate name
     * @return A string representing the corporate name
     */
    public String getCorporateName() {
        return corporateName;
    }

    /**
     * Gets the brokerage's address
     * @return An Address object
     */
    public Address getAddress() {
        return address;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Returns true if obj is identical to this instance.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Brokerage))
            return false;

        Brokerage p = (Brokerage) obj;
        return this.corporateName.equals(p.getCorporateName()) &&
                this.address.equals(p.getAddress());
    }
}
