package com.application.aled.messages.history;

import com.application.aled.entity.CoffeeMachine;
import com.application.aled.entity.history.*;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.time.temporal.ChronoUnit;

import static java.lang.Integer.parseInt;
import static java.time.temporal.ChronoUnit.DAYS;

public class ObjectHistoryVerification {

    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss yyyy.MM.dd");
    SimpleDateFormat parseTimestamp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");

    /*
    Made to know the favorite parameter for one element
    Tested with alarmClock
     */
    public String favoriteParameter (List<ObjectsHistory> objectsHistoryList) {
        Map<String, Integer>  objectParameters = new HashMap<String, Integer>();
        for (ObjectsHistory objectHistory: objectsHistoryList) {
            if(objectParameters.containsKey(objectHistory.getData())){
                objectParameters.replace(objectHistory.getData(), objectParameters.get(objectHistory.getData()) + 1);
            } else {
                objectParameters.put(objectHistory.getData(), 1);
            }
        }

        Map.Entry<String, Integer> maxHoursEntry = null;


        for (Map.Entry<String, Integer> entry : objectParameters.entrySet()) {
            if (maxHoursEntry == null || entry.getValue().compareTo(maxHoursEntry.getValue()) > 0) {
                maxHoursEntry = entry;
            }
        }

        if(maxHoursEntry == null){
            return "Aucune donnée";
        } else {
            return maxHoursEntry.getKey();
        }

    }

    /*
    Made to know if oven temperature was too high
     */
    public List<OvenHistory> tooHigh (List<OvenHistory> ovenHistoryList, int maxTemp){
        for (OvenHistory ovenHistory : ovenHistoryList) {
            if(parseInt(ovenHistory.getData()) < maxTemp) {
                ovenHistoryList.remove(ovenHistory);
            }
        }
        return ovenHistoryList;
    }

    /*
    Made to know if an alarm was set between 23 and 4 o'clock
     */
    public List<AlarmClockHistory> nightAlarm (List<AlarmClockHistory> alarmClockHistoryList){
        List<AlarmClockHistory> results = new ArrayList<AlarmClockHistory>();
        for (AlarmClockHistory alarmClockHistory : alarmClockHistoryList) {
            String alarmString = alarmClockHistory.getData();

            try {
                Date alarmDate = parseTimestamp.parse(alarmString);
                Timestamp alarmTimestamp = new Timestamp(alarmDate.getTime());

                Date after = new Date(alarmTimestamp.getTime());
                after.setHours(23);

                Date before = new Date(alarmTimestamp.getTime());
                before.setHours(4);

                if(alarmTimestamp.before(new Timestamp(before.getTime())) && alarmTimestamp.after(new Timestamp(after.getTime()-1*24*60*60*1000))){
                    results.add(alarmClockHistory);
                }

            } catch (ParseException e) {
                e.printStackTrace();
            }

        }

        return results;
    }

    /*
    Made to know if a shutter was open during many days or during night
     */
    public Map<List<String>, Integer> wronglyOpenedShutter (List<ShutterHistory> shutterHistoryList){
        Map<List<String>, Integer> badlyUsed = new HashMap<List<String>, Integer>();

        for (int i = 0; i < shutterHistoryList.size(); i++) {
            if(i < (shutterHistoryList.size() - 1)){
                if (!(shutterHistoryList.get(i).getColumnData().equals("action"))) {
                    shutterHistoryList.remove(shutterHistoryList.get(i));
                } else {
                    if (shutterHistoryList.get(i).getData().equals("open") && shutterHistoryList.get(i + 1).getData().equals("close")) {
                        Timestamp opened = shutterHistoryList.get(i).getMessageTimestamp();
                        Timestamp close = shutterHistoryList.get(i + 1).getMessageTimestamp();

                        long daysOn = (close.getTime() - opened.getTime()) / (24 * 60 * 60 * 1000);

                        List<String> timestampsToString = new ArrayList<String>(2);
                        timestampsToString.add(dateFormat.format(opened));
                        timestampsToString.add(dateFormat.format(close));


                        if(daysOn >= 1){
                            badlyUsed.put(timestampsToString, (int) daysOn);
                        } else {
                            Date afterOpening = new Date(opened.getTime());
                            afterOpening.setHours(0);

                            Date beforeOpening = new Date(opened.getTime());
                            beforeOpening.setHours(4);


                            if(opened.after(new Timestamp(afterOpening.getTime())) && opened.before(new Timestamp(beforeOpening.getTime()))){
                                badlyUsed.put(timestampsToString, (int) 0);
                            }
                        }
                        i++;
                    }
                }
            }
        }
        return badlyUsed;
    }

    /*
    Made to know how many capsules were brought on a period of time
     */
    public int capsulesBought (List<CoffeeMachineHistory> coffeeMachineHistoryList) {
        int numberOfCapsules = 0;
        for (CoffeeMachineHistory coffeeMachineHistory: coffeeMachineHistoryList) {
            numberOfCapsules = parseInt(coffeeMachineHistory.getData()) + numberOfCapsules;
        }
        return numberOfCapsules;
    }


    /*
    Made to know the time range for an object to be on "power"
    Testing with lamp
     */
    public ArrayList<Map<List<String>, Integer>> usingHours(List<ObjectsHistory> objectsHistories, int maxHours) {
        Map<List<String>, Integer> wellUsed = new HashMap<List<String>, Integer>();
        Map<List<String>, Integer> badlyUsed = new HashMap<List<String>, Integer>();

        ArrayList<Map<List<String>, Integer>> timeRanges = new ArrayList<Map<List<String>, Integer>>();

        for (int i = 0; i < objectsHistories.size(); i++) {
            if(i < (objectsHistories.size() - 1)){
                // Take of all elements that are not "power" messages
                if (!(objectsHistories.get(i).getColumnData().equals("power"))) {
                    objectsHistories.remove(objectsHistories.get(i));
                } else {
                    if (objectsHistories.get(i).getData().equals("on") && objectsHistories.get(i + 1).getData().equals("off")) {
                        Timestamp poweredOn = objectsHistories.get(i).getMessageTimestamp();
                        Timestamp poweredOff = objectsHistories.get(i + 1).getMessageTimestamp();

                        long hoursOn = (poweredOff.getTime() - poweredOn.getTime()) / (60 * 60 * 1000) % 24;

                        List<String> timestampsToString = new ArrayList<String>(2);
                        timestampsToString.add(dateFormat.format(poweredOn));
                        timestampsToString.add(dateFormat.format(poweredOff));

                        if (hoursOn >= maxHours) {
                            badlyUsed.put(timestampsToString, (int) hoursOn);
                        } else {
                            wellUsed.put(timestampsToString, (int) hoursOn);
                        }
                        i++;
                    }
                }
            }
        }

        timeRanges.add(wellUsed);
        timeRanges.add(badlyUsed);

        return timeRanges;
    }

}
