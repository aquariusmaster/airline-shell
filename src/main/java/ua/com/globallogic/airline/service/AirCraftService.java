package ua.com.globallogic.airline.service;

import ua.com.globallogic.airline.domain.AirCraft;

import java.util.List;

/**
 * AirCraftService interface
 */
public interface AirCraftService {
    AirCraft findOne(Long airCraftId);
    List<AirCraft> findAll(boolean sorted);
    AirCraft saveOrUpdate(AirCraft airCraft);
    void delete(Long airCraftId);
    double totalCapacity();
    double totalCarryingCapacity();
    List<AirCraft> findAllByConsumptionBetween(double start, double end);
}
