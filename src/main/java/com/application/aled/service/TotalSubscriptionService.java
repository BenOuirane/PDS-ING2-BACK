package com.application.aled.service;

import org.springframework.stereotype.Service;

@Service
public interface TotalSubscriptionService {
    public int[]  getSubscriptionByName(int year);
}
