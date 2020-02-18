package com.application.aled.service.history;

import com.application.aled.entity.history.CoffeeMachineHistory;
import com.application.aled.repository.history.CoffeeMachineHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoffeeMachineHistoryServiceImpl implements CoffeeMachineHistoryService {

    @Autowired
    private CoffeeMachineHistoryRepository coffeeMachineHistoryRepository;

    @Override
    public CoffeeMachineHistory addHistory(CoffeeMachineHistory coffeeMachineHistory) {
        CoffeeMachineHistory coffeeMachineRecord = coffeeMachineHistoryRepository.save(coffeeMachineHistory);

        return coffeeMachineRecord;
    }

    @Override
    public void emptyTable() {
        coffeeMachineHistoryRepository.deleteAll();
    }
}
