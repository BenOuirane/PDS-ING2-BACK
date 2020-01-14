package com.application.aled.repository;

import com.application.aled.entity.MedicalMeasurementType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedicalMeasurementTypeRepository extends JpaRepository<MedicalMeasurementType, Long  > {

    Optional<MedicalMeasurementType> findByName(String name);
}