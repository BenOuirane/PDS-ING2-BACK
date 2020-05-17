package com.application.aled.service;

import com.application.aled.entity.AlarmClock;
import com.application.aled.entity.Objects;
import com.application.aled.repository.AlarmClockRepository;
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
public class AlarmClockServiceImplTest {

    @Mock
    AlarmClockRepository repository;

    @Mock
    Objects object;

    @InjectMocks
    AlarmClockServiceImpl alarmClockService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void getAlarmClockShouldReturnAllUsers() {
        //
        // GIVEN
        //
        List<AlarmClock> alarmClocks = new ArrayList<>();
        repository.findAll().forEach(alarmClocks::add);

        //
        // WHEN
        //
        List<AlarmClock> alarmClockListTest = alarmClockService.getAlarmClock(object);

        //
        // THEN
        //
        Assert.assertEquals(alarmClockListTest, alarmClocks);
    }
}
