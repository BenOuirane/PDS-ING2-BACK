package com.application.aled.service;

import com.application.aled.entity.Objects;
import com.application.aled.entity.Shutter;
import com.application.aled.repository.ShutterRepository;
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
public class ShutterServiceImplTest {

    @Mock
    ShutterRepository repository;

    @Mock
    Objects object;

    @InjectMocks
    ShutterServiceImpl shutterService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void getShutterShouldReturnAllUsers() {
        //
        // GIVEN
        //
        List<Shutter> shutters = new ArrayList<>();
        repository.findAll().forEach(shutters::add);

        //
        // WHEN
        //
        List<Shutter> shutterListTest = shutterService.getShutter(object);

        //
        // THEN
        //
        Assert.assertEquals(shutterListTest, shutters);
    }
}
