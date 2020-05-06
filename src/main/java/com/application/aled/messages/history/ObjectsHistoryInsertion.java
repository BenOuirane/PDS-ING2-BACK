package com.application.aled.messages.history;

import com.application.aled.entity.history.*;
import com.application.aled.entity.Objects;
import com.application.aled.service.history.*;
import com.application.aled.service.ObjectServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.*;
import java.util.logging.Logger;

@Component
public class ObjectsHistoryInsertion {

    @Autowired
    ObjectServiceImpl objectService;

    @Autowired
    LampHistoryServiceImpl lampHistoryService;

    @Autowired
    ShutterHistoryServiceImpl shutterHistoryService;

    @Autowired
    CoffeeMachineHistoryServiceImpl coffeeHistoryService;

    @Autowired
    AlarmClockHistoryServiceImpl alarmHistoryService;

    // OVEN TODO
    //@Autowired
    //OvenHistoryServiceImpl ovenHistoryService;
    Logger logger = Logger.getLogger("com.application.aled.messages.history.ObjectsHistoryInsertion");


    @Async
    public void createObjectHistories(){
        logger.info("Inserting history started");

        Date oneMonthAgo = new Date();
        Date today = new Date();

        Calendar c = Calendar.getInstance();
        c.setTime(oneMonthAgo);
        c.add(Calendar.MONTH, -1);
        oneMonthAgo = c.getTime();

        Timestamp twoDaysAgo = new Timestamp(today.getTime()-2*24*60*60*1000);
        twoDaysAgo.setHours(10);


        Timestamp threeDaysAgo = new Timestamp(today.getTime()-3*24*60*60*1000);

        PopulateObjectsHistory populateObjectsHistory = new PopulateObjectsHistory();

        List<Objects> lamps = objectService.getObjectsByObjectType("LAMP");
        List<Objects> shutters = objectService.getObjectsByObjectType("SHUTTER");
        List<Objects> coffees = objectService.getObjectsByObjectType("COFFEEMACHINE");
        List<Objects> alarms = objectService.getObjectsByObjectType("ALARMCLOCK");

        //List<Objects> ovens = objectService.getObjectsByObjectType("OVEN");


        /* ------ LAMPS ------ */
        List<ObjectsHistory> morningLampHistory = populateObjectsHistory.createObjectsRecords(lamps, oneMonthAgo, 3, 6, 9, true, false);
        List<ObjectsHistory> eveningLampHistory = populateObjectsHistory.createObjectsRecords(lamps, oneMonthAgo, 3, 20, 22, true, true);

        for (Objects lamp: lamps) {
            eveningLampHistory.addAll(populateObjectsHistory.createHistoryErrors(lamp, "power", "8", twoDaysAgo));
        }

        lampHistoryService.emptyTable();

        for (ObjectsHistory objectsHistory : sortList(morningLampHistory, eveningLampHistory)) {
            LampHistory lampHistory = new LampHistory(objectsHistory.getData(), objectsHistory.getColumnData(), objectsHistory.getMessageTimestamp(), objectsHistory.getObject());
            lampHistoryService.addHistory(lampHistory);
        }

        /* ------ SHUTTERS ------ */
        List<ObjectsHistory> morningShutterHistory = populateObjectsHistory.createObjectsRecords(shutters , oneMonthAgo, 1, 7, 9, false, false);
        List<ObjectsHistory> eveningShutterHistory = populateObjectsHistory.createObjectsRecords(shutters , oneMonthAgo, 1, 19,  20, false, true);

        for (Objects shutter: shutters) {
            eveningShutterHistory.addAll(populateObjectsHistory.createHistoryErrors(shutter, "shutterAlarm", "28", new Timestamp(oneMonthAgo.getTime()-2*24*60*60*1000)));
            eveningShutterHistory.addAll(populateObjectsHistory.createHistoryErrors(shutter, "nightShutter", "0", new Timestamp(oneMonthAgo.getTime())));
        }

        shutterHistoryService.emptyTable();

        for (ObjectsHistory objectsHistory : sortList(morningShutterHistory, eveningShutterHistory)) {
            ShutterHistory shutterHistory = new ShutterHistory(objectsHistory.getData(), objectsHistory.getColumnData(), objectsHistory.getMessageTimestamp(), objectsHistory.getObject());
            shutterHistoryService.addHistory(shutterHistory);
        }

        /* ------ COFFEEMACHINE ------ */
        List<ObjectsHistory> objectsHistoriesCoffeeMachine = populateObjectsHistory.createObjectsRecords(coffees, oneMonthAgo, 3, 7, 9, true, true);
        List<ObjectsHistory> historyErrors = new ArrayList<ObjectsHistory>();

        for (Objects coffee: coffees) {
            historyErrors.addAll(populateObjectsHistory.createHistoryErrors(coffee, "power", "3", twoDaysAgo));
        }

        coffeeHistoryService.emptyTable();

        for (ObjectsHistory objectsHistory : sortList(objectsHistoriesCoffeeMachine, historyErrors)) {
            CoffeeMachineHistory coffeeMachineHistory = new CoffeeMachineHistory(objectsHistory.getData(), objectsHistory.getColumnData(), objectsHistory.getMessageTimestamp(), objectsHistory.getObject());
            coffeeHistoryService.addHistory(coffeeMachineHistory);
        }



        /* ------ ALARMCLOCK ------ */
        List<ObjectsHistory> morningAlarmHistory = populateObjectsHistory.createObjectsRecords(alarms, oneMonthAgo, 2, 7, 9, false, false);
        List<ObjectsHistory> eveningAlarmHistory = populateObjectsHistory.createObjectsRecords(alarms, oneMonthAgo, 2, 18, 19, false, true);

        for (Objects alarm: alarms) {
            eveningAlarmHistory.addAll(populateObjectsHistory.createHistoryErrors(alarm, "nightAlarm", "0", twoDaysAgo));
        }

        alarmHistoryService.emptyTable();

        for (ObjectsHistory objectsHistory : sortList(morningAlarmHistory, eveningAlarmHistory)) {
            AlarmClockHistory alarmHistory = new AlarmClockHistory(objectsHistory.getData(), objectsHistory.getColumnData(), objectsHistory.getMessageTimestamp(), objectsHistory.getObject());
            alarmHistoryService.addHistory(alarmHistory);
        }

        logger.info("Inserting history finished");

        /*
        List<ObjectsHistory> objectsHistoriesOvenLunch = populateHistory.setMessagesTimestamps(objects.subList(14,17) , weekAgo, 4, 13, 12);
        List<ObjectsHistory> objectsHistoriesOvenDinner = populateHistory.setMessagesTimestamps(objects.subList(14,17) , weekAgo, 4, 19, 18);

        for (Objects oven: ovens) {
            objectsHistoriesOvenDinner.addAll(populateObjectsHistory.createHistoryErrors(oven, "power", "7", oneDayAgo));
        }

        */

    }

