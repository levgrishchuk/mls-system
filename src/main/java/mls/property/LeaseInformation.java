package mls.property;

public class LeaseInformation {
    private String landlord;
    private Double monthlyFee;

    /**
     * Copy constructor
     * @param leaseInformation Lease information.
     */
    public LeaseInformation(LeaseInformation leaseInformation) {
        setLandlord(leaseInformation.getLandlord());
        setMonthlyFee(leaseInformation.getMonthlyFee());
    }

    /**
     * Constructor
     * @param landlord
     * @param monthlyFee
     */
    public LeaseInformation(String landlord, Double monthlyFee) {
        this.landlord = landlord;
        this.monthlyFee = monthlyFee;
    }

    /**
     * Get landlord's name or corporation name.
     * @return name.
     */
    public String getLandlord() {
        return landlord;
    }

    /**
     * Set landlord's name.
     * @param landlord
     */
    public void setLandlord(String landlord) {
        this.landlord = landlord;
    }

    /**
     * Get monthly fee.
     * @return monthly fee.
     */
    public Double getMonthlyFee() {
        return monthlyFee;
    }

    /**
     * Sets monthly fee.
     * @param monthlyFee monthly fee greater than zero. Otherwise throws exception.
     */
    public void setMonthlyFee(Double monthlyFee) {
        if (monthlyFee <= 0)
            throw new IllegalArgumentException("Monthly fee cannot be less or equal to zero.");

        this.monthlyFee = monthlyFee;
    }
}
