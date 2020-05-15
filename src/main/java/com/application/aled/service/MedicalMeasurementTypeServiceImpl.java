package com.application.aled.service;

import com.application.aled.entity.MedicalMeasurementType;
import com.application.aled.repository.MedicalMeasurementTypeRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;

@Service(value="medical_measurement_type_service")
public class MedicalMeasurementTypeServiceImpl implements MedicalMeasurementTypeService{

    @Resource // instanciation
    private MedicalMeasurementTypeRepository medicalMeasurementTypeRepository;

    @Override
    public Collection<MedicalMeasurementType> getAllMedicalMeasurementTypes() {
        return this.medicalMeasurementTypeRepository.findAll();
    }

    @Override
    public MedicalMeasurementType getMedicalMeasurementTypeById(long id) {
        return  this.medicalMeasurementTypeRepository.findById(id).get();
    }

    @Override
    public MedicalMeasurementType getMedicalMeasurementTypeByName(String name) {
        return this.medicalMeasurementTypeRepository.findByName(name).get();
    }

    @Override
    public MedicalMeasurementType createMedicalMeasurementType(MedicalMeasurementType medicalMeasurementType) {
        return this.medicalMeasurementTypeRepository.save(medicalMeasurementType);
    }

    @Override
    public MedicalMeasurementType updateMedicalMeasurementType(MedicalMeasurementType medicalMeasurementType) {
        return this.medicalMeasurementTypeRepository.save(medicalMeasurementType);
    }

    @Override
    public void deleteMedicalMeasurementType(Long id) {
        this.medicalMeasurementTypeRepository.deleteById(id);
    }
}
