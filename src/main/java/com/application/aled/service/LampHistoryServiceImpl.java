package com.application.aled.service;

import com.application.aled.entity.history.LampHistory;
import com.application.aled.repository.LampHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LampHistoryServiceImpl implements LampHistoryService {

    @Autowired
    private LampHistoryRepository lampHistoryRepository;

    @Override
    public LampHistory addHistory(LampHistory lampHistory) {
        LampHistory LH = lampHistoryRepository.save(lampHistory);

        return LH;
    }

    @Override
    public void emptyTable() {
        lampHistoryRepository.deleteAll();
    }
}
