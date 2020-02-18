package com.application.aled.service.history;

import com.application.aled.entity.history.CoffeeMachineHistory;

public interface CoffeeMachineHistoryService {

    public CoffeeMachineHistory addHistory(CoffeeMachineHistory coffeeMachineHistory);

    public void emptyTable();
}
