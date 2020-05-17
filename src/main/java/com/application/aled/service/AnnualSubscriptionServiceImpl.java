<<<<<<< HEAD
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
=======
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
>>>>>>> 8d1da6dc7d21bfe8feb6c1f59c4d4d4e90d499cc
