package com.application.aled.controller;

import com.application.aled.entity.Notification;
import com.application.aled.entity.User;
import com.application.aled.repository.NotificationRepository;
import com.application.aled.service.NotificationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class NotificationController {

    @Autowired
    NotificationServiceImpl notificationService;

    Logger logger = Logger.getLogger("com.application.aled.controller.NotificationController");

    @PutMapping("/notification/create")
    public Notification createNotification(@RequestBody Notification notification){
        logger.info("Call createNotification");

        Notification _notification = notificationService.addNotification(notification);

        return _notification;
    }

    @PutMapping("/notifications/list")
    public Notification[] getNotification(@RequestBody User user){
        logger.info("Call getNotification");

        Notification[] _notifications = notificationService.getNotifications(user);

        return _notifications;
    }

    @PutMapping("/notifications/update")
    public Notification[] updateNotificationsState(@RequestBody User user){
        logger.info("Call updateNotificationState");

        Notification[] _notifications = notificationService.updateStateByReceiver(user);

        return _notifications;
    }

}
