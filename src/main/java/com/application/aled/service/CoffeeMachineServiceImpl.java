package com.application.aled.service;

import com.application.aled.entity.CoffeeMachine;
import com.application.aled.entity.Objects;
import com.application.aled.repository.CoffeeMachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoffeeMachineServiceImpl implements CoffeeMachineService {

    @Autowired
    CoffeeMachineRepository coffeeMachineRepository;

    @Override
    public List<CoffeeMachine> getCoffeeMachine(Objects objects) {
        System.out.println("Getting cofeeMachines for object : " + objects);
        List<CoffeeMachine> coffeeMachines = new ArrayList<>();
        coffeeMachineRepository.findAllByObjects(objects).forEach(coffeeMachines::add);
        return coffeeMachines;
    }
}
