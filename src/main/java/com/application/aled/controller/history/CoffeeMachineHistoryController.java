package com.application.aled.controller.history;

import com.application.aled.entity.history.CoffeeMachineHistory;
import com.application.aled.entity.history.LampHistory;
import com.application.aled.entity.history.ObjectsHistory;
import com.application.aled.messages.history.ObjectHistoryVerification;
import com.application.aled.service.history.CoffeeMachineHistoryServiceImpl;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CoffeeMachineHistoryController {

    @Autowired
    CoffeeMachineHistoryServiceImpl coffeeMachinesHistoryService;

    @PutMapping("/history/coffeeMachine")
    public List<CoffeeMachineHistory> getHistoryCoffeeMachines(@RequestBody long id){
        List<CoffeeMachineHistory> coffeeMachines =  coffeeMachinesHistoryService.getCoffeeMachineHistoryByObjectsId(id);

        return coffeeMachines;
    }

    @PutMapping("/capsules/coffeeMachine")
    public int getCapsulesBrought(@RequestBody ObjectNode jsonData){
        java.sql.Timestamp startTime = java.sql.Timestamp.valueOf(jsonData.get("start").asText());
        java.sql.Timestamp endTime = java.sql.Timestamp.valueOf(jsonData.get("end").asText());

        List<CoffeeMachineHistory> coffeeMachineHistories =  coffeeMachinesHistoryService.getCoffeeMachineHistoryByObjectsIdAndColumnDataAndDateBetween(new Long(jsonData.get("id").asText()), "capsules", startTime, endTime);

        ObjectHistoryVerification objectVerification = new ObjectHistoryVerification();
        int numberOfCapsules = objectVerification.capsulesBought(coffeeMachineHistories);

        return numberOfCapsules;
    };

}
