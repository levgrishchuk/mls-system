package mls;

import java.util.Objects;

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

    /**
     * Copy constructor
     */
    public Participant(Participant participant) {
        this.name = participant.getName();
        this.address = new Address(participant.getAddress());
        this.email = participant.getEmail();
        this.phone = participant.getPhone();
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

    /**
     * Returns if obj is equal to this instance.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Participant)) return false;
        Participant that = (Participant) o;
        return Objects.equals(getName(), that.getName()) && Objects.equals(getAddress(), that.getAddress()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getPhone(), that.getPhone());
    }
}
