package com.application.aled.repository;

import com.application.aled.entity.CoffeeMachine;
import com.application.aled.entity.Objects;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CoffeeMachineRepository extends CrudRepository<CoffeeMachine, Long> {

    List<CoffeeMachine> findAllByObjects(Objects objects);
}
