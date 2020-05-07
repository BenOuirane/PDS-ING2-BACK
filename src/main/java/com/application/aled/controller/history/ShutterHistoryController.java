package com.application.aled.controller.history;

import com.application.aled.entity.history.AlarmClockHistory;
import com.application.aled.entity.history.ShutterHistory;
import com.application.aled.messages.history.ObjectHistoryVerification;
import com.application.aled.service.history.ShutterHistoryServiceImpl;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ShutterHistoryController {

    @Autowired
    ShutterHistoryServiceImpl shuttersHistoryService;

    @PutMapping("/history/shutter")
    public List<ShutterHistory> getHistoryShutters(@RequestBody long id){
        List<ShutterHistory> shutters =  shuttersHistoryService.getShutterHistoryByObjectsId(id);

        return shutters;
    }

    @PutMapping("/wronglyOpened/shutter")
    public Map<List<String>, Integer> getWronglyOpenedHistory(@RequestBody ObjectNode jsonData){
        java.sql.Timestamp startTime = java.sql.Timestamp.valueOf(jsonData.get("start").asText());
        java.sql.Timestamp endTime = java.sql.Timestamp.valueOf(jsonData.get("end").asText());

        List<ShutterHistory> shutterHistories =  shuttersHistoryService.getShutterHistoryByObjectsIdAndColumnDataAndDateBetween(new Long(jsonData.get("id").asText()), "action", startTime, endTime);
        
        ObjectHistoryVerification objectVerification = new ObjectHistoryVerification();
        Map<List<String>, Integer> wronglyOpened = objectVerification.wronglyOpenedShutter(shutterHistories);

        return wronglyOpened;
    }

}
