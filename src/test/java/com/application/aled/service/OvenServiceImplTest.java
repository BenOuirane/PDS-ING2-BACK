package com.application.aled.service;

import com.application.aled.entity.Objects;
import com.application.aled.entity.Oven;
import com.application.aled.repository.OvenRepository;
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
public class OvenServiceImplTest {

    @Mock
    OvenRepository repository;

    @Mock
    Objects object;

    @InjectMocks
    OvenServiceImpl ovenService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void getOvenShouldReturnAllUsers() {
        //
        // GIVEN
        //
        List<Oven> ovens = new ArrayList<>();
        repository.findAll().forEach(ovens::add);

        //
        // WHEN
        //
        List<Oven> ovenListTest = ovenService.getOven(object);

        //
        // THEN
        //
        Assert.assertEquals(ovenListTest, ovens);
    }
}
