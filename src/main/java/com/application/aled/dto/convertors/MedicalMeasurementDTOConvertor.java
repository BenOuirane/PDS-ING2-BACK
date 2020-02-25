package com.application.aled.dto.convertors;

import com.application.aled.dto.MedicalMeasurementDTO;
import com.application.aled.entity.Bracelet;
import com.application.aled.entity.MedicalMeasurement;
import com.application.aled.entity.MedicalMeasurementType;
import com.application.aled.service.BraceletService;
import com.application.aled.service.MedicalMeasurementTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
public class MedicalMeasurementDTOConvertor {

    @Autowired
    private BraceletService braceletService;
    @Autowired
    private MedicalMeasurementTypeService medicalMeasurementTypeService;

    public MedicalMeasurement convertToEntity (MedicalMeasurementDTO medicalMeasurementDTO){

        MedicalMeasurement medicalMeasurement =new MedicalMeasurement();
        medicalMeasurement.setMeasurementValue(medicalMeasurementDTO.getMedicalMeasurementValue());

        // A partir de l'Id de la request http (postman/angular), je recupere l'objet MeasurementType correspondant
        MedicalMeasurementType medicalMeasurementType= medicalMeasurementTypeService.getMedicalMeasurementTypeById(medicalMeasurementDTO.getMedicalMeasurementType_id());
        medicalMeasurement.setMedicalMeasurementType(medicalMeasurementType);

        Bracelet bracelet= braceletService.getBraceletById(medicalMeasurementDTO.getBracelet_id());
        medicalMeasurement.setBracelet(bracelet);

        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        LocalDateTime currentDateAndTime = LocalDateTime.of(currentDate, currentTime);

        medicalMeasurement.setMeasurementDateAndTime(currentDateAndTime);

        return medicalMeasurement;
    }

}
