package com.application.aled.repository.history;

import com.application.aled.entity.history.CoffeeMachineHistory;
import com.application.aled.entity.history.ShutterHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoffeeMachineHistoryRepository extends JpaRepository<CoffeeMachineHistory,Long> {
    @Override
    void deleteAll();

    List<CoffeeMachineHistory> findByObject_Id(long id);
}

