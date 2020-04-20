package com.application.aled.controller;

import com.application.aled.entity.Failure;
import com.application.aled.entity.Objects;
import com.application.aled.entity.history.*;
import com.application.aled.service.FailureService;
import com.application.aled.service.ObjectService;
import com.application.aled.service.history.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Logger;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/simulation")
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
    @Autowired
    AlarmClockHistoryService alarmClockHistoryService;

    Logger logger = Logger.getLogger("com.application.aled.controller.InjectorController");

    @GetMapping("")
    public List<Failure> getAllFailures(){
        setFailureEndingDate();
        /*
         *Get all objects to simulate
         */
        List<Objects> objectsList = objectService.getObjects();
        /**
         **Create a recent message for each objects and switch error state at true.
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

                case "ALARMCLOCK":
                    AlarmClockHistory alarmClockHistory = new AlarmClockHistory();
                    alarmClockHistory.setColumnData("connected");
                    alarmClockHistory.setData("true");
                    alarmClockHistory.setMessageTimestamp(new Timestamp(System.currentTimeMillis()));
                    alarmClockHistory.setObject(objects);
                    alarmClockHistoryService.addHistory(alarmClockHistory);


            }
            objects.setState(true);

        }
        logger.info("Insert histories of all objects");
        List<Failure> failures = failureService.getFailures();
        return failures;
    }


    /**
     * Set ending date of unfinished failures with current timestamp
     */
    public void setFailureEndingDate(){
        List<Failure> failures = failureService.getFailures();
        for (Failure failure: failures
             ) {
            if (failure.getEnd_date() == null)
                failure.setEnd_date(new Timestamp(System.currentTimeMillis()));
        }
    }
}
