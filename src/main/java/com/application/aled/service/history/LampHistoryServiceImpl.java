package com.application.aled.service.history;

import com.application.aled.entity.history.LampHistory;
import com.application.aled.repository.history.LampHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LampHistoryServiceImpl implements LampHistoryService {

    @Autowired
    private LampHistoryRepository lampHistoryRepository;

    @Override
    public LampHistory addHistory(LampHistory lampHistory) {
        LampHistory lampRecord = lampHistoryRepository.save(lampHistory);

        return lampRecord;
    }

    @Override
    public void emptyTable() {
        lampHistoryRepository.deleteAll();
    }
}
