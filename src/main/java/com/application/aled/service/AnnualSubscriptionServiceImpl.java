package com.application.aled.service;

import com.application.aled.repository.AnnualSubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class AnnualSubscriptionServiceImpl implements AnnualSubscriptionService {

    @Autowired
    AnnualSubscriptionRepository repository;
    Logger logger = Logger.getLogger("com.application.aled.service.AnnualSubscriptionServiceImpl");
    @Override
    public int[] getSubscriptionByYear() {
        int [] annualsubscription ;
        annualsubscription = repository.findSubscriptionByYear();
        logger.info("getting all the subscriptions by year ");
        return annualsubscription;
    }

}
