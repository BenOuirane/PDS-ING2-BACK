package com.application.aled.service;

import com.application.aled.entity.Notification;
import com.application.aled.entity.StateType;
import com.application.aled.entity.User;

public interface NotificationService {
    Notification addNotification(Notification notification);

    Notification[] getNotifications(User receiver);

    Notification[] updateStateByReceiver(User receiver);

}
