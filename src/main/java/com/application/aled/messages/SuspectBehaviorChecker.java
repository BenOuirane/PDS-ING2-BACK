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
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
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
                            checkOvenBehavior(objectToCheck );
                    }
                }

            }



        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    private void checkOvenBehavior(Objects objectToCheck) {
        List<OvenHistory> ovenHistories = ovenHistoryService.getOvenHistoryByObjectsIdAndColumn_data(objectToCheck.getId(), "temperature");
        ovenHistories.sort(Comparator.comparing(OvenHistory::getMessageTimestamp));
        Logger logger2 = Logger.getLogger("com.application.aled.messages.SuspectBehaviorChecker");



        if(ovenHistories.size()>=1){
            int temperature = Integer.parseInt(ovenHistories.get(ovenHistories.size()-1).getData());
            if(temperature > 300) {
                System.out.println("trop chaud");
                if (!(messageAlreadyDetectedToday(objectToCheck, "Temperature change too quickly"))) {
                    failureService.addFailure(new Failure("Temperature is too high", new Timestamp(System.currentTimeMillis()), null, objectToCheck));
                    logger2.info("Temperature is too high for the oven "+objectToCheck.getId());
                }
            }
            if(temperature < 10) {
                if (!(messageAlreadyDetectedToday(objectToCheck, "Temperature change too quickly"))){
                    failureService.addFailure(new Failure("Temperature is too low", new Timestamp(System.currentTimeMillis()), null, objectToCheck));
                    logger2.info("Temperature is too low for the oven "+objectToCheck.getId());

                }
            }
        }
        if(ovenHistories.size()>=2){
            int temperatureRecent = Integer.parseInt(ovenHistories.get(ovenHistories.size()-1).getData());
            int temperaturePast = Integer.parseInt(ovenHistories.get(ovenHistories.size()-2).getData());
            int temperatureDifference = Math.abs(temperaturePast - temperatureRecent);

            long longRecentDate = ovenHistories.get(ovenHistories.size()-1).getMessageTimestamp().getTime();
            long longRecentPast = ovenHistories.get(ovenHistories.size()-2).getMessageTimestamp().getTime();
            int secondDiff = (int) TimeUnit.MILLISECONDS.toSeconds(longRecentDate-longRecentPast);

            if(temperatureDifference/secondDiff > 0.5 ){

                if (!(messageAlreadyDetectedToday(objectToCheck, "Temperature change too quickly"))) {
                    failureService.addFailure(new Failure("Temperature change too quickly", new Timestamp(System.currentTimeMillis()), null, objectToCheck));
                    logger2.info("Temperature change too quickly for the oven "+objectToCheck.getId());

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
}
