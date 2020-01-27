package com.application.aled.service;

import com.application.aled.entity.Objects;
import com.application.aled.entity.Services;
import com.application.aled.entity.Subscription;
import com.application.aled.repository.ObjectRepository;
import com.application.aled.repository.ServicesRepository;
import com.application.aled.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    SubscriptionRepository subscriptionRepository;

    @Autowired
    ServicesRepository servicesRepository;

    @Autowired
    ObjectRepository objectRepository;

    @Override
    public Subscription getSubscription(String name) {
        Subscription subscription;
        subscription = subscriptionRepository.findByName(name);
        System.out.println("Subscription : " + subscription);
        return subscription;
    }

    @Override
    public List<Subscription> getAllSubscription() {
        List<Subscription> subscriptions = new ArrayList<Subscription>();
        subscriptionRepository.findAll().forEach(subscriptions::add);
        return subscriptions;
    }

    @Transactional
    public List<Subscription> getSubscriptionByService(Services service) {
        List<Subscription> subscriptions;
        Services serviceFound = servicesRepository.findByName(service.getName());
        subscriptions = subscriptionRepository.findByService(service);

        System.out.println("Subscription by service : " + subscriptions);
        return subscriptions;
    }

    @Transactional
    public List<Subscription> getSubscriptionByObject(Objects object) {
        List<Subscription> subscriptions;
        subscriptions = subscriptionRepository.findByObject(object);

        System.out.println("Subscription by service : " + subscriptions);
        return subscriptions;
    }

}
