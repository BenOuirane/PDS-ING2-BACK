package com.application.aled.controller;

import com.application.aled.dto.convertors.MedicalMeasurementDTOConvertor;
import com.application.aled.entity.*;
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
    ResidentService residentService;
    @Autowired
    UserService userService;

    static final Logger logger = LogManager.getLogger(MockDataMedicalController.class.getName());

    //Liste des residents que je vais utilser
    List<String> residentsName = Arrays.asList("Christine", "Paul", "Vincent");

    //Liste des bracelets que je vais utiliser pour la génération de mes mesures aléatoires
    //List<Integer> braceletID = Arrays.asList(4, 5, 6);
    //List<Integer> braceletID = new ArrayList<>();

    //Liste des types de mesures que je vais utiliser pour la génération de mes mesures aléatoires
    List<String> measurementTypeNames = Arrays.asList("heart beat", "glucose rate", "blood presure");

    List<Bracelet> listBracelet = new ArrayList<>();
    private ReadMedicalParametersCSV readerCSV;
    private Timer valueUpdater;
    private TimerTask tsk;
    private  int counter1 =0;
    private  int age;
    private List<String> braceletID;




    /**
     * @Param numberOfRecords : le nombre de 'mesures effectuées' à génerer aléatoirement
     */

    @PostMapping
    @RequestMapping({"/{numberOfRecords}", "/"})
    public String generateRandomMeasurements(@PathVariable Optional<Integer> numberOfRecords) {

        String returnMessage = "Les données aléatoires n'ont pas été générées correctement";
        readerCSV =new ReadMedicalParametersCSV();
        readerCSV.ReadingCSVfiles();
        braceletID=new ArrayList<>();

        // Récupération de la list des bracelet en String pour pouvoir convertir si besoin en int ou Long en tant voulue
        braceletID= readerCSV.getListBracelet();
        System.out.println(braceletID);

        // 1. On créé des Type de mesures s'ils n'existent pas encore en base
        createMeasurementTypes();

        // 2. On créé les residents s'ils n'existent pas encore en base
        //createResidents();

        // 3. On créé des bracelets s'il n'existent pas encore en base
        createBracelets();

        // 4. Timer
        valueUpdater = new Timer();
        //valueUpdater.schedule(createTimerTask(), 0, 100);


        //5. On créé les measurements
        if (numberOfRecords.isPresent()) {
            // on génére [numberOfRecords] enregistrements
            generateMeasurements(numberOfRecords.get());
        } else {
            // 1 seul enregistrement
            generateMeasurements(1);
        }

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


    // ************bracelet***************************
    private void createBracelets() {
        this.getBraceletID().forEach((braceletid) -> createifnotexistsbracelets(braceletid));

        // Suite à la création des bracelet, je les ajoutes à la liste de Bracelet avec lesquels je vais travailler
        for (Bracelet b : braceletService.getAllBracelets()) {
            for(int i=0;i<braceletID.size();i++)
            {
                if (Long.valueOf(braceletID.get(i))==b.getMcAddress()) {
                    listBracelet.add(b);
                }
            }
        }

    }

    private Bracelet createifnotexistsbracelets(String braceletid) {
        //je vérifie si les bracelet avec lesquels je souhaite travailler existent.
        //si ils n'existent pas, je les crée.
        Bracelet b = null;
        try {
            System.out.println("il fait bo ajd");
            b=braceletService.getBraceletById(Long.valueOf(braceletid));
            System.out.println(b);
        } catch (NoSuchElementException e) {
            logger.info(e.getMessage());
            logger.info("les bracelets qu'on veut créer n'existent pas en base");
        }
        if(b==null)
        {
                b = new Bracelet();
                b.setId(Long.valueOf(braceletid));
                b.setMcAddress(Long.valueOf(braceletid));
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


    private void generateMeasurements(int numberOfRecords) {


                for (Bracelet b : listBracelet)
                {
                    valueUpdater.schedule(createTimerTask(readerCSV.getAge((int) b.getMcAddress()), b), 0, (readerCSV.getTimeUpdate((int) b.getMcAddress())));
                    valueUpdater.purge();

                }


                for (Bracelet b : listBracelet) {


                for (int i = 0; i < readerCSV.getNbOfValue((int) b.getMcAddress()); i++)
                {
                    double value = 0.0;


                    for (String s : measurementTypeNames)
                    {

                        if (s.equalsIgnoreCase("blood pressure")) {
                            value = getRandomMeasure(readerCSV.getThresholdPresureMin((int) b.getMcAddress()), readerCSV.getThresholdPresureMax((int) b.getMcAddress()), readerCSV.getStandarDeviation((int) b.getMcAddress()), readerCSV.getProgram((int) b.getMcAddress()), readerCSV.getNbOfValue((int) b.getMcAddress()))[i];
                        }
                        if (s.equalsIgnoreCase("glucose rate")) {
                            value = getRandomMeasure(readerCSV.getThresholdGlucoseMin((int) b.getMcAddress()), readerCSV.getThresholdGlucoseMax((int) b.getMcAddress()), readerCSV.getStandarDeviation((int) b.getMcAddress()), readerCSV.getProgram((int) b.getMcAddress()), readerCSV.getNbOfValue((int) b.getMcAddress()))[i];
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


    private TimerTask createTimerTask (int age, Bracelet b)
    {

        tsk = new TimerTask() {
            @Override
            public void run() {

                int NbValue= readerCSV.getNbOfValue((int) b.getMcAddress());

                int counter2=+NbValue;
                Double value;
                Double []Tab=new Double[NbValue];
                setAge((Integer) age);

                Tab=MockDataMedicalController.this.getRandomMeasure(getTargetMaxRateMin(), getTargetMaxRateMax(), (int) readerCSV.getStandarDeviation((int) b.getMcAddress()), readerCSV.getProgram(), readerCSV.getNbOfValue((int) b.getMcAddress()));

                MedicalMeasurement mf = new MedicalMeasurement();
                System.out.println("ceci est b "+b);
                System.out.println(Tab[counter1]);
                mf.setMeasurementValue(Tab[counter1]);
                mf.setBracelet(b);
                mf.setMedicalMeasurementType(MockDataMedicalController.this.medicalMeasurementTypeService.getMedicalMeasurementTypeByName("heart beat"));
                LocalDate currentDate = LocalDate.now();
                LocalTime currentTime = LocalTime.now();
                LocalDateTime currentDateAndTime = LocalDateTime.of(currentDate, currentTime);
                mf.setMeasurementDateAndTime(currentDateAndTime);

                medicalMeasurementService.createMedicalMeasurement(mf);

                counter1++;

                if(counter1==NbValue) {
                    counter1=0;
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

    public List<String> getBraceletID() {
        return braceletID;
    }

    public void setBraceletID(List<String> braceletID) {
        this.braceletID = braceletID;
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


    /*   private void generateMeasurements(int numberOfRecords) {

           for(int i=1; i<=numberOfRecords; i++){


               Random r1=new Random();


               for(Bracelet b : listBracelet)
               {
                   double value=0.0;

                   for (String s :measurementTypeNames)
                   {


                       if (s.equalsIgnoreCase("heart beat")) {
                           value = r1.ints(thresholdBPM.get(0), thresholdBPM.get(1)).findFirst().getAsInt();
                       }
                       if (s.equalsIgnoreCase("blood pressure")) {
                           value = r1.ints(thresholdPresure.get(0), thresholdPresure.get(1)).findFirst().getAsInt();
                       }
                       if (s.equalsIgnoreCase("glucose rate")) {
                           value = r1.doubles(thresholdGlucose.get(0),thresholdGlucose.get(1) ).findFirst().getAsDouble();
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
       } */

}