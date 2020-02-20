package com.application.aled.messages.history;

import com.application.aled.entity.Objects;
import com.application.aled.entity.history.ObjectsHistory;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.*;
import java.util.logging.Logger;

public class PopulateObjectsHistory {

    Random random = new Random();
    Date today = new Date();

    String[] colorArray = {"YELLOW", "GREEN", "BLUE", "WHITE"};

    private static DecimalFormat decimalFormat = new DecimalFormat("#.#");

    //Logger logger = Logger.getLogger("com.application.aled.messages.history.PopulateObjectsHistory");

    public List<ObjectsHistory> createObjectsRecords(List<Objects> objectsToRecord, Date historyStartDate, int numberPerDayAndObject, int hourBottomLimit, int hourTopLimit, boolean power) {
        List<ObjectsHistory> historyList = new ArrayList<ObjectsHistory>();

        Map<Long, Integer> countMessagesLeftToDo = new HashMap<Long, Integer>();

        for (Objects object : objectsToRecord) {
            countMessagesLeftToDo.put(object.getId(), numberPerDayAndObject);
        }

        while (historyStartDate.before(today)) {

            for (Objects objectToRecord : objectsToRecord) {
                List<ObjectsHistory> orderedListByDate = new ArrayList<ObjectsHistory>();

                while (countMessagesLeftToDo.get(objectToRecord.getId()) > 0) {
                    int messageLeftToDo = countMessagesLeftToDo.get(objectToRecord.getId());

                    int hours = random.nextInt(hourTopLimit - hourBottomLimit) + hourBottomLimit;
                    historyStartDate.setHours(hours);

                    int minutes = random.nextInt(59);
                    historyStartDate.setMinutes(minutes);

                    int seconds = random.nextInt(59);
                    historyStartDate.setSeconds(seconds);

                    Timestamp recordTime = new Timestamp(historyStartDate.getTime());

                    ObjectsHistory messageRecord = new ObjectsHistory("toDo", "toDo", recordTime, objectToRecord);

                    setMessageDataByObjectType(messageRecord, objectToRecord, hourTopLimit, hourBottomLimit);

                    orderedListByDate.add(messageRecord);

                    countMessagesLeftToDo.replace(objectToRecord.getId(), messageLeftToDo - 1);

                    //logger.info("Message history " + messageRecord.toString());
                }

                orderedListByDate.sort(Comparator.comparing(ObjectsHistory::getMessageTimestamp));

                int index = 0;

                for (ObjectsHistory objectHisto : orderedListByDate) {
                    if(power) {
                        if (index == 0) {
                            setMessageData(objectHisto, "power", "on");
                        } else if (index == numberPerDayAndObject - 1) {
                            setMessageData(objectHisto, "power", "off");
                        }
                    }
                    index++;
                    historyList.add(objectHisto);
                }

                countMessagesLeftToDo.remove(objectToRecord);
            }

            long nextDay = historyStartDate.getTime()+1*24*60*60*1000;

            historyStartDate = new Date(nextDay);

            for (Objects objects : objectsToRecord) {
                countMessagesLeftToDo.put(objects.getId(), numberPerDayAndObject);
            }
        }

        return historyList;
    }

    public void setMessageData(ObjectsHistory objectRecord, String columnData, String data){
        objectRecord.setColumnData(columnData);
        objectRecord.setData(data);
    }

    public void setMessageDataByObjectType(ObjectsHistory messageHistory, Objects object, int hourTopLimit, int hourBottomLimit){
        boolean randomBoolean = random.nextBoolean();

        long plusADay = today.getTime()+1*24*60*60*1000;

        switch (object.getObjectType()){
            case "LAMP":
                int randomColor = random.nextInt(colorArray.length - 1);
                int randomIntensity = random.nextInt(10) * 10;

                if (randomBoolean){
                    setMessageData(messageHistory, "color", colorArray[randomColor]);
                } else {
                    setMessageData(messageHistory, "intensity", String.valueOf(randomIntensity));
                }
                break;
            case "COFFEEMACHINE":
                int randomCapsules = random.nextInt(10 - 1) + 1;
                int randomHour = random.nextInt(hourTopLimit - hourBottomLimit) + hourBottomLimit;

                if (randomBoolean){
                    Timestamp scheduleCoffee = new Timestamp(plusADay);

                    scheduleCoffee.setHours(randomHour);
                    scheduleCoffee.setMinutes(0);
                    scheduleCoffee.setSeconds(00);

                    setMessageData(messageHistory, "schedule_coffee", scheduleCoffee.toString());
                } else {
                    setMessageData(messageHistory, "capsules", String.valueOf(randomCapsules));
                }
                break;
            case "ALARMCLOCK":
                double randomRadioStation = random.nextInt(110 - 90) + 90 + random.nextFloat();
                String randomRadioStationString = decimalFormat.format(randomRadioStation);
                int randomHourRadio = random.nextInt(9 - 6) + 6;

                if (randomBoolean){
                    Timestamp alarm = new Timestamp(plusADay);

                    alarm.setHours(randomHourRadio);
                    alarm.setMinutes(0);
                    alarm.setSeconds(00);

                    setMessageData(messageHistory, "alarm", alarm.toString());
                } else {
                    setMessageData(messageHistory, "radio", randomRadioStationString);
                }
                break;
            case "SHUTTER":
                if(messageHistory.getMessageTimestamp().getHours() < 9){
                    setMessageData(messageHistory, "action", "open");
                } else {
                    setMessageData(messageHistory, "action", "close");
                }
                break;
            default:
                break;
        }
    }
}
