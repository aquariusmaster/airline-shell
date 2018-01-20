package ua.com.globallogic.airline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.globallogic.airline.dao.AirCraftRepository;
import ua.com.globallogic.airline.domain.AirCraft;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<AirCraft> findAll() {
        return airCraftRepository.findAll();
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
        return findAll().stream().mapToDouble(AirCraft::getCapacity).sum();
    }

    @Override
    public double totalCarryingCapacity() {
        return findAll().stream().mapToDouble(AirCraft::getCarryingCapacity).sum();
    }

    @Override
    public List<AirCraft> findAllByConsumptionBetween(double start, double end) {
        return findAll().stream()
                .filter((airCraft -> airCraft.getFuelConsumption() >= start && airCraft.getFuelConsumption() <= end))
                .collect(Collectors.toList());
    }


}
