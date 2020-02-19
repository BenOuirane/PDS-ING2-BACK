package com.application.aled.messages;

import com.application.aled.entity.Message;
import com.application.aled.entity.Objects;
import com.application.aled.repository.LampRepository;
import com.application.aled.repository.MessageRepository;
import com.application.aled.service.MessageServiceImpl;
import com.application.aled.service.ObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@Configuration
public class WaitingTimeChecker {
    @Autowired
    MessageRepository messageRepository;
    @Autowired
    MessageServiceImpl messageService;
    @Autowired
    ObjectService objectService;
    /*@Autowired
    LampRepository lampRepository;*/
    Logger logger = Logger.getLogger("com.application.aled.messages.WaitingTimeChecker");

    @PostConstruct
    @Transactional
    public void launchVerification(){

        try {
            Thread.sleep(6000);
            logger.info("System starting check time for all objects ");

            //List<Message> messageList = messageService.getMessages();
            List<Objects> objectsList = objectService.getObjectByState(true);
            for (Objects objectToCheck: objectsList) {
                Timestamp timestamp;
                boolean timeRelevant = false;
                timeRelevant = checkTime(objectToCheck);
            }


        } catch (InterruptedException e) {
            logger.severe("there is an error in thread.sleep during verification "+e.getMessage());
        }
    }
    public boolean checkTime(Objects objects){
        Timestamp timestampCurrent = new Timestamp(System.currentTimeMillis());
        long longCurrent = timestampCurrent.getTime();
        /*List<Message> messageList = messageService.getMessages();
        Message message = messageList.get(messageList.size());
        Timestamp timestampLastMessage = message.getDateTime();

        long longLastMessage = timestampLastMessage.getTime();
        long longCurrent = timestampCurrent.getTime();
        long secondsDifference = TimeUnit.MILLISECONDS.toSeconds(longCurrent - longLastMessage);

         */
        switch (objects.getObjectType()){//TODO make other cases for each connected object
            /*case "OVEN":
                long longLastMessage = timestampLastMessage.getTime();
                long longCurrent = timestampCurrent.getTime();
                long longDifference = longCurrent - longLastMessage;
            */
            case "LAMP":
                //TODO lampHistoryRepository
                return true;
                /*if (secondsDifference<6000)
                    return true;*/
            default:
                return false;
        }

    }
}
