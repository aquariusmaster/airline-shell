package ua.com.globallogic.airline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.globallogic.airline.dao.AirCraftRepository;
import ua.com.globallogic.airline.domain.AirCraft;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * AirCraftService implementation
 */
@Service
public class AirCraftServiceImpl implements AirCraftService{

    private final AirCraftRepository airCraftRepository;

    @Autowired
    public AirCraftServiceImpl(AirCraftRepository airCraftRepository) {
        this.airCraftRepository = airCraftRepository;
    }

    @Override
    public AirCraft findOne(Long airCraftId) {
        return airCraftRepository.findOne(airCraftId);
    }

    @Override
    public List<AirCraft> findAll(boolean sorted) {
        if (sorted) {
            return airCraftRepository.findAll().stream()
                    .sorted(new AirCraftFuelRangeComparator().reversed())
                    .collect(Collectors.toList());
        } else {
            return airCraftRepository.findAll();
        }
    }

    @Override
    public AirCraft saveOrUpdate(AirCraft airCraft) {
        return airCraftRepository.saveOrUpdate(airCraft);
    }

    @Override
    public void delete(Long airCraftId) {
        airCraftRepository.delete(airCraftId);
    }

    @Override
    public double totalCapacity() {
        return airCraftRepository.totalCapacity();
    }

    @Override
    public double totalCarryingCapacity() {
        return airCraftRepository.totalCarryingCapacity();
    }

    @Override
    public List<AirCraft> findAllByConsumptionBetween(double start, double end) {
        return airCraftRepository.findAllByConsumptionBetween(start, end);
    }

    class AirCraftFuelRangeComparator implements Comparator<AirCraft> {

        @Override
        public int compare(AirCraft o1, AirCraft o2) {
            return Double.compare(o1.getFlightRange(), o2.getFlightRange());
        }

    }


}
