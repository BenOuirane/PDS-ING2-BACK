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
import java.util.logging.Logger;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class LampHistoryController {

    @Autowired
    LampHistoryServiceImpl lampHistoryService;

    Logger logger = Logger.getLogger("com.application.aled.service.ObjectHistoryController");

    @PutMapping("/history/lamp")
    public List<LampHistory> getHistoryLamps(@RequestBody long id){
        List<LampHistory> lamps =  lampHistoryService.getLampHistoryByObjectsId(id);

        return lamps;

    }
}
