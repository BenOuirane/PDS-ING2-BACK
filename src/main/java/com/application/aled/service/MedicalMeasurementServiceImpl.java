package com.application.aled.service;

import com.application.aled.entity.MedicalMeasurement;
import com.application.aled.entity.MedicalMeasurementType;
import com.application.aled.entity.MedicalThreshold;
import com.application.aled.entity.Resident;
import com.application.aled.repository.MedicalMeasurementRepository;
import com.application.aled.repository.MedicalThresholdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@Service(value="medical_measurement_service")
public class MedicalMeasurementServiceImpl implements MedicalMeasurementService{

    @Resource
    private MedicalMeasurementRepository medicalMeasurementRepository;

    @Resource
    private MedicalThresholdRepository medicalThresholdRepository;

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    @Override
    public Collection<MedicalMeasurement> getMeasurementsByResidentAndMeasurementType(Long residentID,Long measurementTypeId) {
        List<Long> lastsMeasurementsId = null;
        List<MedicalMeasurement> lastsMeasurements = null;
        Pageable pageable = PageRequest.of(0, 50);

        lastsMeasurementsId = medicalMeasurementRepository.findLastsMeasuresByResidentAndMeasurementType(residentID, measurementTypeId,pageable);

        //Je convertis la liste des IDs en liste de mesures (avec toutes les colonnes d'un enregistrement)
        lastsMeasurements = lastsMeasurementsId.stream().map(id -> medicalMeasurementRepository.findById(id).get()).collect(Collectors.toList());



        return lastsMeasurements;
    }

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

        // Compare les valeur de la mesure avec les seuils min et max
        // Si la valeur est en dehors des bornes envoyer
        //A chaque enregistrement d'une mesure en base je check la mesure à partir d'ici et plus dans generaterandom
        checkMeasurements(medicalMeasurement);
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



    private void checkMeasurements(MedicalMeasurement measurement) {

        Map<String, String> progress = new HashMap<>();

        List<Double> lastThreeMeasurments = new ArrayList<>();

        Resident resident = measurement.getBracelet().getResidents();

        MedicalMeasurementType currentMeasurementType =  measurement.getMedicalMeasurementType();

        List<Long> lastsMeasurementsId = null;

        List<MedicalMeasurement> lastsMeasurements = null;

        Pageable pageable = PageRequest.of(0, 3);

        MedicalThreshold currentMedThres = null;

        Boolean isAlert = true;

        double currentMeasurementValue ;

        //Je parcours tous les types de mesures qui existent, pour un patient donné
        // A noter que pour le moment, le patient est figé


        isAlert = true;

        //je récupère les IDs des x dernières mesures. (ici x = 3 en raison du pageable que j'ai défini plus haut)
        lastsMeasurementsId = medicalMeasurementRepository.findLastsMeasuresByResidentAndMeasurementType(resident.getIdResident(), currentMeasurementType.getId(),pageable);

        //Je convertis la liste des IDs en liste de mesures (avec toutes les colonnes d'un enregistrement)
        lastsMeasurements = lastsMeasurementsId.stream().map(id -> medicalMeasurementRepository.findById(id).get()).collect(Collectors.toList());

        List <Double> lastMeasurementValues = lastsMeasurementsId.stream().map(id -> medicalMeasurementRepository.findById(id).get().getMeasurementValue()).collect(Collectors.toList());
        System.out.println("Dernières mesures de : "  + currentMeasurementType.getName());
        System.out.println(lastMeasurementValues.toString());

        //Pour le patient, je récupère ses seuils haut et bas pour le type de mesure actuel
        currentMedThres = medicalThresholdRepository.findByResidentAndMeasurementType(1L, currentMeasurementType.getId());

        //Pour les x dernières valeurs que j'ai récupérées, je vérifie si on se trouve bien dans les bonnes bornes.
        for (int i = 0; i<lastsMeasurements.size();i++) {
            currentMeasurementValue = lastsMeasurements.get(i).getMeasurementValue();
            if((currentMeasurementValue >= currentMedThres.getMinValue()) && (currentMeasurementValue <= currentMedThres.getMaxValue()))
                isAlert = false;
        }
        //Si pour les x dernières valeurs on était resté hors des bornes, alors isAlert est toujours à TRUE
        //Je dois donc envoyer une notification au médecin ou à l'écran front
        if(isAlert) {
            progress.put("residentFirsName", resident.getFirstName());
            progress.put("residentLastName", resident.getLastName());
            progress.put("residentAge", resident.getAge()+"");
            progress.put("residentRoom", resident.getRoom().getIdRoom()+"");
            progress.put("measurementType", currentMeasurementType.getName());
            progress.put("measurementUnit", currentMeasurementType.getLongFormUnit());
            progress.put("measurementTypeMinValue", currentMedThres.getMinValue()+"");
            progress.put("measurementTypeMaxValue", currentMedThres.getMaxValue()+"");



            //ToDO : développer la fonction qui va bien
            System.out.println(" ********** DEBUT ALERTE sur la Mesure de : " + currentMeasurementType.getName() + "  *************** ");
            System.out.println("Min = " + currentMedThres.getMinValue() + " - Max = " + currentMedThres.getMaxValue() );
            System.out.println(" VALEURS CONCERNEES : ");
            for (int i = 0; i<lastsMeasurements.size();i++) {
                System.out.println("Valeur n° " + i);
                System.out.println(lastsMeasurements.get(i).getMeasurementDateAndTime());
                System.out.println(lastsMeasurements.get(i).getMeasurementValue());
                progress.put("lastMeasurement_"+(i+1), lastsMeasurements.get(i).getMeasurementDateAndTime() + " : " + lastsMeasurements.get(i).getMeasurementValue());
            }
            messagingTemplate.convertAndSend("/topic/progress", progress);
            System.out.println(" ***** FIN ***** FIN ALERTE sur la Mesure de : " + currentMeasurementType.getName() + "  ****** FIN ********* ");

        }


    }
}
