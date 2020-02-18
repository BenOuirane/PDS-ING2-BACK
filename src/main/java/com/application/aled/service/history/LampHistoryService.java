package com.application.aled.service.history;

import com.application.aled.entity.Lamp;
import com.application.aled.entity.Rooms;
import com.application.aled.entity.history.LampHistory;

import java.util.List;

public interface LampHistoryService {

    public LampHistory addHistory(LampHistory lampHistory);

    public void emptyTable();

    public List<LampHistory> getLampHistoryByRoom(Rooms room);
}
