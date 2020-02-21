package com.application.aled.controller;

import com.application.aled.entity.Services;
import com.application.aled.repository.ServicesRepository;
import com.application.aled.service.ServicesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ServicesController {

    @Autowired
    ServicesServiceImpl servicesService;

    @Autowired
    ServicesRepository servicesRepository;

    @GetMapping("/services")
    public List<Services> getAllServices() {
        System.out.println("Call getAllServices");
        List<Services> services = servicesService.getAllServices();

        return services;
    }

    @PutMapping(value = "/services/")
    public Services getService(String name) {
        System.out.println("Call getService");
        Services service = servicesRepository.findByName(name);

        return service;
    }

}
