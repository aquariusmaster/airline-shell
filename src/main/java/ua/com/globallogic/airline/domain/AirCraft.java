package ua.com.globallogic.airline.domain;

/**
 * A class representing a single aircraft in a single class.
 */
public class AirCraft {

    /**
     * Id of the AirCraft.
     */
    private Long id;

    /**
     * Capacity of the AirCraft.
     */
    private double capacity;

    /**
     * Carrying Capacity of the AirCraft.
     */
    private double carryingCapacity;

    /**
     * Flight Range of the AirCraft.
     */
    private double flightRange;

    /**
     * Fuel Consumption of the AirCraft.
     */
    private double fuelConsumption;

    /**
     * Get Id of the AirCraft.
     * @return Id of the AirCraft.
     */
    public Long getId() {
        return id;
    }

    /**
     * Set Id of the AirCraft.
     * @param id Id of the AirCraft.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get capacity of the AirCraft.
     * @return capacity of the AirCraft.
     */
    public double getCapacity() {
        return capacity;
    }

    /**
     * Set capacity of the AirCraft.
     * @param capacity capacity of the AirCraft.
     */
    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    /**
     * Get Carrying Capacity of the AirCraft.
     * @return Carrying Capacity of the AirCraft.
     */
    public double getCarryingCapacity() {
        return carryingCapacity;
    }

    /**
     * Set Carrying Capacity of the AirCraft.
     * @param carryingCapacity Carrying Capacity of the AirCraft.
     */
    public void setCarryingCapacity(double carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    /**
     * Get Flight Range of the AirCraft.
     * @return Flight Range of the AirCraft.
     */
    public double getFlightRange() {
        return flightRange;
    }

    /**
     * Set Fuel Consumption of the AirCraft.
     * @param flightRange Fuel Consumption of the AirCraft.
     */
    public void setFlightRange(double flightRange) {
        this.flightRange = flightRange;
    }

    /**
     * Get Fuel Consumption of the AirCraft.
     * @return Fuel Consumption of the AirCraft.
     */
    public double getFuelConsumption() {
        return fuelConsumption;
    }

    /**
     * Set Fuel Consumption of the AirCraft.
     * @param fuelConsumption Fuel Consumption of the AirCraft.
     */
    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AirCraft airCraft = (AirCraft) o;

        return id != null ? id.equals(airCraft.id) : airCraft.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "AirCraft{" +
                "id=" + id +
                ", capacity=" + capacity +
                ", carryingCapacity=" + carryingCapacity +
                ", flightRange=" + flightRange +
                ", fuelConsumption=" + fuelConsumption +
                '}';
    }
}
