package ua.com.globallogic.airline.dao;

import ua.com.globallogic.airline.domain.AirCraft;

import java.util.List;

public interface AirCraftRepository {
    AirCraft saveOrUpdate(AirCraft airCraft);
    AirCraft findOne(Long airCraftId);
    List<AirCraft> findAll();
    void delete(Long airCraftId);
    List<AirCraft> findAllByConsumptionBetween(double start, double end);
    double totalCapacity();
    double totalCarryingCapacity();
}
