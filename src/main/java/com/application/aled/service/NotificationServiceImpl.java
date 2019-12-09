package com.application.aled.service;

import com.application.aled.controller.exception.CustomHandler;
import com.application.aled.entity.Notification;
import com.application.aled.entity.StateType;
import com.application.aled.entity.User;
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

        repository.save(_notification);

        return _notification;
    }

    @Override
    public Notification[] getNotifications(long receiver) {
        Notification[] _notifications = repository.findByReceiver(receiver);
        return _notifications;
    }

    @Override
    public void updateState(Notification notification) {
        Notification notificationFound =  repository.findById(notification.getId())
                .orElseThrow(() -> new CustomHandler("Notification not found"));

        notificationFound.setState("SEND");

        repository.save(notificationFound);

    }
}
