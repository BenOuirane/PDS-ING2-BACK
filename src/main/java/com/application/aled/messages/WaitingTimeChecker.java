package com.application.aled.messages;

import com.application.aled.entity.Failure;
import com.application.aled.entity.Objects;
import com.application.aled.entity.history.*;
import com.application.aled.repository.MessageRepository;
import com.application.aled.repository.UserRepository;
import com.application.aled.service.FailureService;
import com.application.aled.service.MessageServiceImpl;
import com.application.aled.service.ObjectService;
import com.application.aled.service.UserService;
import com.application.aled.service.history.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@Component
public class WaitingTimeChecker {
    @Autowired
    MessageRepository messageRepository;
    @Autowired
    MessageServiceImpl messageService;
    @Autowired
    ObjectService objectService;
    @Autowired
    FailureService failureService;
    @Autowired
    LampHistoryService lampHistoryService;
    @Autowired
    OvenHistoryService ovenHistoryService;
    @Autowired
    CoffeeMachineHistoryService coffeeMachineHistoryService;
    @Autowired
    ShutterHistoryService shutterHistoryService;
    @Autowired
    AlarmClockHistoryService alarmClockHistoryService;


    Logger logger = Logger.getLogger("com.application.aled.messages.WaitingTimeChecker");

    @Async/*("threadPoolTaskExecutor")*/
    public void launchVerification(){
        while (true) {
            try {
                Thread.sleep(30000);
                logger.info("System starting check time for all objects ");

                //List<Message> messageList = messageService.getMessages();
                List<Objects> objectsList = objectService.getObjectByState(true);
                for (Objects objectToCheck : objectsList) {
                    Timestamp timestamp;
                    boolean timeRelevant = false;
                    timeRelevant = checkTime(objectToCheck);
                    if (!timeRelevant) {
                        Failure failure1 = new Failure("off", new Timestamp(System.currentTimeMillis()),null,objectToCheck);
                        failureService.addFailure(failure1);
                        objectToCheck.setState(false);
                        objectService.updateObjects(objectToCheck);
                        logger.warning("Object state set to off and failure registered");
                    }
                }


            } catch (InterruptedException e) {
                logger.severe("there is an error in thread.sleep during verification " + e.getMessage());
            }
        }
    }
    public boolean checkTime(Objects objects){
        Timestamp timestampCurrent = new Timestamp(System.currentTimeMillis());
        long longCurrent = timestampCurrent.getTime();
        long longLastMessage = 0;
        long secondsDifference;

        switch (objects.getObjectType()){


            case "OVEN":
                List<OvenHistory> ovenHistories = ovenHistoryService.getOvenHistoryByObjectsId(objects.getId());
                for(OvenHistory ovenHistory : ovenHistories) {                                                      //find more recent message
                    long longCheckMessage = ovenHistory.getMessageTimestamp().getTime();
                    longLastMessage = Math.max(longLastMessage, longCheckMessage);
                }
                secondsDifference = TimeUnit.MILLISECONDS.toSeconds(longCurrent -longLastMessage);
                logger.info("difference log = "+ secondsDifference);
                if (secondsDifference<60000) {
                    logger.info("time is relevant for " + objects.getObjectType() + " number " + objects.getId());
                    return true;
                }break;


            case "LAMP":
                List<LampHistory> lampHistories = lampHistoryService.getLampHistoryByObjectsId(objects.getId());
                for(LampHistory lampHistory : lampHistories) {                                                      //find more recent message
                    long longCheckMessage = lampHistory.getMessageTimestamp().getTime();
                    longLastMessage = Math.max(longLastMessage, longCheckMessage);
                }
                secondsDifference = TimeUnit.MILLISECONDS.toSeconds(longCurrent -longLastMessage);
                logger.info("difference log = "+ secondsDifference);
                if (secondsDifference<60000) {
                    logger.info("time is relevant for " + objects.getObjectType() + " number " + objects.getId());
                    return true;
                }break;


            case "COFFEEMACHINE":
                List<CoffeeMachineHistory> coffeeMachineHistories = coffeeMachineHistoryService.getCoffeeMachineHistoryByObjectsId(objects.getId());
                for(CoffeeMachineHistory coffeeMachineHistory : coffeeMachineHistories) {                                                      //find more recent message
                    long longCheckMessage = coffeeMachineHistory.getMessageTimestamp().getTime();
                    longLastMessage = Math.max(longLastMessage, longCheckMessage);
                }
                secondsDifference = TimeUnit.MILLISECONDS.toSeconds(longCurrent -longLastMessage);
                logger.info("difference log = "+ secondsDifference);
                if (secondsDifference<60000) {
                    logger.info("time is relevant for " + objects.getObjectType() + " number " + objects.getId());
                    return true;
                }break;


            case "SHUTTER":
                List<ShutterHistory> shutterHistories = shutterHistoryService.getShutterHistoryByObjectsId(objects.getId());
                for(ShutterHistory shutterHistory : shutterHistories) {                                                      //find more recent message
                    long longCheckMessage = shutterHistory.getMessageTimestamp().getTime();
                    longLastMessage = Math.max(longLastMessage, longCheckMessage);
                }
                secondsDifference = TimeUnit.MILLISECONDS.toSeconds(longCurrent -longLastMessage);
                logger.info("difference log = "+ secondsDifference);
                if (secondsDifference<60000) {
                    logger.info("time is relevant for " + objects.getObjectType() + " number " + objects.getId());
                    return true;
                }break;
            case "ALARMCLOCK":
                List<AlarmClockHistory> alarmClockHistories = alarmClockHistoryService.getAlarmClockHistoryByObjectsId(objects.getId());
                for(AlarmClockHistory alarmClockHistory : alarmClockHistories) {                                                      //find more recent message
                    long longCheckMessage = alarmClockHistory.getMessageTimestamp().getTime();
                    longLastMessage = Math.max(longLastMessage, longCheckMessage);
                }
                secondsDifference = TimeUnit.MILLISECONDS.toSeconds(longCurrent -longLastMessage);
                logger.info("difference log = "+ secondsDifference);
                if (secondsDifference<60000) {
                    logger.info("time is relevant for " + objects.getObjectType() + " number " + objects.getId());
                    return true;
                }break;
            default:
                logger.info("type is not relevant for "+ objects.getObjectType()+" number "+ objects.getId());
                return false;

        }
        logger.info("time is not relevant for "+ objects.getObjectType()+" number "+ objects.getId()+". Must register failure.");
        return false;


    }
}
