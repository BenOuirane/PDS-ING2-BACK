package com.application.aled.controller.history;

import com.application.aled.entity.Rooms;
import com.application.aled.entity.history.LampHistory;
import com.application.aled.service.history.LampHistoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

}
