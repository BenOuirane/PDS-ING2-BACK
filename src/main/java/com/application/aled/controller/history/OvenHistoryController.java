package com.application.aled.controller.history;

import com.application.aled.entity.history.OvenHistory;
import com.application.aled.service.history.OvenHistoryServiceImpl;
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

}
