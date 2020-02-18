package com.application.aled.service.history;

import com.application.aled.entity.history.AlarmClockHistory;

public interface AlarmClockHistoryService {

    public AlarmClockHistory addHistory(AlarmClockHistory alarmClockHistory);

    public void emptyTable();
}
