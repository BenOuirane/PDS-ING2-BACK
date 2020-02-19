package com.application.aled.messages.history;

import com.application.aled.entity.history.*;
import com.application.aled.entity.Objects;
import com.application.aled.service.history.*;
import com.application.aled.service.ObjectServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

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

    @PostConstruct
    public void createObjectHistories(){
        Date weekAgo = new Date();

        long minusWeek = weekAgo.getTime()-7*24*60*60*1000;

        weekAgo = new Date(minusWeek);

        PopulateObjectsHistory populateObjectsHistory = new PopulateObjectsHistory();

        List<Objects> lamps = objectService.getObjectsByObjectType("LAMP");
        List<Objects> shutters = objectService.getObjectsByObjectType("SHUTTER");
        List<Objects> coffees = objectService.getObjectsByObjectType("COFFEEMACHINE");
        List<Objects> alarms = objectService.getObjectsByObjectType("ALARMCLOCK");

        //List<Objects> ovens = objectService.getObjectsByObjectType("OVEN");


        /* ------ LAMPS ------ */
        List<ObjectsHistory> morningLampHistory = populateObjectsHistory.createObjectsRecords(lamps, weekAgo, 4, 6, 9, true);
        List<ObjectsHistory> eveningLampHistory = populateObjectsHistory.createObjectsRecords(lamps, weekAgo, 4, 20, 22, true);

        lampHistoryService.emptyTable();

        for (ObjectsHistory objectsHistory : sortList(morningLampHistory, eveningLampHistory)) {
            LampHistory lampHistory = new LampHistory(objectsHistory.getData(), objectsHistory.getColumnData(), objectsHistory.getMessageTimestamp(), objectsHistory.getObject());
            lampHistoryService.addHistory(lampHistory);
        }

        /* ------ SHUTTERS ------ */
        List<ObjectsHistory> morningShutterHistory = populateObjectsHistory.createObjectsRecords(shutters , weekAgo, 1, 7, 9, false);
        List<ObjectsHistory> eveningShutterHistory = populateObjectsHistory.createObjectsRecords(shutters , weekAgo, 1, 19,  20, false);

        shutterHistoryService.emptyTable();

        for (ObjectsHistory objectsHistory : sortList(morningShutterHistory, eveningShutterHistory)) {
            ShutterHistory shutterHistory = new ShutterHistory(objectsHistory.getData(), objectsHistory.getColumnData(), objectsHistory.getMessageTimestamp(), objectsHistory.getObject());
            shutterHistoryService.addHistory(shutterHistory);
        }

        /* ------ COFFEEMACHINE ------ */
        List<ObjectsHistory> allCoffeerHistories = new ArrayList<ObjectsHistory>();
        List<ObjectsHistory> objectsHistoriesCoffeeMachine = populateObjectsHistory.createObjectsRecords(coffees, weekAgo, 3, 7, 9, true);

        coffeeHistoryService.emptyTable();

        for (ObjectsHistory objectsHistory : objectsHistoriesCoffeeMachine) {
            CoffeeMachineHistory coffeeMachineHistory = new CoffeeMachineHistory(objectsHistory.getData(), objectsHistory.getColumnData(), objectsHistory.getMessageTimestamp(), objectsHistory.getObject());
            coffeeHistoryService.addHistory(coffeeMachineHistory);
        }

        /* ------ ALARMCLOCK ------ */
        List<ObjectsHistory> morningAlarmHistory = populateObjectsHistory.createObjectsRecords(alarms, weekAgo, 3, 7, 9, false);
        List<ObjectsHistory> eveningAlarmHistory = populateObjectsHistory.createObjectsRecords(alarms, weekAgo, 3, 18, 19, false);

        alarmHistoryService.emptyTable();

        for (ObjectsHistory objectsHistory : sortList(morningAlarmHistory, eveningAlarmHistory)) {
            AlarmClockHistory alarmHistory = new AlarmClockHistory(objectsHistory.getData(), objectsHistory.getColumnData(), objectsHistory.getMessageTimestamp(), objectsHistory.getObject());
            alarmHistoryService.addHistory(alarmHistory);
        }

        /*
        List<ObjectsHistory> objectsHistoriesOvenLunch = populateHistory.setMessagesTimestamps(objects.subList(14,17) , weekAgo, 4, 13, 12);
        List<ObjectsHistory> objectsHistoriesOvenDinner = populateHistory.setMessagesTimestamps(objects.subList(14,17) , weekAgo, 4, 19, 18);
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

}
