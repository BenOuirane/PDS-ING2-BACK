package com.application.aled.repository;

import com.application.aled.entity.MedicalMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalMeasurementRepository extends JpaRepository<MedicalMeasurement, Long> {

}
