package com.application.aled.service;

import com.application.aled.entity.MedicalMeasurement;
import com.application.aled.repository.MedicalMeasurementRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;

@Service(value="medical_measurement_service")
public class MedicalMeasurementServiceImpl implements MedicalMeasurementService{

    @Resource
    private MedicalMeasurementRepository medicalMeasurementRepository;

    @Override
    public Collection<MedicalMeasurement> getAllMedicalMeasurements() {
        return this.medicalMeasurementRepository.findAll();
    }

    @Override
    public MedicalMeasurement getMedicalMeasurementById(Long id) {
        return this.medicalMeasurementRepository.findById(id).get();
    }

    @Override
    public MedicalMeasurement createMedicalMeasurement(MedicalMeasurement medicalMeasurement) {
        return this.medicalMeasurementRepository.save(medicalMeasurement);
    }

    @Override
    public MedicalMeasurement updateMedicalMeasurement(MedicalMeasurement medicalMeasurement) {
        return this.medicalMeasurementRepository.save(medicalMeasurement);
    }

    @Override
    public void deleteMedicalMeasurement(Long id) {
        this.medicalMeasurementRepository.deleteById(id);
    }
}
