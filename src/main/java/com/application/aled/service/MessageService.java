package com.application.aled.service;

import com.application.aled.entity.Message;
import com.application.aled.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Here we have an interface with all of the methods that will
 * be implemented on our UserService
 */
@Service
public interface MessageService {

    public List<Message> getMessages();

    public Message mac_address(String mac_address); //TODO implement this method

}

