package com.application.aled.controller.history;

import com.application.aled.entity.history.ShutterHistory;
import com.application.aled.service.history.ShutterHistoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

}
