package com.application.aled.service.history;

import com.application.aled.entity.history.AlarmClockHistory;
import com.application.aled.entity.history.CoffeeMachineHistory;
import com.application.aled.repository.history.AlarmClockHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class AlarmClockHistoryServiceImpl implements AlarmClockHistoryService {

    @Autowired
    private AlarmClockHistoryRepository alarmClockHistoryRepository;

    @Override
    public AlarmClockHistory addHistory(AlarmClockHistory alarmClockHistory) {
        AlarmClockHistory alarmClockRecord = alarmClockHistoryRepository.save(alarmClockHistory);

        return alarmClockRecord;
    }

    @Override
    public void emptyTable() {
        alarmClockHistoryRepository.deleteAll();
    }

    @Override
    public List<AlarmClockHistory> getAlarmClockHistoryByObjectsId(long id) {
        List<AlarmClockHistory> alarmClockHistory = new ArrayList<AlarmClockHistory>();
        alarmClockHistoryRepository.findByObject_Id(id).forEach(alarmClockHistory::add);

        return alarmClockHistory;
    }

    @Override
    public List<AlarmClockHistory> getAlarmClockHistoryByObjectsIdAndColumnDataAndDateBetween(long id, String columnData, Timestamp start, Timestamp end) {
        List<AlarmClockHistory> alarmClockHistory = new ArrayList<AlarmClockHistory>();
        alarmClockHistoryRepository.findByObject_IdAndColumnDataAndMessageTimestampLessThanEqualAndMessageTimestampGreaterThanEqual(id, columnData,  start,  end).forEach(alarmClockHistory::add);

        return alarmClockHistory;
    }
}
