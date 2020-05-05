package com.application.aled.service;

import com.application.aled.entity.CoffeeMachine;
import com.application.aled.entity.Objects;
import com.application.aled.repository.CoffeeMachineRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CoffeeMachineImplTest {

    @Mock
    CoffeeMachineRepository repository;

    @Mock
    Objects object;

    @InjectMocks
    CoffeeMachineServiceImpl coffeeMachineService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void getCoffeeMachineShouldReturnAllUsers() {
        //
        // GIVEN
        //
        List<CoffeeMachine> coffeeMachines = new ArrayList<>();
        repository.findAll().forEach(coffeeMachines::add);

        //
        // WHEN
        //
        List<CoffeeMachine> coffeeMachinesListTest = coffeeMachineService.getCoffeeMachine(object);

        //
        // THEN
        //
        Assert.assertEquals(coffeeMachinesListTest, coffeeMachines);
    }
}
