package com.application.aled.controller.history;

import com.application.aled.entity.history.CoffeeMachineHistory;
import com.application.aled.entity.history.OvenHistory;
import com.application.aled.messages.history.ObjectHistoryVerification;
import com.application.aled.service.history.OvenHistoryServiceImpl;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class OvenHistoryController {

    @Autowired
    OvenHistoryServiceImpl ovenHistoryService;

    @PutMapping("/history/oven")
    public List<OvenHistory> getHistoryOvens(@RequestBody long id){
        List<OvenHistory> ovens =  ovenHistoryService.getOvenHistoryByObjectsId(id);

        return ovens;
    }

    @PutMapping("/temperatureMax/oven")
    public List<OvenHistory> getTempOvens(@RequestBody ObjectNode jsonData){
        java.sql.Timestamp startTime = java.sql.Timestamp.valueOf(jsonData.get("start").asText());
        java.sql.Timestamp endTime = java.sql.Timestamp.valueOf(jsonData.get("end").asText());

        List<OvenHistory> ovenHistories =  ovenHistoryService.getOvenHistoryByObjectsIdAndColumnDataAndDateBetween(new Long(jsonData.get("id").asText()), "temp", startTime, endTime);

        ObjectHistoryVerification objectVerification = new ObjectHistoryVerification();
        List<OvenHistory> ovenHistoriesTooHigh = objectVerification.tooHigh(ovenHistories, jsonData.get("temperature").asInt());

        return ovenHistoriesTooHigh;
    }

}
