package com.application.aled.repository.history;

import com.application.aled.entity.history.ShutterHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShutterHistoryRepository extends JpaRepository<ShutterHistory,Long> {
    @Override
    void deleteAll();
}

