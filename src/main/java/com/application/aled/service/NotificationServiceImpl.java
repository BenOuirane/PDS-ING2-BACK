package com.application.aled.service;

import com.application.aled.controller.exception.CustomHandler;
import com.application.aled.entity.Notification;
import com.application.aled.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    NotificationRepository repository;

    @Override
    public Notification addNotification(Notification notification) {
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
    public Notification[] getNotifications(long receiver) {
        Notification[] _notifications = repository.findByReceiver(receiver);
        return _notifications;
    }

    @Override
    public Notification[] updateStateByReceiver(long receiver) {
        Notification[] notificationFound =  repository.findByStateAndReceiver("PENDING", receiver);

        for (Notification notification : notificationFound) {
            notification.setState("SEEN");
            repository.save(notification);
        }

        return notificationFound;
    }
}
