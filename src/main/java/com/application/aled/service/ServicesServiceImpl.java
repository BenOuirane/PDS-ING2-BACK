package com.application.aled.service;

import com.application.aled.entity.Services;
import com.application.aled.repository.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ServicesServiceImpl implements ServicesService {

    @Autowired
    ServicesRepository servicesRepository;

    @Override
    public Services getService(String name) {
        Services service;
        service = servicesRepository.findByName(name);
        System.out.println("Service : " + service);
        return service;
    }

    @Override
    public List<Services> getAllServices() {
        List<Services> services = new ArrayList<Services>();
        servicesRepository.findAll().forEach(services::add);
        return services;
    }


}
