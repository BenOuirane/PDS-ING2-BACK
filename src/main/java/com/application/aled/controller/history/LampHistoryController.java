package com.application.aled.controller.history;

import com.application.aled.entity.Rooms;
import com.application.aled.entity.history.AlarmClockHistory;
import com.application.aled.entity.history.LampHistory;
import com.application.aled.entity.history.ObjectsHistory;
import com.application.aled.service.history.LampHistoryServiceImpl;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.application.aled.messages.history.ObjectHistoryVerification;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class LampHistoryController {

    @Autowired
    LampHistoryServiceImpl lampHistoryService;

    @PutMapping("/history/lamp")
    public List<LampHistory> getHistoryLamps(@RequestBody long id){
        List<LampHistory> lamps =  lampHistoryService.getLampHistoryByObjectsId(id);

        return lamps;

    }


    @PutMapping("/hours/lamp")
    public ArrayList<Map<String[], Integer>> getLampUsingHours(@RequestBody ObjectNode jsonData){
        java.sql.Timestamp startTime = java.sql.Timestamp.valueOf(jsonData.get("start").asText());
        java.sql.Timestamp endTime = java.sql.Timestamp.valueOf(jsonData.get("end").asText());

        List<LampHistory> lampsHistories =  lampHistoryService.getLampHistoryByObjectsIdAndColumnDataAndDateBetween(new Long(jsonData.get("id").asText()), "power", startTime, endTime);
        List<ObjectsHistory> objectsHistories = new ArrayList<ObjectsHistory>();

        for (LampHistory lampsHistory : lampsHistories) {
            objectsHistories.add((ObjectsHistory) lampsHistory);
        }

        ObjectHistoryVerification objectVerification = new ObjectHistoryVerification();
        ArrayList<Map<String[], Integer>> usingHoursArray = objectVerification.usingHours(objectsHistories, 2);
        for (Map<String[], Integer> toto:
                usingHoursArray ) {
            System.out.println(toto.values());

        }


        return usingHoursArray;
    }

}
