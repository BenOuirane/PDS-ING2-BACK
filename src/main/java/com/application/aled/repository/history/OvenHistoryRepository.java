package com.application.aled.repository.history;

import com.application.aled.entity.history.AlarmClockHistory;
import com.application.aled.entity.history.CoffeeMachineHistory;
import com.application.aled.entity.history.OvenHistory;
import com.application.aled.entity.history.ShutterHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

public interface OvenHistoryRepository extends JpaRepository<OvenHistory,Long> {
    @Override
    void deleteAll();

    List<OvenHistory> findByObject_Id(long id);
    List<OvenHistory> findByObject_IdAndColumnDataAndMessageTimestampLessThanEqualAndMessageTimestampGreaterThanEqual(long id, String columnData, Timestamp start, Timestamp end);
}

