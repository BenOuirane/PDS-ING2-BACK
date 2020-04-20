package com.application.aled.scheduler;

import com.application.aled.entity.MedicalMeasurement;
import com.application.aled.entity.MedicalMeasurementType;
import com.application.aled.entity.MedicalThreshold;
import com.application.aled.repository.MedicalMeasurementRepository;
import com.application.aled.repository.MedicalThresholdRepository;
import com.application.aled.repository.ResidentRepository;
import com.application.aled.service.MedicalMeasurementTypeService;
import com.application.aled.service.ResidentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ScheduledTasks {

    @Resource
    private MedicalThresholdRepository medicalThresholdRepository;

    @Resource
    private MedicalMeasurementRepository medicalMeasurementRepository;

    @Autowired
    private MedicalMeasurementTypeService medicalMeasurementTypeService;

    @Scheduled(fixedDelay = 200, initialDelay = 1000)
    public void checkMeasurements(){

        List<Double> lastThreeMeasurments = new ArrayList<>();

        Collection<MedicalMeasurementType>allMeasurementTypes= medicalMeasurementTypeService.getAllMedicalMeasurementTypes();

        Iterator it= allMeasurementTypes.iterator();

        MedicalMeasurementType currentMeasurementType = null;

        List<Long> lastsMeasurementsId = null;

        List<MedicalMeasurement> lastsMeasurements = null;

        Pageable pageable = PageRequest.of(0, 3);

        MedicalThreshold currentMedThres = null;

        Boolean isAlert = true;

        double currentMeasurementValue ;

        while (it.hasNext()) {
            currentMeasurementType = (MedicalMeasurementType) it.next();
            isAlert = true;

            //je récupère les IDs des x dernières mesures. (ici x = 3 en raison du pageable que j'ai défini plus haut)
            lastsMeasurementsId = medicalMeasurementRepository.findLastsMeasuresByResidentAndMeasurementType(1L, currentMeasurementType.getId(), pageable);

            //Je convertis la liste des IDs en liste de mesures (avec toutes les colonnes d'un enregistrement)
            lastsMeasurements = lastsMeasurementsId.stream().map(id -> medicalMeasurementRepository.findById(id).get()).collect(Collectors.toList());

            List <Double> lastMeasurementValues = lastsMeasurementsId.stream().map(id -> medicalMeasurementRepository.findById(id).get().getMeasurementValue()).collect(Collectors.toList());
            System.out.println("Dernières mesures du patient : "  + currentMeasurementType.getName());
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
                //ToDO : développer la fonction qui va bien
                System.out.println(" ********** DEBUT ALERTE sur la Mesure de : " + currentMeasurementType.getName() + "  *************** ");
                System.out.println("Min = " + currentMedThres.getMinValue() + " - Max = " + currentMedThres.getMaxValue() );
                System.out.println(" VALEURS CONCERNEES : ");
                for (int i = 0; i<lastsMeasurements.size();i++) {
                    System.out.println("Valeur n° " + i);
                    System.out.println(lastsMeasurements.get(i).getMeasurementDateAndTime());
                    System.out.println(lastsMeasurements.get(i).getMeasurementValue());
                }
                System.out.println(" ***** FIN ***** FIN ALERTE sur la Mesure de : " + currentMeasurementType.getName() + "  ****** FIN ********* ");

            }
        }

    }


    }
