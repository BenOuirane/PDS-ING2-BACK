package com.application.aled.service.history;

import com.application.aled.entity.history.ShutterHistory;
import com.application.aled.entity.history.OvenHistory;
import com.application.aled.entity.history.ShutterHistory;
import com.application.aled.repository.history.ShutterHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShutterHistoryServiceImpl implements ShutterHistoryService {

    @Autowired
    private ShutterHistoryRepository shutterHistoryRepository;

    @Override
    public ShutterHistory addHistory(ShutterHistory shutterHistory) {
        ShutterHistory shutterRecord = shutterHistoryRepository.save(shutterHistory);

        return shutterRecord;
    }

    @Override
    public void emptyTable() {
        shutterHistoryRepository.deleteAll();
    }

    @Override
    public List<ShutterHistory> getShutterHistoryByObjectsId(long id) {
        List<ShutterHistory> shutterHistories = new ArrayList<ShutterHistory>();
        shutterHistoryRepository.findByObject_Id(id).forEach(shutterHistories::add);

        return shutterHistories;
    }

    @Override
    public List<ShutterHistory> getShutterHistoryByObjectsIdAndColumnDataAndDateBetween(long id, String columnData, Timestamp start, Timestamp end) {
        List<ShutterHistory> shutterHistory = new ArrayList<ShutterHistory>();
        shutterHistoryRepository.findByObject_IdAndColumnDataAndMessageTimestampLessThanEqualAndMessageTimestampGreaterThanEqual(id, columnData,  start,  end).forEach(shutterHistory::add);

        return shutterHistory;
    }
}
