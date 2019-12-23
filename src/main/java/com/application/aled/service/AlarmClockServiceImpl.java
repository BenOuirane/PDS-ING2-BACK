package com.application.aled.service;

import com.application.aled.entity.AlarmClock;
import com.application.aled.entity.Lamp;
import com.application.aled.entity.Objects;
import com.application.aled.repository.AlarmClockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlarmClockServiceImpl {

    @Autowired
    AlarmClockRepository alarmClockRepository;

    public List<AlarmClock> getAlarmClock(Objects objects){
        System.out.println("Getting alarmClocks for object : " + objects);
        List<AlarmClock> alarmClocks = new ArrayList<>();
        alarmClockRepository.findAllByObjects(objects).forEach(alarmClocks::add);
        return alarmClocks;
    }
}
