package com.application.aled.controller.history;

import com.application.aled.entity.history.CoffeeMachineHistory;
import com.application.aled.service.history.CoffeeMachineHistoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

}
