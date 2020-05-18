package com.application.aled.controller;

import com.application.aled.repository.AnnualSubscriptionRepository;
import com.application.aled.service.AnnualSubscriptionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RequestMapping("/subscription")
@RestController
public class AnnualSubscriptionController {

    @Autowired
    private AnnualSubscriptionServiceImpl annualSubscriptionService;


    public AnnualSubscriptionController(){

    }

    @GetMapping("/year")
    public int [] getSubscriptionByYear() {

        int [] annualsubscrition = annualSubscriptionService.getSubscriptionByYear();

        return annualsubscrition;
    }
}
