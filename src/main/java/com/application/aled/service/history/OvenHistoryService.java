package com.application.aled.service.history;

import com.application.aled.entity.history.AlarmClockHistory;
import com.application.aled.entity.history.OvenHistory;

import java.util.List;

public interface OvenHistoryService {

    public OvenHistory addHistory(OvenHistory ovenHistory);

    public void emptyTable();

    public List<OvenHistory> getOvenHistoryByObjectsId(long id);

    public List<OvenHistory> getOvenHistoryByObjectsIdAndColumn_data(long id, String column_data);
}
