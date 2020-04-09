package com.application.aled.controller;

import com.application.aled.entity.CoffeeMachine;
import com.application.aled.entity.Objects;
import com.application.aled.entity.Shutter;
import com.application.aled.service.CoffeeMachineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CoffeeMachineController {

    @Autowired
    CoffeeMachineServiceImpl coffeeMachineService;

    Logger logger = Logger.getLogger("com.application.aled.controller.CoffeeMachineController");

    @PutMapping("/coffeeMachine/list")
    public List<CoffeeMachine> getCoffeeMachine(@RequestBody Objects objects){
        List<CoffeeMachine> coffeeMachines =  coffeeMachineService.getCoffeeMachine(objects);
        logger.info("Call getCoffeeMachine" + coffeeMachines);
        return coffeeMachines;
    }

    @PutMapping("/coffeeMachine/updateParam")
    public boolean updateCoffeeMachine(@RequestBody CoffeeMachine coffeeMachine){
        logger.info("Call updateCoffeeMachine :" + coffeeMachine.toString());
        return coffeeMachineService.updateCoffeeMachine(coffeeMachine);
    }

    @PutMapping("/coffeeMachine/makeCoffee")
    public boolean makeCoffee(@RequestBody CoffeeMachine coffeeMachine){
        logger.info("Call makeCoffee :" + coffeeMachine.toString());
        return coffeeMachineService.makeCoffee(coffeeMachine);
    }

}
