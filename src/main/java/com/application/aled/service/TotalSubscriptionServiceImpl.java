package com.application.aled.service;

import com.application.aled.repository.TotalSubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class TotalSubscriptionServiceImpl implements TotalSubscriptionService {
    @Autowired
    TotalSubscriptionRepository repository;
    Logger logger = Logger.getLogger("com.application.aled.service.TotalSubscriptionServiceImpl");
    @Override
    public int[] getSubscriptionByName(int year) {
        int [] totalsubscription ;
        totalsubscription = repository.findSubscriptionByName(year);
        logger.info("getting all the differents type of subscriptions for the year  " + year);
        return totalsubscription;
    }

}
