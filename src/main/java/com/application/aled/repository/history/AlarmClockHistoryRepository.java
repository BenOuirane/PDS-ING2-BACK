package com.application.aled.repository.history;

import com.application.aled.entity.history.AlarmClockHistory;
import com.application.aled.entity.history.ShutterHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

public interface AlarmClockHistoryRepository extends JpaRepository<AlarmClockHistory,Long> {
    @Override
    void deleteAll();

    List<AlarmClockHistory> findByObject_Id(long id);

    List<AlarmClockHistory> findByObject_IdAndColumnDataAndMessageTimestampLessThanEqualAndMessageTimestampGreaterThanEqual(long id, String columnData, Timestamp start, Timestamp end);
}

