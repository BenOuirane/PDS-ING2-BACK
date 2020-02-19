package com.application.aled.repository.history;

import com.application.aled.entity.history.LampHistory;
import com.application.aled.entity.history.ShutterHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShutterHistoryRepository extends JpaRepository<ShutterHistory,Long> {
    @Override
    void deleteAll();

    List<ShutterHistory> findByObject_Id(long id);
}

