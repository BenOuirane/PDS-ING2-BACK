package com.application.aled.controller;

import com.application.aled.entity.AlarmClock;
import com.application.aled.entity.Objects;
import com.application.aled.service.AlarmClockServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class AlarmClockController {

    @Autowired
    AlarmClockServiceImpl alarmClockService;

    @PutMapping("/alarmClock/list")
    public List<AlarmClock> getAlarmClocks(@RequestBody Objects objects){
        List<AlarmClock> alarmClocks =  alarmClockService.getAlarmClock(objects);
        System.out.println("Call getAlarmClocks" + alarmClocks);
        return alarmClocks;

    }
}