    public List<ObjectsHistory> sortList(List<ObjectsHistory> list1, List<ObjectsHistory> list2){
        List<ObjectsHistory> sortedList = new ArrayList<ObjectsHistory>();

        for (ObjectsHistory objectsHistory : list1) {
            sortedList.add(objectsHistory);
        }

        for (ObjectsHistory objectsHistory : list2) {
            sortedList.add(objectsHistory);
        }

        sortedList.sort(Comparator.comparing(ObjectsHistory::getMessageTimestamp));

        return sortedList;
    }

    /***
     * insert lines in database to signal that objects are connected
     ***/
    @Async
    public void insertObjectAreConnected(){
        logger.info("Insert connection history");
        /**
         * Get all objects
         */
        List<Objects> objectsList = new ArrayList<>();
        objectsList = objectService.getObjectsByObjectType("");

        /**
         * Lamp history insert
         **/
        objectsList = objectService.getObjectsByObjectType("LAMP");
        for (Objects objectToMock: objectsList) {
            LampHistory lampHistory = new LampHistory();
            lampHistory.setColumnData("connected");
            lampHistory.setData("true");
            lampHistory.setMessageTimestamp(new Timestamp(System.currentTimeMillis()));
            lampHistory.setObject(objectToMock);
            lampHistoryService.addHistory(lampHistory);
            logger.info("Insert history for lamp "+objectToMock.getId());
        }

        /**
         * AlarmClock history insert
         **/
        objectsList = objectService.getObjectsByObjectType("ALARMCLOCK");
        for (Objects objectToMock: objectsList) {
            AlarmClockHistory alarmClockHistory = new AlarmClockHistory();
            alarmClockHistory.setColumnData("connected");
            alarmClockHistory.setData("true");
            alarmClockHistory.setMessageTimestamp(new Timestamp(System.currentTimeMillis()));
            alarmClockHistory.setObject(objectToMock);
            alarmHistoryService.addHistory(alarmClockHistory);
            logger.info("Insert history for alarm clock "+objectToMock.getId());
        }

        /**
         * Shutter history insert
         */
        objectsList = objectService.getObjectsByObjectType("SHUTTER");
        for (Objects objectToMock: objectsList) {
            ShutterHistory shutterHistory = new ShutterHistory();
            shutterHistory.setColumnData("connected");
            shutterHistory.setData("true");
            shutterHistory.setMessageTimestamp(new Timestamp(System.currentTimeMillis()));
            shutterHistory.setObject(objectToMock);
            shutterHistoryService.addHistory(shutterHistory);
            logger.info("Insert history for alarm shutter " + objectToMock.getId());
        }
        logger.info("Inserting history connected fished ");

    }
}
