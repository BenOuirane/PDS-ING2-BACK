package com.application.aled.service;

import com.application.aled.controller.exception.CustomHandler;
import com.application.aled.entity.Notification;
import com.application.aled.entity.User;
import com.application.aled.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.logging.Logger;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    NotificationRepository repository;

    Logger logger = Logger.getLogger("com.application.aled.service.NotificationServiceImpl");

    @Override
    public Notification addNotification(Notification notification) {
        logger.info("Adding notification : " + notification.toString());

        Notification _notification = new Notification();

        _notification.setState("PENDING");
        _notification.setMessage(notification.getMessage());
        _notification.setTitle(notification.getTitle());
        _notification.setReceiver(notification.getReceiver());
        _notification.setSender(notification.getSender());
        _notification.setType(notification.getType());
        _notification.setCustomData(notification.getCustomData());

        repository.save(_notification);

        return _notification;
    }

    @Override
    public Notification[] getNotifications(User receiver) {
        logger.info("Getting notifications of : " + receiver);

        Notification[] _notifications = repository.findByReceiverOrderByDateDesc(receiver);

        return _notifications;
    }

    @Override
    public Notification[] updateStateByReceiver(User receiver) {
        logger.info("Updating state to 'SEEN' for the notifications of : " + receiver);

        Notification[] notificationFound =  repository.findByStateAndReceiver("PENDING", receiver);

        for (Notification notification : notificationFound) {
            notification.setState("SEEN");
            repository.save(notification);
        }

        return notificationFound;
    }
}
