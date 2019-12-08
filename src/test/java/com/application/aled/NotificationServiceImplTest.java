package com.application.aled;

import com.application.aled.controller.exception.CustomHandler;
import com.application.aled.entity.Notification;
import com.application.aled.entity.User;
import com.application.aled.repository.NotificationRepository;
import com.application.aled.repository.UserRepository;
import com.application.aled.service.NotificationServiceImpl;
import com.application.aled.service.UserServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class NotificationServiceImplTest {

    @Mock
    NotificationRepository repository;

    @InjectMocks
    NotificationServiceImpl notificationService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = CustomHandler.class)
    public void assertStateEnum() {
        Notification _notification = new Notification();
        _notification.setState("TOTO");
    }

    @Test(expected = CustomHandler.class)
    public void assertNotificationEnum() {
        Notification _notification = new Notification();
        _notification.setType("TOTO");
    }

}
