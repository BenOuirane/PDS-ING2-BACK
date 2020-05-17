package com.application.aled.repository;

import com.application.aled.entity.MedicalMeasurement;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalMeasurementRepository extends JpaRepository<MedicalMeasurement, Long> {

    @Query(value = "select meas.id from medical_measurement meas\r\n" +
            "inner join medical_measurement_type mty on meas.medical_measurement_type_id = mty.id\r\n" +
            "inner join bracelet br on meas.bracelet_id = br.id\r\n" +
            "inner join resident res on br.id_resident = res.id_resident\r\n" +
            "where mty.id = :measurementType_id\r\n" +
            "and res.id_resident = :resident_id\r\n" +
            "order by meas.date_and_time desc", nativeQuery = true)
    public List<Long> findLastsMeasuresByResidentAndMeasurementType(@Param("resident_id") Long residentId,
                                                                    @Param("measurementType_id") Long measurementTypeId,
                                                                    Pageable pageable);
}
