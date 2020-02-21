package com.application.aled.controller;

import com.application.aled.entity.MedicalMeasurementType;
import com.application.aled.service.MedicalMeasurementTypeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 *
 * @author Mounir
 *
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/medical_measurement_type")

public class MedicalMeasurementTypeController {

    static final Logger logger = LogManager.getLogger(MedicalMeasurementTypeController.class.getName());

    @Autowired
    MedicalMeasurementTypeService medicalMeasurementTypeService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public MedicalMeasurementType createMedicalMeasurementType(@RequestBody MedicalMeasurementType medicalMeasurementType){

        MedicalMeasurementType returnMedicalMeasurementType=null;
        try{
            returnMedicalMeasurementType= medicalMeasurementTypeService.createMedicalMeasurementType(medicalMeasurementType);
        }catch(Exception e){
            System.out.println("error creation medicalMeasurementType");
        }

        return returnMedicalMeasurementType;
    }

    @PutMapping ("/{id}")
    public MedicalMeasurementType updateMedicalMeasurementType(@PathVariable (value="id") long id,
                                                               @RequestBody MedicalMeasurementType medicalMeasurementType){
        medicalMeasurementType.setId(id);
        return this.medicalMeasurementTypeService.updateMedicalMeasurementType(medicalMeasurementType);
    }

    @DeleteMapping("/{id}")
    public void deleteMedicalMeasurementType(@PathVariable(value="id") long id){

        this.medicalMeasurementTypeService.deleteMedicalMeasurementType(id);
    }

    @GetMapping("/{id}")
    public MedicalMeasurementType getMedicalMeasurementType(@PathVariable(value="id") long id ){

        return this.medicalMeasurementTypeService.getMedicalMeasurementTypeById(id);
    }

    public Collection<MedicalMeasurementType> getAllMedicalMeasurementTypes(){

        return this.medicalMeasurementTypeService.getAllMedicalMeasurementTypes();
    }

}
