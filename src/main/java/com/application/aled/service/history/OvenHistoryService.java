package com.application.aled.service.history;

import com.application.aled.entity.history.OvenHistory;

public interface OvenHistoryService {

    public OvenHistory addHistory(OvenHistory ovenHistory);

    public void emptyTable();
}
