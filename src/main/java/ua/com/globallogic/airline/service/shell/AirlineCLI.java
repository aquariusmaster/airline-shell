package ua.com.globallogic.airline.service.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ua.com.globallogic.airline.domain.AirCraft;
import ua.com.globallogic.airline.service.AirCraftService;

import java.util.stream.Collectors;

/**
 * A class for various shell interactions.
 */
@ShellComponent
public class AirlineCLI {

    private final AirCraftService airCraftService;

    @Autowired
    public AirlineCLI(AirCraftService airCraftService) {
        this.airCraftService = airCraftService;
    }

    @ShellMethod(value = "Show all aircrafts (optional sorted by flight range)", prefix = "-")
    public String all(@ShellOption(help = "sorted by flight range") boolean sorted){

        return airCraftService.findAll(sorted).stream().map(Object::toString)
                    .collect(Collectors.joining("\n"));
    }

    @ShellMethod("Add new aircraft")
    public String add(float capacity,
                      float carryingCapacity,
                      float flightRange,
                      float fuelConsumption){

        AirCraft airCraft = new AirCraft();
        airCraft.setCapacity(capacity);
        airCraft.setCarryingCapacity(carryingCapacity);
        airCraft.setFlightRange(flightRange);
        airCraft.setFuelConsumption(fuelConsumption);

        return "New aircraft was added: " + airCraftService.saveOrUpdate(airCraft);
    }

    @ShellMethod("Get aircraft by id")
    public String get(Long id){

        AirCraft airCraft = airCraftService.findOne(id);
        if (airCraft != null){
            return airCraft.toString();
        } else {
            return "Not found";
        }
    }

    @ShellMethod(value = "Calculate total capacity and carrying capacity of all the aircraft in the airline",
            prefix = "-")
    public String total(@ShellOption(help = "output total capacity") boolean capacity,
                        @ShellOption(help = "output total carrying capacity") boolean carrying){

        if ((!capacity && !carrying) || (capacity && carrying)) {
            double capacityValue = airCraftService.totalCapacity();
            double carryingValue = airCraftService.totalCarryingCapacity();
            return "Total: \n\tcapacity: " + capacityValue + "\n\tcarrying capacity: " + carryingValue;
        } else if (capacity) {
            double capacityValue = airCraftService.totalCapacity();
            return "Total capacity: " + capacityValue;
        } else {
            double carryingValue = airCraftService.totalCarryingCapacity();
            return "Total carrying capacity: " + carryingValue;
        }
    }

    @ShellMethod(value = "Find aircraft corresponding to the specified range of fuel consumption parameters " +
            "(liters per hour)", prefix = "-")
    public String find(@ShellOption(arity = 2, help = "range of fuel consumption") double[] range){
        return airCraftService.findAllByConsumptionBetween(range[0], range[1]).stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n"));
    }
}
