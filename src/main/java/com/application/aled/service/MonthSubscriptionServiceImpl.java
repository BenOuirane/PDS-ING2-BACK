package com.application.aled.service;

import com.application.aled.repository.MonthSubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class MonthSubscriptionServiceImpl implements MonthSubscriptionService {

    @Autowired
    MonthSubscriptionRepository repository;
    Logger logger = Logger.getLogger("com.application.aled.service.MonthSubscriptionServiceImpl");

    @Override
    public int[] getSubscriptionByMonth(int year) {
        int[] mensualsubscription;
        mensualsubscription = repository.findSubscriptionByMonth(year);
        logger.info("getting all the mensual subscriptions for the year " + year);
        return mensualsubscription;
    }


}
