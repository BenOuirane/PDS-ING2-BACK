package com.application.aled.repository;

import com.application.aled.entity.MedicalFolder;
import com.application.aled.entity.history.LampHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LampHistoryRepository extends JpaRepository<LampHistory,Long> {
    @Override
    void deleteAll();
}

