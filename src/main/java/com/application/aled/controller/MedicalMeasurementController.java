package com.application.aled.controller;

import com.application.aled.dto.MedicalMeasurementDTO;
import com.application.aled.dto.convertors.MedicalMeasurementDTOConvertor;
import com.application.aled.entity.MedicalMeasurement;
import com.application.aled.service.MedicalMeasurementService;
import com.application.aled.service.MedicalMeasurementTypeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

public class MedicalMeasurementController {

    @Autowired
    MedicalMeasurementService measurementService;
    @Autowired
    MedicalMeasurementDTOConvertor measurementDTOConvertor;
    @Autowired
    MedicalMeasurementTypeService measurementTypeService;

    static final Logger logger = LogManager.getLogger(MedicalMeasurementController.class.getName());

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public MedicalMeasurement createMedicalMeasurement(@RequestBody MedicalMeasurementDTO measurementDTO){

        MedicalMeasurement returnMedicalMeasurement=null;

        try{
            MedicalMeasurement tempMeasurement = this.measurementDTOConvertor.convertToEntity(measurementDTO);
            returnMedicalMeasurement=this.measurementService.createMedicalMeasurement(tempMeasurement);
        }catch (Exception e){
            System.out.println("error creation medical_measurement");
        }

        return returnMedicalMeasurement;
    }
    @PutMapping("/{id}")
    public MedicalMeasurement updateMedicalMeasurement(@PathVariable(value="id") Long id, @RequestBody MedicalMeasurementDTO measurementDTO){


        MedicalMeasurement returnMeasurement=null;
        MedicalMeasurement tempMeasurement= null;


        try{
            tempMeasurement=this.measurementDTOConvertor.convertToEntity(measurementDTO);
            tempMeasurement.setId(id);
            returnMeasurement=this.measurementService.updateMedicalMeasurement(tempMeasurement);

        }catch(Exception e){
            System.out.println("Error creation medical_measurement");
        }

        return returnMeasurement;
    }

    @DeleteMapping("/{id}")
    public void deleteMedicalMeasurement(@PathVariable(value="id") Long id){

        this.measurementService.deleteMedicalMeasurement(id);
    }

    @GetMapping("/{id}")
    public MedicalMeasurement getMedicalMeasurement(@PathVariable(value="id") Long id){
        return this.measurementService.getMedicalMeasurementById(id);
    }
    @GetMapping
    public Collection<MedicalMeasurement> getAllMedicalMeasurements(){
        return this.measurementService.getAllMedicalMeasurements();
    }
}
