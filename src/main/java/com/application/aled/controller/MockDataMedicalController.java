package com.application.aled.controller;


import com.application.aled.dto.convertors.MedicalMeasurementDTOConvertor;
import com.application.aled.entity.Bracelet;
import com.application.aled.entity.MedicalMeasurement;
import com.application.aled.entity.MedicalMeasurementType;
import com.application.aled.entity.Resident;
import com.application.aled.parametersMedical.ReadMedicalParametersCSV;
import com.application.aled.service.BraceletServiceImpl;
import com.application.aled.service.MedicalMeasurementService;
import com.application.aled.service.MedicalMeasurementTypeService;
import com.application.aled.service.ResidentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.logging.Logger;


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
@Transactional
public class MockDataMedicalController {

    @Autowired
    MedicalMeasurementService medicalMeasurementService;
    @Autowired
    MedicalMeasurementDTOConvertor medicalMeasurementDTOConvertor;
    @Autowired
    MedicalMeasurementTypeService medicalMeasurementTypeService;
    @Autowired
    BraceletServiceImpl braceletService;
    @Autowired
    ResidentServiceImpl residentService;

    //Logger logger = LogManager.getLogger(MockDataMedicalController.class.getName());
    java.util.logging.Logger logger = Logger.getLogger("com.application.aled.controller.MockDataMedicalController");

    //Liste des types de mesures que je vais utiliser pour la génération de mes mesures aléatoires
    List<String> measurementTypeNames = Arrays.asList("heart beat","glucose rate", "blood pressure");
    List<Bracelet> listBracelet = new ArrayList<>();
    List<Resident> listResidents =new ArrayList<>();

    private ReadMedicalParametersCSV readerCSV;
    private  int age;
    private Thread t1;
    private Thread t2;
    private Thread t3;
    private Collection<MedicalMeasurement> listMeasurements;


    //@PostMapping
    //@RequestMapping({"/{nameResident}"})
    //public String generateRandomMeasurements(@PathVariable String nameResident)

    @Scheduled(fixedDelay = 20000, initialDelay = 1000)
    public void generateRandomMeasurements() {

        //String returnMessage = "Les données aléatoires n'ont pas été générées correctement";
        readerCSV =new ReadMedicalParametersCSV(braceletService, residentService);
        readerCSV.ReadingCSVfiles();

        listResidents= readerCSV.getListResidents();
        listBracelet=readerCSV.getListBracelets();

        // 1. On créé des Type de mesures s'ils n'existent pas encore en base
        createMeasurementTypes();

        generateMeasurements(listBracelet);

        //System.out.println(nameResident);
        //System.out.println(getMeasurementByResident(nameResident));

        //returnMessage = "Les données aléatoires ont été générées correctement";
        //return returnMessage;
    }



    //******Types de Mesures**********//
    private void createMeasurementTypes() {
        measurementTypeNames.forEach((measurementTypeName) -> createIfNotExistsMeasurementTypes(measurementTypeName));
    }

    private Object createIfNotExistsMeasurementTypes(String measurementTypeName) {

        MedicalMeasurementType m = null;
        try {
            m = medicalMeasurementTypeService.getMedicalMeasurementTypeByName(measurementTypeName);
        } catch (NoSuchElementException e) {
            logger.info(e.getMessage());

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
            if ("blood pressure".equalsIgnoreCase(measurementTypeName)) {
                shortFormUnit = "mmHg";
                longFormUnit = "mm of mercure";
            }

            m.setShortFormUnit(shortFormUnit);
            m.setLongFormUnit(longFormUnit);

            m = medicalMeasurementTypeService.createMedicalMeasurementType(m);

        }

        return m;

    }
    @GetMapping
    @RequestMapping({"/measures/{nameResident}"})
    public Collection<MedicalMeasurement> getMeasurementByResident(@PathVariable String nameResident){

        Long resident_id=residentService.getAllResidents().stream()
                .filter(t->t.getLastName().equals(nameResident))
                .map(Resident::getIdResident)
                .findAny().orElse(null);

        Long bracelet_id=braceletService.getAllBracelets().stream()
                .filter(x->x.getResidents().getIdResident().equals(resident_id))
                .map(Bracelet::getId)
                .findAny().orElse(null);

        listMeasurements=new ArrayList<>();

        for(MedicalMeasurement m : medicalMeasurementService.getAllMedicalMeasurements())
        {
            if(m.getBracelet().getId()==bracelet_id){
                listMeasurements.add(m);
            }
        }
        return listMeasurements;
    }


