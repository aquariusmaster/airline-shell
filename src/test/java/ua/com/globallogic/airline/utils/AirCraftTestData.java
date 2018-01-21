package ua.com.globallogic.airline.utils;

import ua.com.globallogic.airline.domain.AirCraft;

public class AirCraftTestData {

    public static double CAPACITY = 1000;
    public static double CARRYING_CAPACITY = 500;
    public static double FLIGHT_RANGE = 10500;
    public static double FUEL_CONSUMPTION = 50.5;


    public static AirCraft prepareNewAirCraft() {
        AirCraft airCraft = new AirCraft();
        airCraft.setCapacity(CAPACITY);
        airCraft.setCarryingCapacity(CARRYING_CAPACITY);
        airCraft.setFlightRange(FLIGHT_RANGE);
        airCraft.setFuelConsumption(FUEL_CONSUMPTION);

        return airCraft;
    }

    public static AirCraft prepareExistedAirCraft() {
        AirCraft airCraft = new AirCraft();
        airCraft.setId(1L);
        airCraft.setCapacity(CAPACITY);
        airCraft.setCarryingCapacity(CARRYING_CAPACITY);
        airCraft.setFlightRange(FLIGHT_RANGE);
        airCraft.setFuelConsumption(FUEL_CONSUMPTION);

        return airCraft;
    }
}
