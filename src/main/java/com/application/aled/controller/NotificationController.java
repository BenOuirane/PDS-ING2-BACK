package com.application.aled.controller;

import com.application.aled.entity.Notification;
import com.application.aled.entity.User;
import com.application.aled.repository.NotificationRepository;
import com.application.aled.service.NotificationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class NotificationController {

    @Autowired
    NotificationServiceImpl notificationService;

    @PutMapping("/notification/create")
    public Notification createNotification(@RequestBody Notification notification){

        Notification _notification = notificationService.addNotification(notification);

        return _notification;
    }

    @PutMapping("/notifications/list")
    public Notification[] getNotification(@RequestBody long userId){

        Notification[] _notifications = notificationService.getNotifications(userId);

        return _notifications;
    }

    @PutMapping("/notifications/update")
    public Notification[] updateNotificationState(@RequestBody long userId){

        Notification[] _notifications = notificationService.updateStateByReceiver(userId);

        return _notifications;
    }

}
