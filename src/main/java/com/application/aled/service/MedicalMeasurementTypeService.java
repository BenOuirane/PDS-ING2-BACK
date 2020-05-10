package com.application.aled.service;

import com.application.aled.entity.MedicalMeasurementType;

import java.util.Collection;

public interface MedicalMeasurementTypeService {

    Collection<MedicalMeasurementType> getAllMedicalMeasurementTypes();
    MedicalMeasurementType getMedicalMeasurementTypeById (long id);
    MedicalMeasurementType getMedicalMeasurementTypeByName(String name);
    MedicalMeasurementType createMedicalMeasurementType(MedicalMeasurementType medicalMeasurementType);
    MedicalMeasurementType updateMedicalMeasurementType(MedicalMeasurementType medicalMeasurementType);
    void deleteMedicalMeasurementType(Long id);
}
