package com.application.aled.service.history;

import com.application.aled.entity.history.ShutterHistory;

public interface ShutterHistoryService {

    public ShutterHistory addHistory(ShutterHistory shutterHistory);

    public void emptyTable();
}
