package com.application.aled.service;

import com.application.aled.entity.CoffeeMachine;
import com.application.aled.entity.Objects;

import java.util.List;

public interface CoffeeMachineService {
    List<CoffeeMachine> getCoffeeMachine(Objects objects);
    boolean updateCoffeeMachine(CoffeeMachine coffeeMachine);
    boolean makeCoffee(CoffeeMachine coffeeMachine);
}
