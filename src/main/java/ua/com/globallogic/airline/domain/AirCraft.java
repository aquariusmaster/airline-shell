package ua.com.globallogic.airline.domain;

public class AirCraft {

    private Long id;
    private float capacity;
    private float carryingCapacity;
    private float flightRange;
    private float fuelConsumption;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getCapacity() {
        return capacity;
    }

    public void setCapacity(float capacity) {
        this.capacity = capacity;
    }

    public float getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(float carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    public float getFlightRange() {
        return flightRange;
    }

    public void setFlightRange(float flightRange) {
        this.flightRange = flightRange;
    }

    public float getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(float fuelConsumption) {
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
