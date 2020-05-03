package com.application.aled.messages.history;

import com.application.aled.messages.WaitingTimeChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class WaitingTimeInitializer {


    @Autowired
    WaitingTimeChecker waitingTimeChecker;

    @PostConstruct
    public void startWaitingTime(){
        waitingTimeChecker.launchVerification();

    }
}
