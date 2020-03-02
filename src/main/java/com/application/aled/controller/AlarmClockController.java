package com.application.aled.controller;

import com.application.aled.entity.AlarmClock;
import com.application.aled.entity.Objects;
import com.application.aled.service.AlarmClockServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class AlarmClockController {

    @Autowired
    AlarmClockServiceImpl alarmClockService;

    Logger logger = Logger.getLogger("com.application.aled.controller.AlarmClockController");

    @PutMapping("/alarmClock/list")
    public List<AlarmClock> getAlarmClocks(@RequestBody Objects objects){
        List<AlarmClock> alarmClocks =  alarmClockService.getAlarmClock(objects);
        logger.info("Call getAlarmClocks : " + alarmClocks);
        return alarmClocks;

    }
}
