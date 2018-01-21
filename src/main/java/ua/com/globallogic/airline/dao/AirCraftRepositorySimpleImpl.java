package ua.com.globallogic.airline.dao;

import org.springframework.stereotype.Repository;
import ua.com.globallogic.airline.domain.AirCraft;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class AirCraftRepositorySimpleImpl implements AirCraftRepository {

    private Set<AirCraft> airCrafts = new HashSet<>();

    @Override
    public AirCraft saveOrUpdate(AirCraft airCraft) {

        if (airCraft.getId() == null) {
            airCraft.setId((long) (airCrafts.size() + 1));
            airCrafts.add(airCraft);
            return airCraft;
        } else {
            if (airCrafts.remove(airCraft)) {
                airCrafts.add(airCraft);
                return airCraft;
            } else {
                throw new NoSuchElementException();
            }
        }
    }

    @Override
    public AirCraft findOne(Long airCraftId) {
        return airCrafts.stream().filter(airCraft -> airCraftId.equals(airCraft.getId())).findFirst().orElse(null);
    }

    @Override
    public List<AirCraft> findAll() {
        return new ArrayList<>(airCrafts);
    }

    @Override
    public void delete(Long airCraftId) {
        AirCraft airCraft = findOne(airCraftId);
        airCrafts.remove(airCraft);
    }

    @Override
    public List<AirCraft> findAllByConsumptionBetween(double start, double end) {
        return  airCrafts.stream()
                .filter((airCraft -> airCraft.getFuelConsumption() >= start && airCraft.getFuelConsumption() <= end))
                .collect(Collectors.toList());
    }

    @Override
    public double totalCapacity() {
        return airCrafts.stream().mapToDouble(AirCraft::getCapacity).sum();
    }

    @Override
    public double totalCarryingCapacity() {
        return airCrafts.stream().mapToDouble(AirCraft::getCarryingCapacity).sum();
    }
}
