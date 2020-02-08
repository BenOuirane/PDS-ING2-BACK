package com.application.aled.controller;

import com.application.aled.dto.convertors.MedicalMeasurementDTOConvertor;
import com.application.aled.entity.Bracelet;
import com.application.aled.entity.MedicalMeasurement;
import com.application.aled.entity.MedicalMeasurementType;
import com.application.aled.service.BraceletServiceImpl;
import com.application.aled.service.MedicalMeasurementService;
import com.application.aled.service.MedicalMeasurementTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

/**
 *
 * @author Mounir
 *
 * Endpoint permettant de générer des valeurs aléatoires correspondant aux mesures effectuées pour un patient.
 *
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/mockdata")
public class MockDataMedicalController {

    @Autowired
    MedicalMeasurementService       medicalMeasurementService;
    @Autowired
    MedicalMeasurementDTOConvertor  medicalMeasurementDTOConvertor;
    @Autowired
    MedicalMeasurementTypeService   medicalMeasurementTypeService;
    @Autowired
    BraceletServiceImpl             braceletService;

    //Liste des bracelets que je vais utiliser pour la génération de mes mesures aléatoires
    List<Integer> braceletID =  Arrays.asList(4,5,6);

    //Liste des types de mesures que je vais utiliser pour la génération de mes mesures aléatoires
    List<String> measurementTypeNames = Arrays.asList("heart beat","glucose rate","blood pressure");

    List<Bracelet> listBracelet= new ArrayList<>();
    Integer braceletid;

    /**
     * @Param numberOfRecords : le nombre de 'mesures effectuées' à génerer aléatoirement
     *
     */

    @PostMapping
    @RequestMapping({"/{numberOfRecords}", "/" })
    public String generateRandomMeasurements(@PathVariable Optional<Integer> numberOfRecords){

        String returnMessage = "Les données aléatoires n'ont pas été générées correctement";

        // 1. On créé des Type de mesures s'ils n'existent pas encore en base
        createMeasurementTypes();

        // 2. On créé des bracelets s'il n'existent pas encore en base
        createBracelets();

        for (Bracelet b : braceletService.getAllBracelets())
        {
            for(int i=0; i<braceletID.size();i++) {
                if (b.getMcAddress() == braceletID.get(i)) listBracelet.add(b);
            }
        }
        //3. On créé les measurements
        if(numberOfRecords.isPresent()){
           // on génére [numberOfRecords] enregistrements
            generateMeasurements(numberOfRecords.get());
        }else{
            // 1 seul enregistrement
            generateMeasurements(1);
        }

        returnMessage = "Les données aléatoires n'ont été générées correctement";
        return returnMessage;
    }



    // ************bracelet***************************
    private void createBracelets() {
        //braceletID.forEach((braceletid)->createifnotexistsbracelets(braceletid));
        for(Integer i:braceletID){
            createifnotexistsbracelets(i);
        }
    }

    private Bracelet createifnotexistsbracelets(Integer braceletid) {
        //je vérifie si les bracelet avec lesquels je souhaite travailler existent.
        //si ils n'existent pas, je les crée.

        Bracelet b=null;
        try {
            b = braceletService.getBraceletById((long) braceletid);
        }catch(NoSuchElementException e){
                System.out.println(e.getMessage());
        }
        if(b==null) {
            b = new Bracelet();
            b.setId(braceletid);
            b.setMcAddress(braceletid);
            b.setIdResident("" + braceletid);
            b.setRefBracelet("" + braceletid);
            b.setLastSentData(LocalDateTime.now());
            braceletService.addBracelet(b);
            braceletService.getBraceletById(b.getId());
        }
        return b;

    }

    //******Types de Mesures**********//
    private void createMeasurementTypes() {
        measurementTypeNames.forEach((measurementTypeName)->createIfNotExistsMeasurementTypes(measurementTypeName));
    }

    private Object createIfNotExistsMeasurementTypes(String measurementTypeName) {

        MedicalMeasurementType m=null;
        try{
            m=medicalMeasurementTypeService.getMedicalMeasurementTypeByName(measurementTypeName);
        }
        catch(NoSuchElementException e){
            System.out.println(e.getMessage());
        }
        if(m==null) {

            m = new MedicalMeasurementType();
            m.setName(measurementTypeName);
            String shortFormUnit = "", longFormUnit = "";
            if ("heart beat".equalsIgnoreCase(measurementTypeName)) {
                shortFormUnit = "bpm";
                longFormUnit = "beats per minute";
            }
            if ("glucose rate".equalsIgnoreCase(measurementTypeName)) {
                shortFormUnit = "g/L";
                longFormUnit = "grams per litre";
            }
            if ("blood presure".equalsIgnoreCase(measurementTypeName)) {
                shortFormUnit = "mm/m";
                longFormUnit = "mm per mercure";
            }

            m.setShortFormUnit(shortFormUnit);
            m.setLongFormUnit(longFormUnit);

            m=medicalMeasurementTypeService.createMedicalMeasurementType(m);

        }

        return m;

    }

    private void generateMeasurements(int numberOfRecords) {

        for(int i=1; i<=numberOfRecords; i++){

            Random r1= new Random();
            Random r2= new Random();
            Random r3=new Random();


            for(Bracelet b : listBracelet)
            {
                // int rangBracelet= r1.ints(1,3).findFirst().getAsInt();
                //int rangTypeMesure = r2.ints(0, 3).findFirst().getAsInt();

                double value = 0.0;

                for (String s :measurementTypeNames)
                {


                    if (s.equalsIgnoreCase("heart beat")) {
                        value = r3.ints(60, 70).findFirst().getAsInt();
                    }
                    if (s.equalsIgnoreCase("blood pressure")) {
                        value = r3.ints(14, 16).findFirst().getAsInt();
                    }
                    if (s.equalsIgnoreCase("glucose rate")) {
                        value = r3.doubles(1.4, 2.4).findFirst().getAsDouble();
                    }

                    MedicalMeasurement m = new MedicalMeasurement();
                    m.setMeasurementValue(value);
                    m.setBracelet(b);
                    m.setMedicalMeasurementType(medicalMeasurementTypeService.getMedicalMeasurementTypeByName(s));

                    LocalDate currentDate = LocalDate.now();
                    LocalTime currentTime = LocalTime.now();
                    LocalDateTime currentDateAndTime = LocalDateTime.of(currentDate, currentTime);
                    m.setMeasurementDateAndTime(currentDateAndTime);

                    medicalMeasurementService.createMedicalMeasurement(m);
                }
            }
        }
    }




}
