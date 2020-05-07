package com.application.aled.service.history;

import com.application.aled.entity.history.OvenHistory;
import com.application.aled.entity.history.OvenHistory;
import com.application.aled.repository.history.OvenHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<OvenHistory> getOvenHistoryByObjectsId(long id) {
        List<OvenHistory> ovenHistories = new ArrayList<OvenHistory>();
        ovenHistoryRepository.findByObject_Id(id).forEach(ovenHistories::add);

        return ovenHistories;
    }

    @Override
    public List<OvenHistory> getOvenHistoryByObjectsIdAndColumnDataAndDateBetween(long id, String columnData, Timestamp start, Timestamp end) {
        List<OvenHistory> ovenHistory = new ArrayList<OvenHistory>();
        ovenHistoryRepository.findByObject_IdAndColumnDataAndMessageTimestampLessThanEqualAndMessageTimestampGreaterThanEqual(id, columnData,  start,  end).forEach(ovenHistory::add);

        return ovenHistory;
    }
}
