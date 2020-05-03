package com.application.aled.controller;

import com.application.aled.repository.MonthSubscriptionRepository;
import com.application.aled.service.MonthSubscriptionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RequestMapping("/subscription")
@RestController
public class MonthSubscriptionController {

    @Autowired
    private MonthSubscriptionServiceImpl monthSubscriptionService;

    public MonthSubscriptionController() {
    }

        @GetMapping("/month")
        public int [] getSubscriptionByMonth(@RequestParam int year) {

            int [] mensualsubscrition = monthSubscriptionService.getSubscriptionByMonth(year);

            return mensualsubscrition;
        }





}

