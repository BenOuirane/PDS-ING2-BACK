package com.application.aled.controller;

import com.application.aled.dto.MedicalThresholdDTO;
import com.application.aled.dto.convertors.MedicalThresholdDTOConvertor;
import com.application.aled.entity.MedicalThreshold;
import com.application.aled.service.MedicalMeasurementTypeService;
import com.application.aled.service.MedicalThresholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

public class MedicalThresholdController {

    @Autowired
    MedicalThresholdService medicalThresholdService;
    @Autowired
    MedicalThresholdDTOConvertor medicalThresholdDTOConvertor;
    @Autowired
    MedicalMeasurementTypeService measurementTypeService;



    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public MedicalThreshold createMedicalThreshold(@RequestBody MedicalThresholdDTO medicalThresholdDTO){

        MedicalThreshold returnMedicalThreshold=null;

        try{
            MedicalThreshold tempMedicalThreshold=this.medicalThresholdDTOConvertor.convertToEntity(medicalThresholdDTO);
            returnMedicalThreshold=this.medicalThresholdService.createMedicalThreshold(tempMedicalThreshold);
        }catch(Exception e){
            System.out.println("Error creation medicalThreshold");
        }

        return returnMedicalThreshold;
    }
    @PutMapping("/{id}")
    public MedicalThreshold updateMedicalThreshold(@PathVariable(value="id") Long id, @RequestBody MedicalThresholdDTO medicalThresholdDTO){


        MedicalThreshold returnMedicalThreshold=null;
        MedicalThreshold tempMedicalThreshold= null;


        try{
            tempMedicalThreshold=this.medicalThresholdDTOConvertor.convertToEntity(medicalThresholdDTO);
            tempMedicalThreshold.setId(id);
            returnMedicalThreshold=this.medicalThresholdService.updateMedicalThreshold(tempMedicalThreshold);

        }catch(Exception e){
            System.out.println("Error creation medicalThreshold");
        }

        return returnMedicalThreshold;
    }
    @DeleteMapping("/{id}")
    public void deleteMedicalThreshold(@PathVariable(value="id") Long id){

        this.medicalThresholdService.deleteMedicalThreshold(id);
    }

    @GetMapping("/{id}")
    public MedicalThreshold getMedicalThreshold(@PathVariable(value="id") Long id){

        return this.medicalThresholdService.getMedicalThresholdById(id);
    }

    @GetMapping
    public Collection<MedicalThreshold> getAllMedicalThresholds(){

        return this.medicalThresholdService.getAllMedicalThresholds();
    }
}
