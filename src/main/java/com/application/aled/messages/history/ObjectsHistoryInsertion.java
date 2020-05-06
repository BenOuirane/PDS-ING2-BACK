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

    @Autowired
    OvenHistoryServiceImpl ovenHistoryService;

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

        Timestamp sevenDaysAgo12 = new Timestamp(today.getTime()-7*24*60*60*1000);
        sevenDaysAgo12.setHours(12);
        sevenDaysAgo12.setMinutes(00);

        Timestamp sevenDaysAgo13 = new Timestamp(sevenDaysAgo12.getTime());
        sevenDaysAgo13.setHours(13);
        sevenDaysAgo13.setMinutes(00);

        Timestamp sevenDaysAgo12h45 = new Timestamp(sevenDaysAgo12.getTime());
        sevenDaysAgo12h45.setHours(12);
        sevenDaysAgo12h45.setMinutes(45);

        Timestamp twoWeeksAgo12 = new Timestamp(sevenDaysAgo12.getTime()-7*24*60*60*1000);
        Timestamp twoWeeksAgo13 = new Timestamp(sevenDaysAgo13.getTime()-7*24*60*60*1000);
        Timestamp twoWeeksAgo12h45 = new Timestamp(sevenDaysAgo12h45.getTime()-7*24*60*60*1000);

        Timestamp tenDaysAgo18 = new Timestamp(sevenDaysAgo12.getTime()-3*24*60*60*1000);
        tenDaysAgo18.setHours(18);
        tenDaysAgo18.setMinutes(00);
        Timestamp tenDaysAgo19 = new Timestamp(sevenDaysAgo13.getTime()-3*24*60*60*1000);
        tenDaysAgo19.setHours(19);
        tenDaysAgo19.setMinutes(00);
        Timestamp tenDaysAgo23 = new Timestamp(sevenDaysAgo12h45.getTime()-3*24*60*60*1000);
        tenDaysAgo23.setHours(23);
        tenDaysAgo23.setMinutes(00);

        PopulateObjectsHistory populateObjectsHistory = new PopulateObjectsHistory();

        List<Objects> lamps = objectService.getObjectsByObjectType("LAMP");
        List<Objects> shutters = objectService.getObjectsByObjectType("SHUTTER");
        List<Objects> coffees = objectService.getObjectsByObjectType("COFFEEMACHINE");
        List<Objects> alarms = objectService.getObjectsByObjectType("ALARMCLOCK");
        List<Objects> ovens = objectService.getObjectsByObjectType("OVEN");


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

        /* ------ OVEN ------ */
        List<ObjectsHistory> ovenHistories = new ArrayList<ObjectsHistory>();

        for (Objects oven: ovens) {
            ovenHistories.addAll(populateObjectsHistory.createOvenHistories(sevenDaysAgo12, sevenDaysAgo13, sevenDaysAgo12h45, 300, oven));
            ovenHistories.addAll(populateObjectsHistory.createOvenHistories(tenDaysAgo18,  tenDaysAgo23, tenDaysAgo19, 600, oven));
        }

        ovenHistories.sort(Comparator.comparing(ObjectsHistory::getMessageTimestamp));

        ovenHistoryService.emptyTable();

        for (ObjectsHistory objectsHistory: ovenHistories) {
            OvenHistory ovenHistory = new OvenHistory(objectsHistory.getData(), objectsHistory.getColumnData(), objectsHistory.getMessageTimestamp(), objectsHistory.getObject());
            ovenHistoryService.addHistory(ovenHistory);
        }

        logger.info("Inserting history finished");

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
