package com.application.aled.messages;

import com.application.aled.entity.Failure;
import com.application.aled.entity.Objects;
import com.application.aled.entity.history.OvenHistory;
import com.application.aled.service.FailureService;
import com.application.aled.service.ObjectService;
import com.application.aled.service.history.OvenHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@Component
public class SuspectBehaviorChecker {

    @Autowired
    OvenHistoryService ovenHistoryService;
    @Autowired
    ObjectService objectService;
    @Autowired
    FailureService failureService;
    Logger logger2 = Logger.getLogger("com.application.aled.messages.SuspectBehaviorChecker");


    @Async
    public void launchVerification(){
        Logger logger = Logger.getLogger("com.application.aled.messages.SuspectBehaviorChecker");

        try {
            Thread.sleep(15000);

            while (true){
                Thread.sleep(30000);
                logger.info("Starting SuspectBehavior algorithm");
                List<Objects> objectsList = objectService.getObjectByState(true);
                for (Objects objectToCheck : objectsList) {
                    switch (objectToCheck.getObjectType()){
                        case "OVEN":

                            checkOvenBehavior(objectToCheck);
                    }
                }

            }



        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    private void checkOvenBehavior(Objects objectToCheck) {
        //List<OvenHistory> ovenHistories = ovenHistoryService.getOvenHistoryByObjectsIdAndColumn_data(objectToCheck.getId(), "temperature");
        List<OvenHistory> ovenHistories1 = ovenHistoryService.getOvenHistoryByObjectsId(objectToCheck.getId());
        List<OvenHistory> ovenHistoriesTemperature = new ArrayList<>();
        for (OvenHistory ovenHistory: ovenHistories1) {
            if (ovenHistory.getColumnData().equals("temperature"))
                ovenHistoriesTemperature.add(ovenHistory);
        }



        ovenHistoriesTemperature.sort(Comparator.comparing(OvenHistory::getMessageTimestamp));



        if(ovenHistoriesTemperature.size()>=1){
            int temperature = Integer.parseInt(ovenHistoriesTemperature.get(ovenHistoriesTemperature.size()-1).getData());

            String answer = behaviorAnalyst(temperature);
            switch (answer){
                case "Temperature is too low":
                    if (!(messageAlreadyDetectedToday(objectToCheck, "Temperature is too low"))){
                        failureService.addFailure(new Failure("Temperature is too low", new Timestamp(System.currentTimeMillis()), null, objectToCheck));
                        logger2.info("Temperature is too low for the oven "+objectToCheck.getId());
                    } break;
                case "Temperature is too high":
                    if (!(messageAlreadyDetectedToday(objectToCheck, "Temperature is too high"))) {
                        failureService.addFailure(new Failure("Temperature is too high", new Timestamp(System.currentTimeMillis()), null, objectToCheck));
                        logger2.info("Temperature is too high for the oven "+objectToCheck.getId());
                    }break;
            }
        }
        if(ovenHistoriesTemperature.size()>=2){
            int temperatureRecent = Integer.parseInt(ovenHistoriesTemperature.get(ovenHistoriesTemperature.size()-1).getData());
            int temperaturePast = Integer.parseInt(ovenHistoriesTemperature.get(ovenHistoriesTemperature.size()-2).getData());
            int temperatureDifference = Math.abs(temperaturePast - temperatureRecent);

            long longRecentDate = ovenHistoriesTemperature.get(ovenHistoriesTemperature.size()-1).getMessageTimestamp().getTime();
            long longRecentPast = ovenHistoriesTemperature.get(ovenHistoriesTemperature.size()-2).getMessageTimestamp().getTime();
            int secondDiff = (int) TimeUnit.MILLISECONDS.toSeconds(longRecentDate-longRecentPast);


            boolean temperatureGrowTooFast = warmSpeedAnalyst(secondDiff,temperatureDifference);
            if(temperatureGrowTooFast) {

                if (!(messageAlreadyDetectedToday(objectToCheck, "Temperature change too quickly"))) {
                    failureService.addFailure(new Failure("Temperature change too quickly", new Timestamp(System.currentTimeMillis()), null, objectToCheck));
                    logger2.info("Temperature change too quickly for the oven " + objectToCheck.getId());

                }
            }

        }
    }

    public boolean messageAlreadyDetectedToday(Objects objectToCheck, String messageError){
        //yesterday date
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(System.currentTimeMillis()));
        calendar.add(Calendar.DATE, -1);
        Date yesterdayDate = calendar.getTime();
        Timestamp yesterdayTimestamp = new Timestamp(yesterdayDate.getTime());
        Failure moreRecentHighTemperatureFailure = failureService.getMoreRecentFailureByObjectAndColumnData(objectToCheck,messageError);

        if (moreRecentHighTemperatureFailure == null)
            return false;
        if (!(moreRecentHighTemperatureFailure.getEnd_date() == null)) {
            return false;
        }
        if (moreRecentHighTemperatureFailure.getBegin_date().after(yesterdayTimestamp)) {
            return true;
        }
        return false;
    }

    public String behaviorAnalyst(int temperature){
        if(temperature > 300) {
            return "Temperature is too high";
        }
        if (temperature < 10){
            return "Temperature is too low";
        }
        return "";
    }

    public boolean warmSpeedAnalyst(int secondDiff, int temperatureDifference){
        double secondDiffDouble = (double) secondDiff;
        double temperatureDifferenceDouble = (double) temperatureDifference;
        if(secondDiffDouble==0)
            return false;
        double warmSpeed = Math.abs(temperatureDifferenceDouble/secondDiffDouble);
        if(Math.abs(warmSpeed) > 0.5 )
            return true;
        return false;

    }
}
