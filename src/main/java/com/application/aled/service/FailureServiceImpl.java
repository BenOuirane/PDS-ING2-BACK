<<<<<<< HEAD
package com.application.aled.service;

import com.application.aled.entity.Failure;
import com.application.aled.entity.Objects;
import com.application.aled.entity.history.*;
import com.application.aled.repository.FailureRepository;
import com.application.aled.service.history.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.logging.Logger;

import java.util.ArrayList;
import java.util.List;

@Service
public class FailureServiceImpl implements FailureService {

    /*
    We get a Message Repository attribute so we get all basic
    sql methods (findAll(), save()...)
    They will be our base for the rest of the service
     */
    @Autowired
    ObjectService objectService;
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
    @Autowired
    FailureRepository repository;
    Logger logger = Logger.getLogger("com.application.aled.service.FailureServiceImpl");

    /*
    Here we use the 'findAll()' to create a custom getFailures()
    for our application, our controllers
     */
    @Override
    public List<Failure> getFailures() {
      
        logger.info("Get all Failure...");
        List<Failure> failures = new ArrayList<>();
        repository.findAll().forEach(failures::add);

        return failures;
    }
    public List<Failure> getFailureByObject(Objects objects) throws NullPointerException {
        logger.info("Search failure of a connected object");
        List<Failure> failures = repository.findByObjects(objects);

        return failures;
    }

    @Override
    public Failure addFailure(Failure failure) {
        Failure failureRecord = repository.save(failure);
        return failureRecord;
    }
    @Override
    public List<Failure> getFailuresByYear(int year) throws NullPointerException{

        List<Failure> failuresbyyear = new ArrayList<>();
      
        repository.findFailuresByYear(year).forEach(failuresbyyear::add);
        logger.info(" get the failures for the year " + year);
        
        return failuresbyyear; }
        
    @Override
    public List<Failure> getFailuresByYearAndMonth(int year, int month) throws NullPointerException{
        
        List<Failure> failuresbyyear_month = new ArrayList<>();
        repository.findFailuresByYearAndMonth(year, month).forEach(failuresbyyear_month::add);
         logger.info("get the failures for the year " + year+" especially the month "+month);
        return failuresbyyear_month; }

    @Override
    public List<Failure> getFailuresByDay(int year, int month, int day) throws NullPointerException{

        List<Failure> failuresbyday = new ArrayList<>();
        repository.findFailuresByDay(year, month, day).forEach(failuresbyday::add);
        logger.info("get the failures for the day "+ day+" of the month "+month+ " and the year "+year);
        return failuresbyday; }

    @Override
    public List<Failure> launchSimulation(){
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
        simulateSuspectBehavior();
        logger.info("Insert histories of all objects");
        List<Failure> failures = this.getFailures();
        return failures;
    }

    @Override
    public Failure getMoreRecentFailureByObjectAndColumnData(Objects objects, String columnData) {
        List<Failure> failureList = repository.findFailureByObjectsAndMessage(objects,columnData);
        if (failureList.isEmpty())
            return null;

        return failureList.get(failureList.size()-1);
    }


    /**
     * Set ending date of unfinished failures with current timestamp
     */
    public void setFailureEndingDate(){
        List<Failure> failures = this.getFailures();
        for (Failure failure: failures
        ) {
            if (failure.getEnd_date() == null)
                failure.setEnd_date(new Timestamp(System.currentTimeMillis()));
        }
    }

    public void simulateSuspectBehavior(){
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        long twoMinutesBeforeLong = currentTimestamp.getTime()- 120000;
        Timestamp timestampTwoMinutesBefore = new Timestamp(twoMinutesBeforeLong);

        List<Objects> ovens = objectService.getObjectsByObjectType("OVEN");
        if (ovens.size()==0)
            return;

        OvenHistory ovenHistory20degrees = new OvenHistory();
        ovenHistory20degrees.setColumnData("temperature");
        ovenHistory20degrees.setData("20");
        ovenHistory20degrees.setMessageTimestamp(timestampTwoMinutesBefore);
        ovenHistory20degrees.setObject(ovens.get(0));
        ovenHistoryService.addHistory(ovenHistory20degrees);

        OvenHistory ovenHistory100degrees = new OvenHistory();
        ovenHistory100degrees.setColumnData("temperature");
        ovenHistory100degrees.setData("100");
        ovenHistory100degrees.setMessageTimestamp(currentTimestamp);
        ovenHistory100degrees.setObject(ovens.get(0));
        ovenHistoryService.addHistory(ovenHistory100degrees);

        if(ovens.size()==1)
            return;;
        OvenHistory ovenHistory400 = new OvenHistory();
        ovenHistory400.setColumnData("temperature");
        ovenHistory400.setData("400");
        ovenHistory400.setMessageTimestamp(currentTimestamp);
        ovenHistory400.setObject(ovens.get(1));
        ovenHistoryService.addHistory(ovenHistory400);
    }

}



