package ua.com.globallogic.airline.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import ua.com.globallogic.airline.TestApplicationRunner;
import ua.com.globallogic.airline.domain.AirCraft;
import static ua.com.globallogic.airline.utils.AirCraftTestData.FUEL_CONSUMPTION;
import static ua.com.globallogic.airline.utils.AirCraftTestData.prepareExistedAirCraft;
import static ua.com.globallogic.airline.utils.AirCraftTestData.prepareNewAirCraft;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(TestApplicationRunner.class)
public class AirCraftSimpleRepositoryTests {

    @Autowired
    private AirCraftRepository airCraftRepository;

    @Test
    public void whenSaveNewAirCraft_ReturnSavedAirCraft() {
        AirCraft newAirCraft = prepareNewAirCraft();
        AirCraft savedAirCraft = prepareExistedAirCraft();

        AirCraft airCraft = airCraftRepository.saveOrUpdate(newAirCraft);

        assertThat(airCraft.getId()).isNotNull();
        assertThat(airCraft).isEqualToIgnoringGivenFields(savedAirCraft, "id");

    }

    @Test
    public void whenSaveTwoNewAirCraft_SaveAllTwoAirCrafts() {

        clearRepository();

        AirCraft newAirCraft1 = prepareNewAirCraft();
        AirCraft newAirCraft2 = prepareNewAirCraft();

        airCraftRepository.saveOrUpdate(newAirCraft1);
        airCraftRepository.saveOrUpdate(newAirCraft2);

        assertThat(airCraftRepository.findAll()).hasSize(2);
    }

    @Test
    public void whenGetExistedAirCraft_ReturnAirCraft() {
        AirCraft newAirCraft = prepareNewAirCraft();
        long id = airCraftRepository.saveOrUpdate(newAirCraft).getId();

        assertThat(airCraftRepository.findOne(id)).isNotNull();

    }

    @Test
    public void whenDeleteAirCraft_ForExistedAirCraft_DeleteWithSuccess() {

        AirCraft newAirCraft1 = prepareNewAirCraft();
        int initSize = airCraftRepository.findAll().size();
        AirCraft savedAirCraft = airCraftRepository.saveOrUpdate(newAirCraft1);
        assertThat(airCraftRepository.findAll()).hasSize(initSize + 1);
        airCraftRepository.delete(savedAirCraft.getId());
        assertThat(airCraftRepository.findAll()).hasSize(initSize);
    }

    @Test
    public void whenGetTotalCapacity_WithAirCraft_ReturnValidCapacity() {

        clearRepository();

        AirCraft airCraft1 = prepareNewAirCraft();
        AirCraft airCraft2 = prepareNewAirCraft();

        airCraftRepository.saveOrUpdate(airCraft1);
        airCraftRepository.saveOrUpdate(airCraft2);

        double expectedCapacity = airCraft1.getCapacity() + airCraft2.getCapacity();

        assertThat(airCraftRepository.totalCapacity()).isEqualTo(expectedCapacity);
    }

    @Test
    public void whenGetTotalCarryingCapacity_WithAirCraft_ReturnValidCapacity() {

        clearRepository();

        AirCraft airCraft1 = prepareNewAirCraft();
        AirCraft airCraft2 = prepareNewAirCraft();

        airCraftRepository.saveOrUpdate(airCraft1);
        airCraftRepository.saveOrUpdate(airCraft2);

        double expectedCarryingCapacity = airCraft1.getCarryingCapacity() + airCraft2.getCarryingCapacity();

        assertThat(airCraftRepository.totalCarryingCapacity()).isEqualTo(expectedCarryingCapacity);
    }

    @Test
    public void whenFindAirCraft_ByFuelConsumptionRange_ReturnValidList() {

        clearRepository();

        AirCraft airCraft1 = prepareNewAirCraft();
        AirCraft airCraft2 = prepareNewAirCraft();
        airCraft2.setFuelConsumption(12.5);

        airCraftRepository.saveOrUpdate(airCraft1);
        airCraftRepository.saveOrUpdate(airCraft2);

        assertThat(airCraftRepository.findAllByConsumptionBetween(0, FUEL_CONSUMPTION)).hasSize(2);
        assertThat(airCraftRepository.findAllByConsumptionBetween(15, FUEL_CONSUMPTION)).hasSize(1);
        assertThat(airCraftRepository.findAllByConsumptionBetween(0, 10)).hasSize(0);

    }

    private void clearRepository() {
        airCraftRepository.findAll().forEach(airCraft -> airCraftRepository.delete(airCraft.getId()));
    }

}