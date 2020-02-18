package com.application.aled.repository.history;

import com.application.aled.entity.history.CoffeeMachineHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeMachineHistoryRepository extends JpaRepository<CoffeeMachineHistory,Long> {
    @Override
    void deleteAll();
}

