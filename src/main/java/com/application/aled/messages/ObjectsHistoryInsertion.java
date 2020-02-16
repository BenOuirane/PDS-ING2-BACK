package com.application.aled.messages;

import com.application.aled.entity.LampHistory;
import com.application.aled.entity.Objects;
import com.application.aled.entity.ObjectsHistory;
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

    @PostConstruct
    public void setMessages(){
        PopulateObjectsHistory populateHistory = new PopulateObjectsHistory();
        PopulateLampHistory lampHistory = new PopulateLampHistory();

        Date weekAgo = new Date();

        List<Objects> objects = objectService.getObjects();

        long minusWeek = weekAgo.getTime()-7*24*60*60*1000;

        weekAgo = new Date(minusWeek);

        List<LampHistory> lamps = lampHistory.createLampHistory(objects.subList(0,3), weekAgo);

        /*List<ObjectsHistory> objectsHistoriesLampsMorning = populateHistory.setMessagesTimestamps(objects.subList(0,3) , weekAgo, 6, 9, 7);
        List<ObjectsHistory> objectsHistoriesLampsEvening = populateHistory.setMessagesTimestamps(objects.subList(0,3) , weekAgo, 6, 22, 19);

        List<ObjectsHistory> objectsHistoriesOvenLunch = populateHistory.setMessagesTimestamps(objects.subList(14,17) , weekAgo, 4, 13, 12);
        List<ObjectsHistory> objectsHistoriesOvenDinner = populateHistory.setMessagesTimestamps(objects.subList(14,17) , weekAgo, 4, 19, 18);

        List<ObjectsHistory> objectsHistoriesShutterMorning = populateHistory.setMessagesTimestamps(objects.subList(7,11) , weekAgo, 2, 9, 7);
        List<ObjectsHistory> objectsHistoriesShutterEvening = populateHistory.setMessagesTimestamps(objects.subList(7,11) , weekAgo, 2, 20, 19);

        List<ObjectsHistory> objectsHistoriesCoffeeMachine = populateHistory.setMessagesTimestamps(objects.subList(11,14) , weekAgo, 2, 9, 7);

        List<ObjectsHistory> objectsHistoriesAlarmClockMorning = populateHistory.setMessagesTimestamps(objects.subList(3,7) , weekAgo, 3, 9, 7);
        List<ObjectsHistory> objectsHistoriesAlarmClockEvening = populateHistory.setMessagesTimestamps(objects.subList(3,7) , weekAgo, 3, 19, 18);*/

        System.out.println(lamps.get(0).toString() + " : first one");
    }
}
