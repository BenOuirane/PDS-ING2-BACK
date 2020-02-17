package com.application.aled.messages.history;

import com.application.aled.entity.Objects;
import com.application.aled.entity.history.AlarmClockHistory;
import com.application.aled.entity.history.ObjectsHistory;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.*;

public class PopulateAlarmHistory {
    Random random = new Random();
    DecimalFormat df = new DecimalFormat("#.0");

    public List<AlarmClockHistory> createAlarmClockHistory(List<Objects> objectsList, Date date, int numberPerDayAndObject, int hourTopLimit, int hourBottomLimit) {
        PopulateObjectsHistory populateObjectsHistory = new PopulateObjectsHistory();
        List<ObjectsHistory> objectsHistoriesLampsMorning = populateObjectsHistory.setMessagesTimestamps(objectsList, date, numberPerDayAndObject, hourTopLimit, hourBottomLimit);

        List<AlarmClockHistory> alarmClockHistories = new ArrayList<AlarmClockHistory>();

        for (ObjectsHistory objectHisto : objectsHistoriesLampsMorning) {
            AlarmClockHistory alarmClockMessage;

            boolean randomBoolean = random.nextBoolean();
            double randomRadioStation = random.nextInt(110 - 90) + 90 * random.nextDouble();

            int randomHour = random.nextInt(9 - 6) + 6;

            if (randomBoolean){
                long plusADay = objectHisto.getMessageTimestamp().getTime()+1*24*60*60*1000;
                Timestamp alarm = new Timestamp(plusADay);

                alarm.setHours(randomHour);
                alarm.setMinutes(0);
                alarm.setSeconds(00);

                populateObjectsHistory.setMessageData(objectHisto, "alarm", alarm.toString());
            } else {
                populateObjectsHistory.setMessageData(objectHisto, "radio", String.valueOf(randomRadioStation));
            }

            alarmClockMessage = new AlarmClockHistory(objectHisto.getData(), objectHisto.getColumnData(), objectHisto.getMessageTimestamp(), objectHisto.getObject());
            //System.out.println(alarmClockMessage.toString());

            alarmClockHistories.add(alarmClockMessage);
        }

        alarmClockHistories.sort(Comparator.comparing(AlarmClockHistory::getMessageTimestamp));
        return alarmClockHistories;
    }
}
