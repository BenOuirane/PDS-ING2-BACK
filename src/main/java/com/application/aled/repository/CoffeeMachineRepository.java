package com.application.aled.repository;

import com.application.aled.entity.CoffeeMachine;
import com.application.aled.entity.Objects;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CoffeeMachineRepository extends CrudRepository<CoffeeMachine, Long> {

    List<CoffeeMachine> findAllByObjects(Objects objects);
}
