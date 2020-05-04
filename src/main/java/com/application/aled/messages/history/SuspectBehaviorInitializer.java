package com.application.aled.messages.history;

import com.application.aled.messages.SuspectBehaviorChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SuspectBehaviorInitializer {
    @Autowired
    SuspectBehaviorChecker suspectBehaviorChecker;

    @PostConstruct
    public void startWaitingTime(){
        suspectBehaviorChecker.launchVerification();

    }
}
