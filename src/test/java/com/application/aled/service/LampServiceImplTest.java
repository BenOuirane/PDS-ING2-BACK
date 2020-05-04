package com.application.aled.service;

import com.application.aled.entity.Lamp;
import com.application.aled.entity.Objects;
import com.application.aled.repository.LampRepository;
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
public class LampServiceImplTest {

    @Mock
    LampRepository repository;

    @Mock
    Objects object;

    @InjectMocks
    LampServiceImpl lampService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void getLampShouldReturnAllUsers() {
        //
        // GIVEN
        //
        List<Lamp> lamps = new ArrayList<>();
        repository.findAll().forEach(lamps::add);

        //
        // WHEN
        //
        List<Lamp> lampListTest = lampService.getLamp(object);

        //
        // THEN
        //
        Assert.assertEquals(lampListTest, lamps);
    }

}
