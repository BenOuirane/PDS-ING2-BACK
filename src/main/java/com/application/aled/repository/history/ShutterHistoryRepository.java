package com.application.aled.repository.history;

import com.application.aled.entity.history.LampHistory;
import com.application.aled.entity.history.OvenHistory;
import com.application.aled.entity.history.ShutterHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

public interface ShutterHistoryRepository extends JpaRepository<ShutterHistory,Long> {
    @Override
    void deleteAll();

    List<ShutterHistory> findByObject_Id(long id);
    List<ShutterHistory> findByObject_IdAndColumnDataAndMessageTimestampLessThanEqualAndMessageTimestampGreaterThanEqual(long id, String columnData, Timestamp start, Timestamp end);
}

