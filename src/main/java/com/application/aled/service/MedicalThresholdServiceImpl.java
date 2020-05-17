package com.application.aled.service;

import com.application.aled.entity.MedicalThreshold;
import com.application.aled.repository.MedicalThresholdRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;

@Service(value="medicalThresholdService")
public class MedicalThresholdServiceImpl implements MedicalThresholdService {

    @Resource
    private MedicalThresholdRepository medicalThresholdRepository;

    @Override
    public Collection<MedicalThreshold> getAllMedicalThresholds() {
        return this.medicalThresholdRepository.findAll();
    }

    @Override
    public MedicalThreshold getMedicalThresholdById(Long id) {
        return this.medicalThresholdRepository.findById(id).get();
    }

    @Override
    public MedicalThreshold createMedicalThreshold(MedicalThreshold medicalThreshold) {
        return this.medicalThresholdRepository.save(medicalThreshold);
    }

    @Override
    public MedicalThreshold updateMedicalThreshold(MedicalThreshold medicalThreshold) {
        return this.medicalThresholdRepository.save(medicalThreshold);
    }

    @Override
    public void deleteMedicalThreshold(Long id) {
        this.medicalThresholdRepository.deleteById(id);
    }
}
