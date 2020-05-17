package com.application.aled.repository;

import com.application.aled.entity.MedicalMeasurementType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface MedicalMeasurementTypeRepository extends JpaRepository<MedicalMeasurementType, Long  > {

    Optional<MedicalMeasurementType> findByName(String name);
}