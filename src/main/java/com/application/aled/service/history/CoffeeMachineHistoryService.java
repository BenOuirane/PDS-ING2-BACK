package com.application.aled.service.history;

import com.application.aled.entity.history.CoffeeMachineHistory;
import com.application.aled.entity.history.LampHistory;

import java.util.List;

public interface CoffeeMachineHistoryService {

    public CoffeeMachineHistory addHistory(CoffeeMachineHistory coffeeMachineHistory);

    public void emptyTable();

    public List<CoffeeMachineHistory> getCoffeeMachineHistoryByObjectsId(long id);
}
