package com.application.aled.messages;

import com.application.aled.entity.Objects;
import com.application.aled.entity.history.ObjectsHistory;

import java.sql.Timestamp;
import java.util.Date;
import java.util.*;

public class PopulateObjectsHistory {

    Random random = new Random();
    Date now = new Date();

    public List<ObjectsHistory> setMessagesTimestamps(List<Objects> objectsList, Date maximumDate, int numberPerDayAndObject, int hourTopLimit, int hourBottomLimit) {
        List<ObjectsHistory> historyList = new ArrayList<ObjectsHistory>();

        Map<Long, Integer> messagesLeftToDo = new HashMap<Long, Integer>();

        for (Objects objects : objectsList) {
            messagesLeftToDo.put(objects.getId(), numberPerDayAndObject);
        }

        while (maximumDate.before(now)) {
            for (Objects object : objectsList) {
                List<ObjectsHistory> orderTime = new ArrayList<ObjectsHistory>();
                while (messagesLeftToDo.get(object.getId()) > 0) {

                    int hours = random.nextInt(hourTopLimit - hourBottomLimit) + hourBottomLimit;
                    maximumDate.setHours(hours);

                    int minutes = random.nextInt(59);
                    maximumDate.setMinutes(minutes);

                    int seconds = random.nextInt(59);
                    maximumDate.setSeconds(seconds);

                    Timestamp historyTime = new Timestamp(maximumDate.getTime());

                    ObjectsHistory messageHistory = new ObjectsHistory("toDo", "toDo", historyTime, object);

                    orderTime.add(messageHistory);

                    // Message counters - 1
                    messagesLeftToDo.replace(object.getId(), (messagesLeftToDo.get(object.getId()) - 1));

                    //System.out.println("Message history " + messageHistory.toString());
                }

                orderTime.sort(Comparator.comparing(ObjectsHistory::getMessageTimestamp));

                int index = 0;
                for (ObjectsHistory objectHisto : orderTime) {
                    if(index == 0) {
                        setMessageData(objectHisto, "power", "on");
                    } else if (index == numberPerDayAndObject - 1){
                        setMessageData(objectHisto, "power", "off");
                    }
                    index++;
                    historyList.add(objectHisto);
                }

                messagesLeftToDo.remove(object);
            }

            long nextDay = maximumDate.getTime()+1*24*60*60*1000;

            maximumDate = new Date(nextDay);

            for (Objects objects : objectsList) {
                messagesLeftToDo.put(objects.getId(), numberPerDayAndObject);
            }
        }

        return historyList;
    }

    public ObjectsHistory setMessageData(ObjectsHistory objectHisto, String columnData, String data){
        objectHisto.setColumnData(columnData);
        objectHisto.setData(data);

        return objectHisto;
    }
}
