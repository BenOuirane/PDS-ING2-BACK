package com.application.aled.service.history;

import com.application.aled.entity.history.CoffeeMachineHistory;
import com.application.aled.entity.history.CoffeeMachineHistory;
import com.application.aled.entity.history.LampHistory;
import com.application.aled.repository.history.CoffeeMachineHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<CoffeeMachineHistory> getCoffeeMachineHistoryByObjectsId(long id) {
        List<CoffeeMachineHistory> coffeeMachineHistories = new ArrayList<CoffeeMachineHistory>();
        coffeeMachineHistoryRepository.findByObject_Id(id).forEach(coffeeMachineHistories::add);

        return coffeeMachineHistories;
    }

    @Override
    public List<CoffeeMachineHistory> getCoffeeMachineHistoryByObjectsIdAndColumnDataAndDateBetween(long id, String columnData, Timestamp start, Timestamp end) {
        List<CoffeeMachineHistory> coffeeMachineHistory = new ArrayList<CoffeeMachineHistory>();
        coffeeMachineHistoryRepository.findByObject_IdAndColumnDataAndMessageTimestampLessThanEqualAndMessageTimestampGreaterThanEqual(id, columnData,  start,  end).forEach(coffeeMachineHistory::add);

        return coffeeMachineHistory;
    }
}
