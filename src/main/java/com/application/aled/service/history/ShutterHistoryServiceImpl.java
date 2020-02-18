package com.application.aled.service.history;

import com.application.aled.entity.history.ShutterHistory;
import com.application.aled.repository.history.ShutterHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
