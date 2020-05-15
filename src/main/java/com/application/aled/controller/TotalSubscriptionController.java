package com.application.aled.controller;

import com.application.aled.repository.TotalSubscriptionRepository;
import com.application.aled.service.TotalSubscriptionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RequestMapping("/subscription")
@RestController
public class TotalSubscriptionController {

    @Autowired
    private TotalSubscriptionServiceImpl totalSubscriptionService;


    public TotalSubscriptionController(){

    }

    @GetMapping("/name")
    public int [] getSubscriptionByName(@RequestParam int year) {

        int [] totalsubscription = totalSubscriptionService.getSubscriptionByName(year);

        return totalsubscription;
    }

}
