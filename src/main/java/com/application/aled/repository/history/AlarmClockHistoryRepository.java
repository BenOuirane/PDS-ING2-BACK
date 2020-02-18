package com.application.aled.repository.history;

import com.application.aled.entity.history.AlarmClockHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlarmClockHistoryRepository extends JpaRepository<AlarmClockHistory,Long> {
    @Override
    void deleteAll();
}

