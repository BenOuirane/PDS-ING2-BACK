package com.application.aled.service;

import com.application.aled.entity.CoffeeMachine;
import com.application.aled.entity.Objects;
import com.application.aled.repository.CoffeeMachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class CoffeeMachineServiceImpl implements CoffeeMachineService {

    @Autowired
    CoffeeMachineRepository coffeeMachineRepository;

    Logger logger = Logger.getLogger("com.application.aled.service.CoffeeMachineServiceImpl");

    @Override
    public List<CoffeeMachine> getCoffeeMachine(Objects objects) {
        logger.info("Getting cofeeMachines for object : " + objects);
        List<CoffeeMachine> coffeeMachines = new ArrayList<>();
        coffeeMachineRepository.findAllByObjects(objects).forEach(coffeeMachines::add);
        return coffeeMachines;
    }
}
