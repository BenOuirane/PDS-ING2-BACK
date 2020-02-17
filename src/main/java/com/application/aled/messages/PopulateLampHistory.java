package com.application.aled.messages;

import com.application.aled.entity.history.LampHistory;
import com.application.aled.entity.Objects;
import com.application.aled.entity.history.ObjectsHistory;

import java.util.*;

public class PopulateLampHistory {
    Random random = new Random();

    String[] colorArray = {"YELLOW", "GREEN", "BLUE", "WHITE"};

    public List<LampHistory> createLampHistory(List<Objects> objectsList, Date date, int numberPerDayAndObject, int hourTopLimit, int hourBottomLimit) {
        PopulateObjectsHistory populateObjectsHistory = new PopulateObjectsHistory();
        List<ObjectsHistory> objectsHistoriesLampsMorning = populateObjectsHistory.setMessagesTimestamps(objectsList, date, numberPerDayAndObject, hourTopLimit, hourBottomLimit);

        List<LampHistory> lampHistories = new ArrayList<LampHistory>();

        for (ObjectsHistory objectHisto : objectsHistoriesLampsMorning) {
            LampHistory lampMessage;

            if(objectHisto.getColumnData() != "power"){
                boolean randomBoolean = random.nextBoolean();
                int randomColor = random.nextInt(colorArray.length - 1);
                int randomIntensity = random.nextInt(10) * 10;

                if (randomBoolean){
                    populateObjectsHistory.setMessageData(objectHisto, "color", colorArray[randomColor]);
                } else {
                    populateObjectsHistory.setMessageData(objectHisto, "intensity", String.valueOf(randomIntensity));
                }

            }

            lampMessage = new LampHistory(objectHisto.getData(), objectHisto.getColumnData(), objectHisto.getMessageTimestamp(), objectHisto.getObject());
            System.out.println(lampMessage.toString());

            lampHistories.add(lampMessage);
        }

        lampHistories.sort(Comparator.comparing(LampHistory::getMessageTimestamp));
        return lampHistories;
    }

}
