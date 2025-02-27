package com.application.aled.messages.history;

import com.application.aled.entity.Objects;
import com.application.aled.entity.history.ObjectsHistory;
import com.application.aled.entity.history.OvenHistory;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.*;
import java.util.logging.Logger;

import static java.lang.Integer.parseInt;

public class PopulateObjectsHistory {

    Random random = new Random();
    Date today = new Date();

    String[] colorArray = {"YELLOW", "GREEN", "BLUE", "WHITE"};

    private static DecimalFormat decimalFormat = new DecimalFormat("#.#");

    //Logger logger = Logger.getLogger("com.application.aled.messages.history.PopulateObjectsHistory");

    public List<ObjectsHistory> createObjectsRecords(List<Objects> objectsToRecord, Date historyStartDate, int numberPerDayAndObject, int hourBottomLimit, int hourTopLimit, boolean power, boolean connected) {
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

        if(connected) {
            for (Objects objects : objectsToRecord) {
                Timestamp currentTime =  new Timestamp(System.currentTimeMillis());
                historyList.add(new ObjectsHistory("true", "connected",currentTime, objects));
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

    public List<ObjectsHistory> createOvenHistories(Timestamp startTime, Timestamp endTime, Timestamp stopTime, int maxTemp, Objects objectToRecord){
        List<ObjectsHistory> ovenHistories = new ArrayList<ObjectsHistory>();
        ObjectsHistory startHistory = new ObjectsHistory("on", "power", startTime, objectToRecord);
        ObjectsHistory endHistory = new ObjectsHistory("off", "power", endTime, objectToRecord);
        ovenHistories.add(startHistory);
        ovenHistories.add(endHistory);

        int randomTemp = random.nextInt(70) + 50;
        int temp = 25 + random.nextInt(10);

        Calendar cal = Calendar.getInstance();

        Timestamp messageTime = startTime;

        while(temp < maxTemp && messageTime.before(stopTime)){
            cal.setTime(messageTime);
            cal.add(Calendar.MINUTE, 5);
            messageTime = new Timestamp(cal.getTimeInMillis());
            temp = temp + randomTemp;
            ObjectsHistory ovenIncreaseHistory = new ObjectsHistory();

            if(temp < maxTemp && messageTime.before(stopTime)){
                ovenIncreaseHistory = new ObjectsHistory(String.valueOf(temp), "temp", messageTime, objectToRecord);
            } else if (temp < maxTemp && !messageTime.before(stopTime)){
                ovenIncreaseHistory = new ObjectsHistory(String.valueOf(temp), "temp", stopTime, objectToRecord);
            } else if (temp >= maxTemp && messageTime.before(stopTime)) {
                ovenIncreaseHistory = new ObjectsHistory(String.valueOf(maxTemp), "temp", messageTime, objectToRecord);
            } else {
                ovenIncreaseHistory = new ObjectsHistory(String.valueOf(maxTemp), "temp", stopTime, objectToRecord);
            }

            ovenHistories.add(ovenIncreaseHistory);
        }

        while(temp > 0 && messageTime.before(endTime)){
            cal.setTime(messageTime);
            cal.add(Calendar.MINUTE, 10);
            messageTime = new Timestamp(cal.getTimeInMillis());
            temp = temp - randomTemp;
            ObjectsHistory ovenDecreaseHistory = new ObjectsHistory();

            if(temp > 0 && messageTime.before(endTime)){
                ovenDecreaseHistory = new ObjectsHistory(String.valueOf(temp), "temp", messageTime, objectToRecord);
            } else if (temp <= 0 && messageTime.before(endTime)) {
                ovenDecreaseHistory = new ObjectsHistory("0", "temp", messageTime, objectToRecord);
                temp = 0;
            } else {
                ovenDecreaseHistory = new ObjectsHistory("0", "temp", stopTime, objectToRecord);
            }

            ovenHistories.add(ovenDecreaseHistory);
        }

        return ovenHistories;
    }

    public  List<ObjectsHistory> createHistoryErrors(Objects objectToRecord, String type, String parameter, Timestamp time){
        List<ObjectsHistory> historiesError = new ArrayList<ObjectsHistory>();
        switch (type){
            case "power":
                Date lastDate = new Date(time.getTime());
                lastDate.setHours(time.getHours() + parseInt(parameter));
                Timestamp lastTimestamp = new Timestamp(lastDate.getTime());

                ObjectsHistory messageRecordOn = new ObjectsHistory("off", "power", lastTimestamp, objectToRecord);
                ObjectsHistory messageRecordOff = new ObjectsHistory("on", "power", time, objectToRecord);
                historiesError.add(messageRecordOn);
                historiesError.add(messageRecordOff);
            break;

            case "nightAlarm":
                Date nextAlarm = new Date(time.getTime());
                nextAlarm.setHours(1);
                Timestamp nextAlarmTimestamp = new Timestamp(nextAlarm.getTime());

                ObjectsHistory messageRecordAlarm = new ObjectsHistory(nextAlarmTimestamp.toString(), "alarm", time, objectToRecord);
                historiesError.add(messageRecordAlarm);
                break;

            case "nightShutter":
                Date nightShutterOpenAlarm = new Date(time.getTime());
                nightShutterOpenAlarm.setHours(2);
                Timestamp nightShutterOpenAlarmTimestamp = new Timestamp(nightShutterOpenAlarm.getTime());

                Date nightShutterCloseAlarm = new Date(time.getTime());
                nightShutterCloseAlarm.setHours(3);
                Timestamp nightShutterCloseAlarmTimestamp = new Timestamp(nightShutterCloseAlarm.getTime());

                ObjectsHistory messageOpenShutter = new ObjectsHistory("open", "action", nightShutterOpenAlarmTimestamp, objectToRecord);
                ObjectsHistory messageCloseShutter = new ObjectsHistory("close", "action", nightShutterCloseAlarmTimestamp, objectToRecord);

                historiesError.add(messageOpenShutter);
                historiesError.add(messageCloseShutter);
                break;
            case "shutterAlarm":
                Date lastClosing = new Date(time.getTime());

                lastClosing.setHours(time.getHours() + parseInt(parameter));
                Timestamp lastNightOpeningTimestamp = new Timestamp(lastClosing.getTime());

                ObjectsHistory messageOpen = new ObjectsHistory("close", "action", lastNightOpeningTimestamp, objectToRecord);
                ObjectsHistory messageClose = new ObjectsHistory("open", "action", time, objectToRecord);
                historiesError.add(messageOpen);
                historiesError.add(messageClose);
                break;
            default:
                break;

        }

        return historiesError;
    }
}
