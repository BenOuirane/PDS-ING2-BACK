package com.application.aled.controller.history;

import com.application.aled.entity.history.AlarmClockHistory;
import com.application.aled.service.history.AlarmClockHistoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class AlarmClockHistoryController {

    @Autowired
    AlarmClockHistoryServiceImpl alarmClocksHistoryService;

    @PutMapping("/history/alarmClock")
    public List<AlarmClockHistory> getHistoryAlarmClocks(@RequestBody long id){
        List<AlarmClockHistory> alarmClocks =  alarmClocksHistoryService.getAlarmClockHistoryByObjectsId(id);

        return alarmClocks;

    }

}
