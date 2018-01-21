package ua.com.globallogic.airline.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import ua.com.globallogic.airline.TestApplicationRunner;

import static org.assertj.core.api.Assertions.assertThat;

import ua.com.globallogic.airline.dao.AirCraftRepository;
import ua.com.globallogic.airline.domain.AirCraft;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static ua.com.globallogic.airline.utils.AirCraftTestData.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(TestApplicationRunner.class)
public class AirCraftServiceTests {

    @InjectMocks
    private AirCraftServiceImpl airCraftService;

    @Mock
    private AirCraftRepository airCraftRepository;

    @Test
    public void whenFindAllSortedAirCrafts_ReturnValidSortedList() {
        AirCraft airCraft1 = prepareExistedAirCraft();
        airCraft1.setFlightRange(2000);
        AirCraft airCraft2 = prepareExistedAirCraft();
        airCraft2.setId(2L);
        airCraft2.setFlightRange(1000);
        AirCraft airCraft3 = prepareExistedAirCraft();
        airCraft3.setId(3L);
        airCraft3.setFlightRange(4500);

        when(airCraftRepository.findAll()).thenReturn(Arrays.asList(airCraft1, airCraft2, airCraft3));

        boolean sortedByFlightRangeDecreased = true;
        List<AirCraft> sortedAirCrafts = airCraftService.findAll(sortedByFlightRangeDecreased);

        verify(airCraftRepository).findAll();
        assertThat(sortedAirCrafts).hasSize(3);
        assertThat(sortedAirCrafts.get(0)).isEqualTo(airCraft3);
        assertThat(sortedAirCrafts.get(1)).isEqualTo(airCraft1);
        assertThat(sortedAirCrafts.get(2)).isEqualTo(airCraft2);
    }
}