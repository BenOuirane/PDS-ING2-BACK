package com.application.aled.service;

import com.application.aled.entity.history.LampHistory;

public interface LampHistoryService {

    public LampHistory addHistory(LampHistory lampHistory);

    public void emptyTable();
}
