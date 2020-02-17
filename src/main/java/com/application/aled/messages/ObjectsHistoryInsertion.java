package com.application.aled.messages;

import com.application.aled.entity.history.LampHistory;
import com.application.aled.entity.Objects;
import com.application.aled.service.LampHistoryServiceImpl;
import com.application.aled.service.ObjectServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

@Component
public class ObjectsHistoryInsertion {

    @Autowired
    ObjectServiceImpl objectService;

    @Autowired
    LampHistoryServiceImpl lampHistoryService;

    @PostConstruct
    public void createObjectHistories(){
        Date weekAgo = new Date();

        List<Objects> lamps = objectService.getObjectsByObjectType("LAMP");

        long minusWeek = weekAgo.getTime()-7*24*60*60*1000;

        weekAgo = new Date(minusWeek);

        /* ------ LAMPS ------ */
        PopulateLampHistory populateLampHistory = new PopulateLampHistory();

        List<LampHistory> morningLampHistory = populateLampHistory.createLampHistory(lamps, weekAgo, 4, 9, 6);
        lampHistoryService.emptyTable();

        for (LampHistory lampHistory : morningLampHistory) {
            lampHistoryService.addHistory(lampHistory);
        }

        List<LampHistory> eveningLampHistory = populateLampHistory.createLampHistory(lamps, weekAgo, 4, 22, 20);
        lampHistoryService.emptyTable();

        for (LampHistory lampHistory : eveningLampHistory) {
            lampHistoryService.addHistory(lampHistory);
        }

        /*List<ObjectsHistory> objectsHistoriesLampsMorning = populateHistory.setMessagesTimestamps(objects.subList(0,3) , weekAgo, 6, 9, 7);
        List<ObjectsHistory> objectsHistoriesLampsEvening = populateHistory.setMessagesTimestamps(objects.subList(0,3) , weekAgo, 6, 22, 19);

        List<ObjectsHistory> objectsHistoriesOvenLunch = populateHistory.setMessagesTimestamps(objects.subList(14,17) , weekAgo, 4, 13, 12);
        List<ObjectsHistory> objectsHistoriesOvenDinner = populateHistory.setMessagesTimestamps(objects.subList(14,17) , weekAgo, 4, 19, 18);

        List<ObjectsHistory> objectsHistoriesShutterMorning = populateHistory.setMessagesTimestamps(objects.subList(7,11) , weekAgo, 2, 9, 7);
        List<ObjectsHistory> objectsHistoriesShutterEvening = populateHistory.setMessagesTimestamps(objects.subList(7,11) , weekAgo, 2, 20, 19);

        List<ObjectsHistory> objectsHistoriesCoffeeMachine = populateHistory.setMessagesTimestamps(objects.subList(11,14) , weekAgo, 2, 9, 7);

        List<ObjectsHistory> objectsHistoriesAlarmClockMorning = populateHistory.setMessagesTimestamps(objects.subList(3,7) , weekAgo, 3, 9, 7);
        List<ObjectsHistory> objectsHistoriesAlarmClockEvening = populateHistory.setMessagesTimestamps(objects.subList(3,7) , weekAgo, 3, 19, 18);*/

    }
}
