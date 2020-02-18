package com.application.aled.repository.history;

import com.application.aled.entity.Rooms;
import com.application.aled.entity.history.LampHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LampHistoryRepository extends JpaRepository<LampHistory,Long> {
    @Override
    void deleteAll();

    List<LampHistory> findByObject_Rooms(Rooms room);
}

