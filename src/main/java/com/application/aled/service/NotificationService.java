package com.application.aled.service;

import com.application.aled.entity.Notification;
import com.application.aled.entity.StateType;
import com.application.aled.entity.User;

public interface NotificationService {
    Notification addNotification(Notification notification);

    Notification[] getNotifications(long receiver);

    void updateState(Notification notification);

}
