package com.application.aled.messages;

import com.application.aled.entity.Message;
import com.application.aled.entity.Objects;
import com.application.aled.repository.MessageRepository;
import com.application.aled.service.MessageServiceImpl;
import com.application.aled.service.ObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.logging.Logger;

@Configuration
public class WaitingTimeChecker {
    @Autowired
    MessageRepository messageRepository;
    @Autowired
    MessageServiceImpl messageService;
    @Autowired
    ObjectService objectService;
    Logger logger = Logger.getLogger("com.application.aled.messages.WaitingTimeChecker");

    @PostConstruct
    @Transactional
    public void lauchVerification(){

        try {
            Thread.sleep(6000);
            logger.info("System starting check time for all objects ");

            List<Message> messageList = messageService.getMessages();
            List<Objects> objectsList = objectService.getObjectByState(true);
        } catch (InterruptedException e) {
            logger.severe("there is an error in thread.sleep during verification "+e.getMessage());
        }
    }
    public boolean checkTime(Message message, Objects objects){
        return true;
    }
}
