package com.application.aled.controller.history;

import com.application.aled.entity.history.AlarmClockHistory;
import com.application.aled.entity.history.LampHistory;
import com.application.aled.entity.history.ObjectsHistory;
import com.application.aled.messages.history.ObjectHistoryVerification;
import com.application.aled.service.history.AlarmClockHistoryServiceImpl;
import com.application.aled.service.history.LampHistoryServiceImpl;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ObjectsHistoryController {

    @Autowired
    AlarmClockHistoryServiceImpl alarmClocksHistoryService;

    @Autowired
    LampHistoryServiceImpl lampHistoryService;

    @PutMapping("/hours/{objectType}")
    public ArrayList<Map<List<String>, Integer>> getlUsingHours(@PathVariable(value="objectType") String objectType, @RequestBody ObjectNode jsonData){
        java.sql.Timestamp startTime = java.sql.Timestamp.valueOf(jsonData.get("start").asText());
        java.sql.Timestamp endTime = java.sql.Timestamp.valueOf(jsonData.get("end").asText());

        List<ObjectsHistory> objectsHistories = new ArrayList<ObjectsHistory>();

        switch(objectType){
            case "lamp" :
                List<LampHistory> lampsHistories =  lampHistoryService.getLampHistoryByObjectsIdAndColumnDataAndDateBetween(new Long(jsonData.get("id").asText()), "power", startTime, endTime);
                for (LampHistory lampsHistory : lampsHistories) {
                    objectsHistories.add((ObjectsHistory) lampsHistory);
                }
                break;
            default:
        }


        ObjectHistoryVerification objectVerification = new ObjectHistoryVerification();
        ArrayList<Map<List<String>, Integer>> usingHoursArray = objectVerification.usingHours(objectsHistories, 2);
        return usingHoursArray;
    }

    @PutMapping("/favorite/{objectType}")
    public Set<String> getFavorite(@PathVariable(value="objectType") String objectType, @RequestBody ObjectNode jsonData){
        java.sql.Timestamp startTime = java.sql.Timestamp.valueOf(jsonData.get("start").asText());
        java.sql.Timestamp endTime = java.sql.Timestamp.valueOf(jsonData.get("end").asText());

        List<ObjectsHistory> objectsHistories = new ArrayList<ObjectsHistory>();

        switch(objectType){
            case "lamp" :
                List<LampHistory> lampsHistories =  lampHistoryService.getLampHistoryByObjectsIdAndColumnDataAndDateBetween(new Long(jsonData.get("id").asText()), jsonData.get("parameter").asText(), startTime, endTime);
                for (LampHistory lampsHistory : lampsHistories) {
                    objectsHistories.add((ObjectsHistory) lampsHistory);
                }
                break;
            case "alarmClock" :
                List<AlarmClockHistory> alarmClocksHistories =  alarmClocksHistoryService.getAlarmClockHistoryByObjectsIdAndColumnDataAndDateBetween(new Long(jsonData.get("id").asText()), jsonData.get("parameter").asText(), startTime, endTime);
                for (AlarmClockHistory alarmClockHistory : alarmClocksHistories) {
                    objectsHistories.add((ObjectsHistory) alarmClockHistory);
                }
                break;
            default:
                break;
        }

        ObjectHistoryVerification objectVerification = new ObjectHistoryVerification();
        String favoriteParameter = objectVerification.favoriteParameter(objectsHistories);

        return Collections.singleton(favoriteParameter);
    }
}
