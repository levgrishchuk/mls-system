package mls;

/**
 * Represents an address
 * Immutable class (final fields, no setters, Deep Copy constructor)
 */
final public class Address {
    private final int streetNumber;
    private final String streetName;
    private final String city;
    private final String province;
    private final String postalCode;

    /**
     * Constructor performing Deep Copy (though there are no mutable parameters...)
     * @param streetNumber
     * @param streetName
     * @param city
     * @param province
     * @param postalCode
     */
    public Address(int streetNumber, String streetName, String city, String province, String postalCode) {
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
    }

    /**
     * Copy constructor performing Deep Copy (though all fields in address are immutable)
     * @param address
     */
    public Address(Address address) {

        this.streetNumber = address.streetNumber;
        this.streetName = address.streetName;
        this.city = address.city;
        this.province = address.province;
        this.postalCode = address.postalCode;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    @Override
    public boolean equals(Object other){
        if(other == null || other.getClass() != Address.class){
            return false;
        }
        return (this.getStreetNumber() == ((Address) other).getStreetNumber()) &&
                (this.getStreetName().equals(((Address) other).getStreetName())) &&
                (this.getCity().equals(((Address) other).getCity())) &&
                (this.getProvince().equals(((Address) other).getProvince())) &&
                (this.getPostalCode().equals(((Address) other).getPostalCode()));


    }

}
