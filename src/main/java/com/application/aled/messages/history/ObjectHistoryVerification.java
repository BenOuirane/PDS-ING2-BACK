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

        Map.Entry<String, Integer> maxEntry = null;


        for (Map.Entry<String, Integer> entry : objectParameters.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }

        return maxEntry.getKey();
    }

    /*
    Made to know if oven temperature was too high
     */
    public List<ObjectsHistory> tooHigh (List<ObjectsHistory> objectsHistoryList, int max){
        for (ObjectsHistory objectsHistory : objectsHistoryList) {
            if(parseInt(objectsHistory.getData()) < max) {
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
    Made to know the number of on hours for an object TODO
     */
    public ArrayList<Map<String[], Integer>> usingHours(List<ObjectsHistory> objectsHistories, int max) {
        Map<String[], Integer> wellUsed = new HashMap<String[], Integer>();
        Map<String[], Integer> badlyUsed = new HashMap<String[], Integer>();
        ArrayList<Map<String[], Integer>> datas = new ArrayList<Map<String[], Integer>>();

        String[] timestampsToString = new String[2];

        for (int i = 0; i < objectsHistories.size(); i++) {
            if(i <  (objectsHistories.size() - 1)){
                if (!(objectsHistories.get(i).getColumnData().equals("power"))) {
                    objectsHistories.remove(objectsHistories.get(i));
                } else {

                    if (objectsHistories.get(i).getData().equals("on") && objectsHistories.get(i + 1).getData().equals("off")) {
                        Timestamp poweredOn = objectsHistories.get(i).getMessageTimestamp();
                        Timestamp poweredOff = objectsHistories.get(i + 1).getMessageTimestamp();

                        long numberOfHours = (poweredOff.getTime() - poweredOn.getTime()) / (60 * 60 * 1000) % 24;

                        timestampsToString[0] = dateFormat.format(poweredOn);
                        timestampsToString[1] = dateFormat.format(poweredOff);

                        if (numberOfHours >= max) {
                            badlyUsed.put(timestampsToString, (int) numberOfHours);
                        } else {
                            wellUsed.put(timestampsToString, (int) numberOfHours);
                        }
                        i++;
                    }
                }
            }
        }

        datas.add(wellUsed);
        datas.add(badlyUsed);

        return datas;
    }

}
