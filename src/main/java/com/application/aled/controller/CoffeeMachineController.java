package com.application.aled.controller;

import com.application.aled.entity.CoffeeMachine;
import com.application.aled.entity.Objects;
import com.application.aled.service.CoffeeMachineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CoffeeMachineController {

    @Autowired
    CoffeeMachineServiceImpl coffeeMachineService;

    @PutMapping("/coffeeMachine/list")
    public List<CoffeeMachine> getCoffeeMachine(@RequestBody Objects objects){
        List<CoffeeMachine> coffeeMachines =  coffeeMachineService.getCoffeeMachine(objects);
        System.out.println("Call getCoffeeMachine" + coffeeMachines);
        return coffeeMachines;

    }
}
