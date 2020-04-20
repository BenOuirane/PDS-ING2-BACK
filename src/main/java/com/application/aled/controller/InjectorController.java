package com.application.aled.controller;

import com.application.aled.entity.Failure;
import com.application.aled.entity.Objects;
import com.application.aled.entity.Profil;
import com.application.aled.entity.history.*;
import com.application.aled.service.FailureService;
import com.application.aled.service.ObjectService;
import com.application.aled.service.history.CoffeeMachineHistoryService;
import com.application.aled.service.history.LampHistoryService;
import com.application.aled.service.history.OvenHistoryService;
import com.application.aled.service.history.ShutterHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class InjectorController {
    @Autowired
    ObjectService objectService;
    @Autowired
    FailureService failureService;
    @Autowired
    LampHistoryService lampHistoryService;
    @Autowired
    OvenHistoryService ovenHistoryService;
    @Autowired
    ShutterHistoryService shutterHistoryService;
    @Autowired
    CoffeeMachineHistoryService coffeeMachineHistoryService;


    Logger logger = Logger.getLogger("com.application.aled.controller.InjectorController");

    @GetMapping("/simulation1")
    public List<Failure> getAllFailures(){
        /*
        Get all objects to simulate
         */
        List<Objects> objectsList = objectService.getObjects();
        /**
         create a recent message for each objects and switch error state at true.
         **/
        for(Objects objects: objectsList){

            switch(objects.getObjectType()){
                case "LAMP":
                    LampHistory lampHistory = new LampHistory();
                    lampHistory.setColumnData("connected");
                    lampHistory.setData("true");
                    lampHistory.setMessageTimestamp(new Timestamp(System.currentTimeMillis()));
                    lampHistory.setObject(objects);
                    lampHistoryService.addHistory(lampHistory);

                case "OVEN":
                    OvenHistory ovenHistory = new OvenHistory();
                    ovenHistory.setColumnData("connected");
                    ovenHistory.setData("true");
                    ovenHistory.setMessageTimestamp(new Timestamp(System.currentTimeMillis()));
                    ovenHistory.setObject(objects);
                    ovenHistoryService.addHistory(ovenHistory);

                case "SHUTTER":
                    ShutterHistory shutterHistory = new ShutterHistory();
                    shutterHistory.setColumnData("connected");
                    shutterHistory.setData("true");
                    shutterHistory.setMessageTimestamp(new Timestamp(System.currentTimeMillis()));
                    shutterHistory.setObject(objects);
                    shutterHistoryService.addHistory(shutterHistory);

                case "COFFEEMACHINE":
                    CoffeeMachineHistory coffeeMachineHistory = new CoffeeMachineHistory();
                    coffeeMachineHistory.setColumnData("connected");
                    coffeeMachineHistory.setData("true");
                    coffeeMachineHistory.setMessageTimestamp(new Timestamp(System.currentTimeMillis()));
                    coffeeMachineHistory.setObject(objects);
                    coffeeMachineHistoryService.addHistory(coffeeMachineHistory);



            }
            objects.setState(true);

        }

        List<Failure> failures = failureService.getFailures();
        return failures;
    }
}
