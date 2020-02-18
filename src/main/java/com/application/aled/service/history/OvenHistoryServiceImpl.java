package com.application.aled.service.history;

import com.application.aled.entity.history.OvenHistory;
import com.application.aled.repository.history.OvenHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OvenHistoryServiceImpl implements OvenHistoryService {

    @Autowired
    private OvenHistoryRepository ovenHistoryRepository;

    @Override
    public OvenHistory addHistory(OvenHistory ovenHistory) {
        OvenHistory ovenRecord = ovenHistoryRepository.save(ovenHistory);

        return ovenRecord;
    }

    @Override
    public void emptyTable() {
        ovenHistoryRepository.deleteAll();
    }
}
