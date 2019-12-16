package com.application.aled.service;

import com.application.aled.controller.exception.CustomHandler;
import com.application.aled.entity.Notification;
import com.application.aled.entity.User;
import com.application.aled.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    NotificationRepository repository;

    @Override
    public Notification addNotification(Notification notification) {
        System.out.println("Adding notification : " + notification.toString());

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
        System.out.println("Getting notifications of : " + receiver);

        Notification[] _notifications = repository.findByReceiverOrderByDateDesc(receiver);

        return _notifications;
    }

    @Override
    public Notification[] updateStateByReceiver(User receiver) {
        System.out.println("Updating state to 'SEEN' for the notifications of : " + receiver);

        Notification[] notificationFound =  repository.findByStateAndReceiver("PENDING", receiver);

        for (Notification notification : notificationFound) {
            notification.setState("SEEN");
            repository.save(notification);
        }

        return notificationFound;
    }
}
