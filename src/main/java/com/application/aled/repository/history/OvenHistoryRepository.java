package com.application.aled.repository.history;

import com.application.aled.entity.history.AlarmClockHistory;
import com.application.aled.entity.history.OvenHistory;
import com.application.aled.entity.history.ShutterHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OvenHistoryRepository extends JpaRepository<OvenHistory,Long> {
    @Override
    void deleteAll();
    List<OvenHistory> findOvenHistoriesByIdAndColumnData(long id, String columnData);
    List<OvenHistory> findByObject_Id(long id);
}

