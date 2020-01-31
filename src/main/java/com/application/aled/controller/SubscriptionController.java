package com.application.aled.controller;

import com.application.aled.entity.Objects;
import com.application.aled.entity.Services;
import com.application.aled.entity.Subscription;
import com.application.aled.repository.SubscriptionRepository;
import com.application.aled.service.SubscriptionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class SubscriptionController {

    @Autowired
    SubscriptionServiceImpl subscriptionService;

    @GetMapping("/subscription")
    public List<Subscription> getAllSubscription() {
        System.out.println("Call getAllSubscription");
        List<Subscription> subscriptions = subscriptionService.getAllSubscription();

        return subscriptions;
    }

    @PutMapping("/subscriprion/list")
    public Subscription getSubscription(String name){
        System.out.println("Call getSubscription");
        Subscription subscription = subscriptionService.getSubscription(name);

        return subscription;
    }

    @PutMapping("/subscription/service")
    public List<Subscription> getSubscriptionByService(@RequestBody Services services){
        System.out.println("Call getSubscriptionByService");
        List<Subscription> subscriptions = subscriptionService.getSubscriptionByService(services);

        return subscriptions;
    }

    @PutMapping("/subscription/object")
    public List<Subscription> getSubscriptionByObject(@RequestBody Objects object){
        System.out.println("Call getSubscriptionByObject");
        List<Subscription> subscriptions = subscriptionService.getSubscriptionByObject(object);

        return subscriptions;
    }

}
