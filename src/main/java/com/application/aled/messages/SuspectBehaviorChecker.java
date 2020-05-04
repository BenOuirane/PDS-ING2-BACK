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
import java.util.Comparator;
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
        if(ovenHistories.size()>=1){
            int temperature = Integer.parseInt(ovenHistories.get(ovenHistories.size()-1).getData());
            if(temperature > 300)
                failureService.addFailure(new Failure("Temperature is too high", new Timestamp(System.currentTimeMillis()),null,objectToCheck));
            if(temperature < 10)
                failureService.addFailure(new Failure("Temperature is too high", new Timestamp(System.currentTimeMillis()),null,objectToCheck));
        }
        if(ovenHistories.size()>=2){
            int temperatureRecent = Integer.parseInt(ovenHistories.get(ovenHistories.size()-1).getData());
            int temperaturePast = Integer.parseInt(ovenHistories.get(ovenHistories.size()-2).getData());
            int temperatureDifference = Math.abs(temperaturePast - temperatureRecent);

            long longRecentDate = ovenHistories.get(ovenHistories.size()-1).getMessageTimestamp().getTime();
            long longRecentPast = ovenHistories.get(ovenHistories.size()-2).getMessageTimestamp().getTime();
            int secondDiff = (int) TimeUnit.MILLISECONDS.toSeconds(longRecentDate-longRecentPast);

            if(temperatureDifference/secondDiff > 0.5 )//TODO BLOCK MULTIPLE FAILURES
                failureService.addFailure(new Failure("Temperature change too quickly", new Timestamp(System.currentTimeMillis()),null,objectToCheck));

        }
    }
}