    public void generateMeasurements(List<Bracelet> lb) {


        System.out.println("lb = " + lb);
        //using thread rather than timer because thread are more accurate and easier to update time
        // with method thread sleep()
        synchronized (lb) {
            generateBPM(lb);
            //wait thread t1 is finish to start generate other value for other measurementType
            try {
                t1.join();
                generatePressure(lb);
                t2.join();
                generateGlucose(lb);
                t3.join();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    private void generateGlucose( List<Bracelet> listBracelet){

        t3= new Thread(new Runnable() {
            @Override
            public void run() {
                int counter3=0;


                    for (Bracelet b : listBracelet) {

                        int NbValue = readerCSV.getNbOfValue(b);
                        Double value;
                        Double[] Tab = new Double[NbValue];
                        counter3=0;

                        while (counter3 < NbValue) {
                            Tab = MockDataMedicalController.this.getRandomMeasure(readerCSV.getThresholdGlucoseMin(b), readerCSV.getThresholdGlucoseMax(b), readerCSV.getStandarDeviation(b), readerCSV.getProgram(b), readerCSV.getNbOfValue(b));
                            MedicalMeasurement mf = new MedicalMeasurement();

                            logger.info("ceci est  " + b.getResidents().getLastName() + " son taux de glucose est " + Tab[counter3]);
                            mf.setMeasurementValue(Tab[counter3]);
                            mf.setBracelet(b);
                            mf.setMedicalMeasurementType(MockDataMedicalController.this.medicalMeasurementTypeService.getMedicalMeasurementTypeByName("glucose rate"));
                            LocalDate currentDate = LocalDate.now();
                            LocalTime currentTime = LocalTime.now();
                            LocalDateTime currentDateAndTime = LocalDateTime.of(currentDate, currentTime);
                            mf.setMeasurementDateAndTime(currentDateAndTime);

                            medicalMeasurementService.createMedicalMeasurement(mf);
                            try {
                                t3.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            counter3++;
                        }
                    }
                }


        });

        t3.start();

    }

    private void generatePressure( List<Bracelet> listBracelet){

        t2= new Thread(new Runnable() {
            @Override
            public void run() {
                int counter2=0;

                for(Bracelet b : listBracelet)
                {

                    int NbValue = readerCSV.getNbOfValue(b);
                    Double[] Tab = new Double[NbValue];
                    counter2=0;
                    while(counter2<NbValue) {
                        Tab = MockDataMedicalController.this.getRandomMeasure(readerCSV.getThresholdPressureMin(b), readerCSV.getThresholdPressureMax(b), readerCSV.getStandarDeviation(b), readerCSV.getProgram(b), readerCSV.getNbOfValue(b));

                        MedicalMeasurement mf = new MedicalMeasurement();

                        logger.info("ceci est  " + b.getResidents().getLastName() + " sa tension est "+ Tab[counter2]);
                        mf.setMeasurementValue(Tab[counter2]);
                        mf.setBracelet(b);
                        mf.setMedicalMeasurementType(MockDataMedicalController.this.medicalMeasurementTypeService.getMedicalMeasurementTypeByName("blood pressure"));
                        LocalDate currentDate = LocalDate.now();
                        LocalTime currentTime = LocalTime.now();
                        LocalDateTime currentDateAndTime = LocalDateTime.of(currentDate, currentTime);
                        mf.setMeasurementDateAndTime(currentDateAndTime);

                        medicalMeasurementService.createMedicalMeasurement(mf);
                        try {
                            t2.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        counter2++;
                    }
                }
            }

        });

        t2.start();

    }

    private void generateBPM( List<Bracelet> listBracelet){

        t1= new Thread(new Runnable() {
            @Override
            public void run() {
                int counter1 = 0;

                    for (Bracelet b : listBracelet) {

                        int NbValue = readerCSV.getNbOfValue(b);
                        Double[] Tab = new Double[NbValue];
                        setAge((Integer) b.getResidents().getAge());
                        counter1=0;
                        while (counter1 < NbValue) {


                            Tab = MockDataMedicalController.this.getRandomMeasure(getTargetMaxRateMin(), getTargetMaxRateMax(), readerCSV.getStandarDeviation(b), readerCSV.getProgram(b), readerCSV.getNbOfValue((b)));

                            MedicalMeasurement mf = new MedicalMeasurement();

                            logger.info("ceci est  " + b.getResidents().getLastName() + " son bpm est " + Tab[counter1]);
                            mf.setMeasurementValue(Tab[counter1]);
                            mf.setBracelet(b);
                            mf.setMedicalMeasurementType(MockDataMedicalController.this.medicalMeasurementTypeService.getMedicalMeasurementTypeByName("heart beat"));
                            LocalDate currentDate = LocalDate.now();
                            LocalTime currentTime = LocalTime.now();
                            LocalDateTime currentDateAndTime = LocalDateTime.of(currentDate, currentTime);
                            mf.setMeasurementDateAndTime(currentDateAndTime);

                            medicalMeasurementService.createMedicalMeasurement(mf);
                            try {
                                t1.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            counter1++;
                        }
                    }
                }


        });

        t1.start();

    }

    public Double[] getRandomMeasure(double min, double max, double sd, String program, Integer nbOfValue) {
        Random r = new Random();

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Double Tab[] = new Double[nbOfValue];
        int mean = (int) (min + max) / 2;
        double standardDeviation = sd;
        double value = 0.0;
        String prog = program;

        double base = mean ;
        int lengthPlateau=4;
        Double plateau[] = new Double[lengthPlateau];
        Double maxPlateau = max+1;

        switch (program) {

            case("trapeze"):
                Tab[0] =  base;

                for (int i = 1; i < nbOfValue; i++)
                {

                    Tab[i]=Tab[i-1]+ 0.5*i;

                    if(i>=nbOfValue/2 && i<((nbOfValue/2)+lengthPlateau))
                    {
                        Tab[i]=maxPlateau;
                    }

                    if(i>=nbOfValue/2+lengthPlateau || Tab[i]>maxPlateau)
                    {
                        Tab[i]=Tab[i-1]-(0.2*i);
                    }

                    if(Tab[i]<base)
                    {
                        Tab[i]=base;
                    }


                }
                break;


            case ("normal"):
                for (int i = 0; i < nbOfValue; i++) {
                    value = mean + (int) (r.nextGaussian() * standardDeviation);
                    Tab[i] = (Double) value;
                }
                break;

            case ("anormalHaut"):
                for (int i = 0; i < nbOfValue; i++) {
                    value = max + (int) (r.nextGaussian() * standardDeviation);
                    Tab[i] = (Double) value;
                }
                break;

            case ("anormalBas"):
                for (int i = 0; i < nbOfValue; i++) {
                    value = min + (int) (r.nextGaussian() * standardDeviation);
                    Tab[i] = (Double) value;
                }
                break;

            default:
                System.out.println("Please choose an program");
        }
        return Tab;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Maximum BPM
    public int getMaxHeartRate()
    {
        int maxHeartRate = 220 - getAge();
        return maxHeartRate;
    }

    // Target heart rate range:

    public int getTargetMaxRateMin(){
        int targetHeartRateMin = (int) ((50f/100f) * getMaxHeartRate());
        return targetHeartRateMin ;
    }

    public int getTargetMaxRateMax(){
        int targetHeartRateMax = (int)((85f/100f) * getMaxHeartRate());
        return targetHeartRateMax;
    }

}
