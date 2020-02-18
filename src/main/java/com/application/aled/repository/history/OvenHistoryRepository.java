package com.application.aled.repository.history;

import com.application.aled.entity.history.AlarmClockHistory;
import com.application.aled.entity.history.OvenHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OvenHistoryRepository extends JpaRepository<OvenHistory,Long> {
    @Override
    void deleteAll();
}

