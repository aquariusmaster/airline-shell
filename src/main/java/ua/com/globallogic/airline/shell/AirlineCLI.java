package ua.com.globallogic.airline.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ua.com.globallogic.airline.domain.AirCraft;
import ua.com.globallogic.airline.service.AirCraftService;

import java.util.stream.Collectors;

@ShellComponent
public class AirlineCLI {

    private final AirCraftService airCraftService;

    @Autowired
    public AirlineCLI(AirCraftService airCraftService) {
        this.airCraftService = airCraftService;
    }

    @ShellMethod("Show all aircrafts")
    public String all(){
        return airCraftService.findAll().stream().map(Object::toString).collect(Collectors.joining("\n"));
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
}
