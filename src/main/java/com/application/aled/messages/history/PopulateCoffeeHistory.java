package com.application.aled.messages.history;

import com.application.aled.entity.CoffeeMachine;
import com.application.aled.entity.Objects;
import com.application.aled.entity.history.CoffeeMachineHistory;
import com.application.aled.entity.history.ObjectsHistory;

import java.sql.Timestamp;
import java.util.*;

public class PopulateCoffeeHistory {
    Random random = new Random();

    public List<CoffeeMachineHistory> createCoffeeMachineHistory(List<Objects> objectsList, Date date, int numberPerDayAndObject, int hourTopLimit, int hourBottomLimit) {
        PopulateObjectsHistory populateObjectsHistory = new PopulateObjectsHistory();
        List<ObjectsHistory> objectsHistoriesLampsMorning = populateObjectsHistory.setMessagesTimestamps(objectsList, date, numberPerDayAndObject, hourTopLimit, hourBottomLimit);

        List<CoffeeMachineHistory> coffeeMachineHistories = new ArrayList<CoffeeMachineHistory>();

        for (ObjectsHistory objectHisto : objectsHistoriesLampsMorning) {
            CoffeeMachineHistory coffeeMachineMessage;

            boolean randomBoolean = random.nextBoolean();
            int randomCapsules = random.nextInt(10 - 1) + 1;
            int randomHour = random.nextInt(hourTopLimit - hourBottomLimit) + hourBottomLimit;

            if (randomBoolean){
                long plusADay = objectHisto.getMessageTimestamp().getTime()+1*24*60*60*1000;
                Timestamp scheduleCoffee = new Timestamp(plusADay);

                scheduleCoffee.setHours(randomHour);
                scheduleCoffee.setMinutes(0);
                scheduleCoffee.setSeconds(00);

                populateObjectsHistory.setMessageData(objectHisto, "schedule_coffee", scheduleCoffee.toString());
            } else {
                populateObjectsHistory.setMessageData(objectHisto, "capsules", String.valueOf(randomCapsules));
            }

            coffeeMachineMessage = new CoffeeMachineHistory(objectHisto.getData(), objectHisto.getColumnData(), objectHisto.getMessageTimestamp(), objectHisto.getObject());
            //System.out.println(coffeeMachineMessage.toString());

            coffeeMachineHistories.add(coffeeMachineMessage);
        }

        coffeeMachineHistories.sort(Comparator.comparing(CoffeeMachineHistory::getMessageTimestamp));
        return coffeeMachineHistories;
    }
}
