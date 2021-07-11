package mls;

/**
 * Represents a participant
 * Mutable class
 */

public class Participant {
    private String name;
    private Address address;
    private String email;
    private String phone;

    /**
     * A constructor performing Deep Copy (for address field)
     * @param name
     * @param address
     * @param email
     * @param phone
     */
    public Participant(String name, Address address, String email, String phone) {
        this.name = name;
        this.address = new Address(address);
        this.email = email;
        this.phone = phone;
    }

    public Address getAddress(){
        return this.address;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
