package ua.com.globallogic.airline.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.shell.Shell;
import org.springframework.test.context.junit4.SpringRunner;
import ua.com.globallogic.airline.TestApplicationRunner;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.shell.Shell;
import org.springframework.test.context.junit4.SpringRunner;
import ua.com.globallogic.airline.dao.AirCraftRepository;
import ua.com.globallogic.airline.domain.AirCraft;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static ua.com.globallogic.airline.utils.AirCraftTestData.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(TestApplicationRunner.class)
public class AirCraftServiceTests {

    @Autowired
    private AirCraftService airCraftService;

    @Mock
    private AirCraftRepository airCraftRepository;

    @Test
    public void whenSaveNewAirCraft_ReturnSavedAirCraft() {
        AirCraft newAirCraft = prepareNewAirCraft();
        AirCraft savedAirCraft = prepareExistedAirCraft();

        when(airCraftRepository.saveOrUpdate(newAirCraft)).thenReturn(savedAirCraft);

        airCraftService.saveOrUpdate(newAirCraft);

        verify(airCraftRepository, times(1)).saveOrUpdate(newAirCraft);
    }


}