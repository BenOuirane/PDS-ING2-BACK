package com.application.aled.controller;

import com.application.aled.dto.MedicalMeasurementDTO;
import com.application.aled.dto.convertors.MedicalMeasurementDTOConvertor;
import com.application.aled.entity.*;
import com.application.aled.parametersMedical.ReadMedicalParametersCSV;
import com.application.aled.service.*;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import org.apache.logging.log4j.Logger;


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
    MedicalMeasurementService medicalMeasurementService;
    @Autowired
    MedicalMeasurementDTOConvertor medicalMeasurementDTOConvertor;
    @Autowired
    MedicalMeasurementTypeService medicalMeasurementTypeService;
    @Autowired
    BraceletServiceImpl braceletService;

    @Autowired
    UserService userService;



    static final Logger logger = LogManager.getLogger(MockDataMedicalController.class.getName());

    //Liste des residents que je vais utilser
    List<String> residentsName = Arrays.asList("Christine", "Paul", "Vincent");

    //Liste des bracelets que je vais utiliser pour la génération de mes mesures aléatoires
    //List<Integer> braceletID = Arrays.asList(4, 5, 6);
    //List<Integer> braceletID = new ArrayList<>();

    //Liste des types de mesures que je vais utiliser pour la génération de mes mesures aléatoires
    List<String> measurementTypeNames = Arrays.asList("heart beat","glucose rate", "blood presure");
    List<String> measurementTypeNames2 = Arrays.asList("glucose rate", "blood presure");
    List<Bracelet> listBracelet = new ArrayList<>();

    private ReadMedicalParametersCSV readerCSV;
    private Timer valueUpdater;
    private TimerTask tsk;
    private  int counter1 =0;
    private  int age;

    Collection<Double> listMeasurements;

    /**
     * @Param numberOfRecords : le nombre de 'mesures effectuées' à génerer aléatoirement
     */

    @PostMapping
    @RequestMapping({"/{nameBracelet}"})
    public String generateRandomMeasurements(@PathVariable String nameBracelet) {

        String returnMessage = "Les données aléatoires n'ont pas été générées correctement";
        readerCSV =new ReadMedicalParametersCSV(braceletService);
        readerCSV.ReadingCSVfiles();

        // Récupération de la list des bracelet en String pour pouvoir convertir si besoin en int ou Long en tant voulue
        for(Bracelet b:readerCSV.lstBracelet){
            listBracelet.add(b);
        }

        // 1. On créé des Type de mesures s'ils n'existent pas encore en base
        createMeasurementTypes();

        // 2. On créé les residents s'ils n'existent pas encore en base
        //createResidents();


        // 4. Timer
        valueUpdater = new Timer();
        //valueUpdater.schedule(createTimerTask(), 0, 100);

        generateMeasurements();

        System.out.println(nameBracelet);
        System.out.println(getMeasurementByBracelet(nameBracelet));


        returnMessage = "Les données aléatoires n'ont été générées correctement";
        return returnMessage;
    }

    // ************resident***************************
    private void createResidents() {
        residentsName.forEach((residentname) -> createIfNotExistsResident(residentname));
    }

    private void createIfNotExistsResident(String residentname) {

        User u = null;
        //pour le moment pas de methode pour creer un user et pouvoir l'affecter à un patient ???
        //u=userService.
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
            if ("blood presure".equalsIgnoreCase(measurementTypeName)) {
                shortFormUnit = "mmHg";
                longFormUnit = "mm of mercure";
            }

            m.setShortFormUnit(shortFormUnit);
            m.setLongFormUnit(longFormUnit);

            m = medicalMeasurementTypeService.createMedicalMeasurementType(m);

        }

        return m;

    }

    public Collection<Double> getMeasurementByBracelet(String nameBracelet){



              for (String s : measurementTypeNames)
              {
                for (Bracelet b : braceletService.getAllBracelets())
                {
                    if(b.getRefBracelet().equals(nameBracelet))
                    {
                        listMeasurements=new ArrayList<>();
                        for (MedicalMeasurement mm : medicalMeasurementService.getAllMedicalMeasurements())
                        {
                            Double mv=mm.getMeasurementValue();
                            listMeasurements.add(mv);
                        }
                        break;
                    }
                }
            }

            return listMeasurements;
    }


    private void generateMeasurements() {



                valueUpdater.schedule(createTimerTask(listBracelet), 0, 100);

                for (Bracelet b : listBracelet)
                {

                    for (int i = 0; i < readerCSV.getNbOfValue(b); i++)
                    {
                        double value = 0.0;


                        for (String s : measurementTypeNames2)
                        {


                            if (s.equalsIgnoreCase("blood pressure")) {
                                System.out.println("presure min "+(readerCSV.getThresholdPresureMin(b)));
                                value = getRandomMeasure(readerCSV.getThresholdPresureMin(b), readerCSV.getThresholdPresureMax(b), readerCSV.getStandarDeviation(b), readerCSV.getProgram(b), readerCSV.getNbOfValue(b))[i];
                            }
                            if (s.equalsIgnoreCase("glucose rate")) {
                                value = getRandomMeasure(readerCSV.getThresholdGlucoseMin(b), readerCSV.getThresholdGlucoseMax(b), readerCSV.getStandarDeviation(b), readerCSV.getProgram(b), readerCSV.getNbOfValue(b))[i];
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



    private TimerTask createTimerTask ( List<Bracelet> listBracelet)
    {

        tsk = new TimerTask() {
            @Override
            public void run() {
                int counter1=0;

                for(Bracelet b : listBracelet) {

                    int NbValue = readerCSV.getNbOfValue(b);
                    Double value;
                    Double[] Tab = new Double[NbValue];
                    setAge((Integer) readerCSV.getAge(b));
                    while(counter1!=NbValue) {


                        Tab = MockDataMedicalController.this.getRandomMeasure(getTargetMaxRateMin(), getTargetMaxRateMax(), (int) readerCSV.getStandarDeviation(b), readerCSV.getProgram(b), readerCSV.getNbOfValue((b)));

                        MedicalMeasurement mf = new MedicalMeasurement();
                        System.out.println("ceci est b " + b + "son bpm est "+ Tab[counter1]);
                        mf.setMeasurementValue(Tab[counter1]);
                        mf.setBracelet(b);
                        mf.setMedicalMeasurementType(MockDataMedicalController.this.medicalMeasurementTypeService.getMedicalMeasurementTypeByName("heart beat"));
                        LocalDate currentDate = LocalDate.now();
                        LocalTime currentTime = LocalTime.now();
                        LocalDateTime currentDateAndTime = LocalDateTime.of(currentDate, currentTime);
                        mf.setMeasurementDateAndTime(currentDateAndTime);

                        medicalMeasurementService.createMedicalMeasurement(mf);

                        counter1++;
                    }
                    if (counter1 == NbValue) {
                        counter1 = 0;
                        //continue;
                        //cancel();
                    }
                    cancel();
                }
            }
        };
        return tsk;

    }






    public Double[] getRandomMeasure(double min, double max, int sd, String program, Integer nbOfValue) {
        Random r = new Random();

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Double Tab[] = new Double[nbOfValue];
        int mean = (int) (min + max) / 2;
        int standardDeviation = sd;
        double value = 0.0;
        String prog = program;

        switch (program) {

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