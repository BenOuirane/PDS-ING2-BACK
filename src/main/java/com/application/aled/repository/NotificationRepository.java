package com.application.aled.repository;

import com.application.aled.entity.Notification;
import com.application.aled.entity.StateType;
import com.application.aled.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface NotificationRepository extends CrudRepository<Notification, Long> {

    Notification[] findByReceiverOrderByDateDesc(User receiver);

    Notification[] findByStateAndReceiver(String state, User receiver);

}
