package com.application.aled.service.history;

import com.application.aled.entity.history.AlarmClockHistory;
import com.application.aled.entity.history.CoffeeMachineHistory;
import com.application.aled.entity.history.LampHistory;

import java.sql.Timestamp;
import java.util.List;

public interface CoffeeMachineHistoryService {

    public CoffeeMachineHistory addHistory(CoffeeMachineHistory coffeeMachineHistory);

    public void emptyTable();

    public List<CoffeeMachineHistory> getCoffeeMachineHistoryByObjectsId(long id);

    public List<CoffeeMachineHistory> getCoffeeMachineHistoryByObjectsIdAndColumnDataAndDateBetween(long id, String columnData, Timestamp start, Timestamp end) ;
}
