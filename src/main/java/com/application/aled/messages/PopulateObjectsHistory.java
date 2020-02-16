package com.application.aled.messages;

import com.application.aled.entity.Objects;
import com.application.aled.entity.ObjectsHistory;

import java.sql.Timestamp;
import java.util.Date;
import java.util.*;

public class PopulateObjectsHistory {

    Random random = new Random();
    Date now = new Date();

    public List<ObjectsHistory> setMessagesTimestamps(List<Objects> objectsList, Date maximumDate, int numberPerDayAndObject, int hourTopLimit, int hourBottomLimit) {
        List<ObjectsHistory> historyList = new ArrayList<ObjectsHistory>();

        Map<Long, Integer> messagesLeftToDo = new HashMap<Long, Integer>();

        int messagesPerDayGlobal = numberPerDayAndObject * objectsList.size();

        for (Objects objects : objectsList) {
            messagesLeftToDo.put(objects.getId(), numberPerDayAndObject);
        }

        while (maximumDate.before(now)) {
            int hours = random.nextInt(hourTopLimit - hourBottomLimit) + hourBottomLimit;
            maximumDate.setHours(hours);

            int minutes = random.nextInt(59);
            maximumDate.setMinutes(minutes);

            int seconds = random.nextInt(59);
            maximumDate.setSeconds(seconds);

            int indexArray = random.nextInt(objectsList.size());
            Objects objectSelected = objectsList.get(indexArray);

            if (messagesLeftToDo.get(objectSelected.getId()) > 0) {
                Timestamp historyTime = new Timestamp(maximumDate.getTime());
                ObjectsHistory messageHistory = new ObjectsHistory(historyTime, objectSelected);

                historyList.add(messageHistory);

                // Message counters - 1
                messagesLeftToDo.replace(objectSelected.getId(), (messagesLeftToDo.get(objectSelected.getId()) - 1));
                messagesPerDayGlobal--;

                //System.out.println("Message history " + messageHistory.toString());

            } else {
                messagesLeftToDo.remove(objectSelected);
            }

            if(messagesPerDayGlobal == 0){
                messagesPerDayGlobal = numberPerDayAndObject * objectsList.size();

                long nextDay = maximumDate.getTime()+1*24*60*60*1000;

                maximumDate = new Date(nextDay);

                for (Objects objects : objectsList) {
                    messagesLeftToDo.put(objects.getId(), numberPerDayAndObject);
                }
            }
        }

        historyList.sort(Comparator.comparing(ObjectsHistory::getMessageTimestamp));
        return historyList;
    }
}
