package com.application.aled.service;

import com.application.aled.entity.Message;
import com.application.aled.entity.Objects;
import com.application.aled.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class MessageServiceImpl implements MessageService {

    /*
    We get a Message Repository attribute so we get all basic
    sql methods (findAll(), save()...)
    They will be our base for the rest of the service
     */
    @Autowired
    private MessageRepository repository;
    Logger logger = Logger.getLogger("com.application.aled.service.MessageService");
    /*
    Here we use the 'findAll()' to create a custom getUsers()
    for our application, our controllers
     */
    @Override
    public List<Message> getMessages() {
        logger.info("Get all messages...");
        List<Message> messages = new ArrayList<>();
        repository.findAll().forEach(messages::add);
        return messages;
    }

    public List<Message> getMessageByObject(Objects objects) throws NullPointerException {
        logger.info("Search message of a connected object");
        List<Message> messages = new ArrayList<>();
        //Message message = repository.findByObjects(objects);
        repository.findByObjects(objects).forEach(messages::add);
        return messages;
    }
}