=======
package com.application.aled.service;

import com.application.aled.entity.Failure;
import com.application.aled.entity.Objects;
import com.application.aled.entity.history.*;
import com.application.aled.repository.FailureRepository;
import com.application.aled.service.history.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.logging.Logger;

import java.util.ArrayList;
import java.util.List;

@Service
public class FailureServiceImpl implements FailureService {

    /*
    We get a Message Repository attribute so we get all basic
    sql methods (findAll(), save()...)
    They will be our base for the rest of the service
     */
    @Autowired
    ObjectService objectService;
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
    @Autowired
    FailureRepository repository;
    Logger logger = Logger.getLogger("com.application.aled.service.FailureServiceImpl");

    /*
    Here we use the 'findAll()' to create a custom getFailures()
    for our application, our controllers
     */
    @Override
    public List<Failure> getFailures() {
      
        logger.info("Get all Failure...");
        List<Failure> failures = new ArrayList<>();
        repository.findAll().forEach(failures::add);

        return failures;
    }
    public List<Failure> getFailureByObject(Objects objects) throws NullPointerException {
        logger.info("Search failure of a connected object");
        List<Failure> failures = repository.findByObjects(objects);

        return failures;
    }

    @Override
    public Failure addFailure(Failure failure) {
        Failure failureRecord = repository.save(failure);
        return failureRecord;
    }
    @Override
    public List<Failure> getFailuresByYear(int year) throws NullPointerException{

        List<Failure> failuresbyyear = new ArrayList<>();
      
        repository.findFailuresByYear(year).forEach(failuresbyyear::add);
        logger.info(" get the failures for the year " + year);
        
        return failuresbyyear; }
        
    @Override
    public List<Failure> getFailuresByYearAndMonth(int year, int month) throws NullPointerException{
        
        List<Failure> failuresbyyear_month = new ArrayList<>();
        repository.findFailuresByYearAndMonth(year, month).forEach(failuresbyyear_month::add);
         logger.info("get the failures for the year " + year+" especially the month "+month);
        return failuresbyyear_month; }

    @Override
    public List<Failure> getFailuresByDay(int year, int month, int day) throws NullPointerException{

        List<Failure> failuresbyday = new ArrayList<>();
        repository.findFailuresByDay(year, month, day).forEach(failuresbyday::add);
        logger.info("get the failures for the day "+ day+" of the month "+month+ " and the year "+year);
        return failuresbyday; }

    @Override
    public List<Failure> launchSimulation(){
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
        simulateSuspectBehavior();
        logger.info("Insert histories of all objects");
        List<Failure> failures = this.getFailures();
        return failures;
    }

    @Override
    public Failure getMoreRecentFailureByObjectAndColumnData(Objects objects, String columnData) {
        List<Failure> failureList = repository.findFailureByObjectsAndMessage(objects,columnData);
        if (failureList.isEmpty())
            return null;

        return failureList.get(failureList.size()-1);
    }


    /**
     * Set ending date of unfinished failures with current timestamp
     */
    public void setFailureEndingDate(){
        List<Failure> failures = this.getFailures();
        for (Failure failure: failures
        ) {
            if (failure.getEnd_date() == null)
                failure.setEnd_date(new Timestamp(System.currentTimeMillis()));
        }
    }

    public void simulateSuspectBehavior(){
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        long twoMinutesBeforeLong = currentTimestamp.getTime()- 120000;
        Timestamp timestampTwoMinutesBefore = new Timestamp(twoMinutesBeforeLong);

        List<Objects> ovens = objectService.getObjectsByObjectType("OVEN");
        if (ovens.size()==0)
            return;

        OvenHistory ovenHistory20degrees = new OvenHistory();
        ovenHistory20degrees.setColumnData("temperature");
        ovenHistory20degrees.setData("20");
        ovenHistory20degrees.setMessageTimestamp(timestampTwoMinutesBefore);
        ovenHistory20degrees.setObject(ovens.get(0));
        ovenHistoryService.addHistory(ovenHistory20degrees);

        OvenHistory ovenHistory100degrees = new OvenHistory();
        ovenHistory100degrees.setColumnData("temperature");
        ovenHistory100degrees.setData("100");
        ovenHistory100degrees.setMessageTimestamp(currentTimestamp);
        ovenHistory100degrees.setObject(ovens.get(0));
        ovenHistoryService.addHistory(ovenHistory100degrees);

        if(ovens.size()==1)
            return;;
        OvenHistory ovenHistory400 = new OvenHistory();
        ovenHistory400.setColumnData("temperature");
        ovenHistory400.setData("400");
        ovenHistory400.setMessageTimestamp(currentTimestamp);
        ovenHistory400.setObject(ovens.get(1));
        ovenHistoryService.addHistory(ovenHistory400);
    }

}



>>>>>>> 8d1da6dc7d21bfe8feb6c1f59c4d4d4e90d499cc
