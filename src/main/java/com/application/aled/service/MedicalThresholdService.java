package com.application.aled.service;

import com.application.aled.entity.MedicalThreshold;

import java.util.Collection;

public interface MedicalThresholdService {

    Collection<MedicalThreshold> getAllMedicalThresholds();
    MedicalThreshold getMedicalThresholdById(Long id);
    MedicalThreshold createMedicalThreshold(MedicalThreshold medicalThreshold);
    MedicalThreshold updateMedicalThreshold(MedicalThreshold medicalThreshold);
    void deleteMedicalThreshold(Long id);
}
