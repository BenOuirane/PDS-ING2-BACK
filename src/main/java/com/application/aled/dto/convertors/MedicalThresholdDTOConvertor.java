package com.application.aled.dto.convertors;

import com.application.aled.dto.MedicalThresholdDTO;
import com.application.aled.entity.MedicalMeasurementType;
import com.application.aled.entity.MedicalThreshold;
import com.application.aled.entity.Resident;
import com.application.aled.service.MedicalMeasurementTypeService;
import com.application.aled.service.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicalThresholdDTOConvertor {

    @Autowired
    private ResidentService residentService;

    @Autowired
    private MedicalMeasurementTypeService measurementTypeService;

    public MedicalThreshold convertToEntity(MedicalThresholdDTO medicalThresholdDTO){

        MedicalThreshold medicalThreshold= new MedicalThreshold();

        medicalThreshold.setMinValue(medicalThresholdDTO.getMinValue());
        medicalThreshold.setMaxValue(medicalThresholdDTO.getMaxValue());

        // A partir de l'Id de la request http (postman/angular), je recupere l'objet MeasurementType correspondant
        MedicalMeasurementType measurementType= measurementTypeService.getMedicalMeasurementTypeById(medicalThresholdDTO.getMeasurementType_id());
        medicalThreshold.setMeasurementType(measurementType);

        Resident resident= residentService.getResidentById(medicalThresholdDTO.getResident_id());
        medicalThreshold.setResident(resident);

        return medicalThreshold;
    }
}
