package mls;

/**
 * Represents a brokerage
 * Mutable class
 */
public class Brokerage {
    private String corporateName;
    private Address address;

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
}
