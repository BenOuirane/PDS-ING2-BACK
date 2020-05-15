package com.application.aled.service;

import com.application.aled.entity.Objects;
import com.application.aled.entity.Services;
import com.application.aled.entity.Subscription;

import java.util.List;

public interface SubscriptionService {

    Subscription getSubscription(String name);

    List<Subscription> getAllSubscription();

    List<Subscription> getSubscriptionByService(Services service);

    List<Subscription> getSubscriptionByObject(Objects object);

}
