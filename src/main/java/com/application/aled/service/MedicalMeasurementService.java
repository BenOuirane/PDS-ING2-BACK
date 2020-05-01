package com.application.aled.service;

import com.application.aled.entity.MedicalMeasurement;

import java.util.Collection;

public interface MedicalMeasurementService {

    Collection<MedicalMeasurement> getAllMedicalMeasurements();
    MedicalMeasurement getMedicalMeasurementById(Long id);
    MedicalMeasurement createMedicalMeasurement(MedicalMeasurement medicalMeasurement);
    MedicalMeasurement updateMedicalMeasurement(MedicalMeasurement medicalMeasurement);
    void deleteMedicalMeasurement(Long id);
    Collection<MedicalMeasurement> getMeasurementsByResidentAndMeasurementType(Long residentID,Long measurementTypeId);

}
