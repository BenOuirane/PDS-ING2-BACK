package com.application.aled.service.history;

import com.application.aled.entity.history.AlarmClockHistory;
import com.application.aled.entity.history.CoffeeMachineHistory;

import java.sql.Timestamp;
import java.util.List;

public interface AlarmClockHistoryService {

    public AlarmClockHistory addHistory(AlarmClockHistory alarmClockHistory);

    public void emptyTable();

    public List<AlarmClockHistory> getAlarmClockHistoryByObjectsId(long id);

    public List<AlarmClockHistory> getAlarmClockHistoryByObjectsIdAndColumnDataAndDateBetween(long id, String columnData, Timestamp start, Timestamp end);
}
