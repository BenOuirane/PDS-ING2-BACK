package com.application.aled.service;

import com.application.aled.entity.Objects;
import com.application.aled.entity.Services;
import com.application.aled.entity.Subscription;
import com.application.aled.repository.ObjectRepository;
import com.application.aled.repository.ServicesRepository;
import com.application.aled.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    SubscriptionRepository subscriptionRepository;

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
        System.out.println("Finding subscriptions with service : " + service);
        List<Subscription> subscriptions = new ArrayList<>();
        subscriptionRepository.findByServices(service).forEach(subscriptions::add);

        System.out.println("Subscription by service : " + subscriptions);
        return subscriptions;
    }

    @Transactional
    public List<Subscription> getSubscriptionByObject(Objects object) {
        System.out.println("Finding subscriptions with object : " + object);
        List<Subscription> subscriptions = new ArrayList<>();
        subscriptionRepository.findByObjects(object).forEach(subscriptions::add);

        System.out.println("Subscription by object : " + subscriptions);
        return subscriptions;
    }

}
