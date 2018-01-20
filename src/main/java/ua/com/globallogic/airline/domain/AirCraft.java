package ua.com.globallogic.airline.domain;

public class AirCraft {

    private Long id;
    private double capacity;
    private double carryingCapacity;
    private double flightRange;
    private double fuelConsumption;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public double getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(double carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    public double getFlightRange() {
        return flightRange;
    }

    public void setFlightRange(double flightRange) {
        this.flightRange = flightRange;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

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
