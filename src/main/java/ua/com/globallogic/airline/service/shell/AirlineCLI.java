package ua.com.globallogic.airline.service.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ua.com.globallogic.airline.domain.AirCraft;
import ua.com.globallogic.airline.service.AirCraftService;

import java.util.Comparator;
import java.util.stream.Collectors;

@ShellComponent
public class AirlineCLI {

    private final AirCraftService airCraftService;

    @Autowired
    public AirlineCLI(AirCraftService airCraftService) {
        this.airCraftService = airCraftService;
    }

    @ShellMethod(value = "Show all aircrafts (optional sorted by flight range)", prefix = "-")
    public String all(@ShellOption boolean sorted){

        if (sorted) {
            return airCraftService.findAll().stream()
                    .sorted(new AirCraftFuelRangeComparator().reversed())
                    .map(Object::toString)
                    .collect(Collectors.joining("\n"));
        } else {
            return airCraftService.findAll().stream()
                    .map(Object::toString)
                    .collect(Collectors.joining("\n"));
        }
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
    public String total(@ShellOption boolean capacity, @ShellOption boolean carrying){

        double capacityValue = airCraftService.totalCapacity();
        double carryingValue = airCraftService.totalCarryingCapacity();
        if ((!capacity && !carrying) || (capacity && carrying)) {
            return "Total: \n\tcapacity: " + capacityValue + "\n\tcarrying capacity: " + carryingValue;
        } else if (capacity) {
            return "Total capacity: " + capacityValue;
        } else {
            return "Total carrying capacity: " + carryingValue;
        }
    }

    @ShellMethod(value = "Find aircraft corresponding to the specified range of fuel consumption parameters " +
            "(liters per hour", prefix = "-")
    public String find(@ShellOption(arity = 2) double[] range){
        return airCraftService.findAllByConsumptionBetween(range[0], range[1]).stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n"));

    }

    class AirCraftFuelRangeComparator implements Comparator<AirCraft> {

        @Override
        public int compare(AirCraft o1, AirCraft o2) {
            return Double.compare(o1.getFlightRange(), o2.getFlightRange());
        }

    }

}
