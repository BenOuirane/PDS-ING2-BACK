package com.application.aled.messages.history;

import com.application.aled.entity.CoffeeMachine;
import com.application.aled.entity.history.AlarmClockHistory;
import com.application.aled.entity.history.CoffeeMachineHistory;
import com.application.aled.entity.history.ObjectsHistory;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static java.lang.Integer.parseInt;

public class ObjectHistoryVerification {

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");

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

        return maxHoursEntry.getKey();
    }

    /*
    Made to know if oven temperature was too high
     */
    public List<ObjectsHistory> tooHigh (List<ObjectsHistory> objectsHistoryList, int maxHours){
        for (ObjectsHistory objectsHistory : objectsHistoryList) {
            if(parseInt(objectsHistory.getData()) < maxHours) {
                objectsHistoryList.remove(objectsHistory);
            }
        }
        return objectsHistoryList;
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
