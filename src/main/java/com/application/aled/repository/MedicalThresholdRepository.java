package com.application.aled.repository;

import com.application.aled.entity.MedicalThreshold;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MedicalThresholdRepository extends JpaRepository<MedicalThreshold, Long> {

    @Query(value="Select mt.* FROM medical_threshold mt  INNER JOIN resident r on mt.resident_id = r.id_resident " +
            "INNER JOIN medical_measurement_type mty on mt.measurement_type_id =mty.id " +
            "WHERE r.id_resident = :resident_id AND mty.id = :measurementType_id", nativeQuery = true)
    public MedicalThreshold findByResidentAndMeasurementType(@Param("resident_id") Long residentId, @Param("measurementType_id") Long measurementTypeId);
}
