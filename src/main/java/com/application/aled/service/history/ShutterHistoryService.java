package com.application.aled.service.history;

import com.application.aled.entity.history.OvenHistory;
import com.application.aled.entity.history.ShutterHistory;

import java.sql.Timestamp;
import java.util.List;

public interface ShutterHistoryService {

    public ShutterHistory addHistory(ShutterHistory shutterHistory);

    public void emptyTable();

    public List<ShutterHistory> getShutterHistoryByObjectsId(long id);

    public List<ShutterHistory> getShutterHistoryByObjectsIdAndColumnDataAndDateBetween(long id, String columnData, Timestamp start, Timestamp end);
}
