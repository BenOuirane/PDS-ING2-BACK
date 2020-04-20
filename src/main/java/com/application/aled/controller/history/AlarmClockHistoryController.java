package com.application.aled.controller.history;

import com.application.aled.entity.history.AlarmClockHistory;
import com.application.aled.entity.history.ObjectsHistory;
import com.application.aled.service.history.AlarmClockHistoryServiceImpl;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.application.aled.messages.history.ObjectHistoryVerification;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class AlarmClockHistoryController {

    Logger logger = Logger.getLogger("com.application.aled.controller.AlarmClockHistoryController");
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");

    @Autowired
    AlarmClockHistoryServiceImpl alarmClocksHistoryService;

    @PutMapping("/history/alarmClock")
    public List<AlarmClockHistory> getHistoryAlarmClocks(@RequestBody long id){
        List<AlarmClockHistory> alarmClocks =  alarmClocksHistoryService.getAlarmClockHistoryByObjectsId(id);

        return alarmClocks;
    }

    @PutMapping("/alarm/alarmClock")
    public List<AlarmClockHistory> getAlarmsHistory(@RequestBody ObjectNode jsonData){
        java.sql.Timestamp startTime = java.sql.Timestamp.valueOf(jsonData.get("start").asText());
        java.sql.Timestamp endTime = java.sql.Timestamp.valueOf(jsonData.get("end").asText());

        List<AlarmClockHistory> alarmClocks =  alarmClocksHistoryService.getAlarmClockHistoryByObjectsIdAndColumnDataAndDateBetween(new Long(jsonData.get("id").asText()), "alarm", startTime, endTime);
        return alarmClocks;
    }

    @PutMapping("/favorite/alarmClock")
    public String getFavoriteRadio(@RequestBody ObjectNode jsonData){
        java.sql.Timestamp startTime = java.sql.Timestamp.valueOf(jsonData.get("start").asText());
        java.sql.Timestamp endTime = java.sql.Timestamp.valueOf(jsonData.get("end").asText());

        List<AlarmClockHistory> alarmClocks =  alarmClocksHistoryService.getAlarmClockHistoryByObjectsIdAndColumnDataAndDateBetween(new Long(jsonData.get("id").asText()), jsonData.get("parameter").asText(), startTime, endTime);
        List<ObjectsHistory> objectsHistories = new ArrayList<ObjectsHistory>();

        for (AlarmClockHistory alarmClockHistory : alarmClocks) {
            objectsHistories.add((ObjectsHistory) alarmClockHistory);
        }

        ObjectHistoryVerification objectVerification = new ObjectHistoryVerification();
        String favoriteParameter = objectVerification.favoriteParameter(objectsHistories);

        return favoriteParameter;
    }

}
