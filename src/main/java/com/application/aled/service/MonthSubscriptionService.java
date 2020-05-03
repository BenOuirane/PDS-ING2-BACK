package com.application.aled.service;

import org.springframework.stereotype.Service;

@Service
public interface MonthSubscriptionService {

    public int[]  getSubscriptionByMonth(int year);


}
