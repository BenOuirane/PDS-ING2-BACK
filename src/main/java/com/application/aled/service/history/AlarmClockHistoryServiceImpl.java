package com.application.aled.service.history;

import com.application.aled.entity.history.AlarmClockHistory;
import com.application.aled.repository.history.AlarmClockHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
