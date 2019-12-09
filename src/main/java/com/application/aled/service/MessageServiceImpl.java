package com.application.aled.service;

import com.application.aled.entity.Message;
import com.application.aled.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    /*
    We get a Message Repository attribute so we get all basic
    sql methods (findAll(), save()...)
    They will be our base for the rest of the service
     */
    @Autowired
    private MessageRepository repository;

    /*
    Here we use the 'findAll()' to create a custom getUsers()
    for our application, our controllers
     */
    @Override
    public List<Message> getMessages() {
        System.out.println("Get all messages...");

        List<Message> messages = new ArrayList<>();
        repository.findAll().forEach(messages::add);

        return messages;
    }
    public Message mac_address(String mac_address) throws NullPointerException {
        System.out.println("Search message of a mac address");

        Message message = repository.findByMacAddress(mac_address);

        return message;
    }
}

