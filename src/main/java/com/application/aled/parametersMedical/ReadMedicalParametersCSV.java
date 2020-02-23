package com.application.aled.parametersMedical;


import com.application.aled.entity.Bracelet;
import com.application.aled.service.BraceletServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class ReadMedicalParametersCSV {

    BraceletServiceImpl braceletService;

    List<String> braceletName;
    List<String> lstValues = Arrays.asList();
    public List<Bracelet> lstBracelet=new ArrayList<>();
    HashMap<String, List<String>> hsmp;
    Map<String, HashMap<String, List<String>>> hsmp2 ;

    private String mac = "";
    static final Logger logger = LogManager.getLogger(ReadMedicalParametersCSV.class.getName());

    public ReadMedicalParametersCSV(BraceletServiceImpl braceletService) {
        this.braceletService=braceletService;
    }

    public void ReadingCSVfiles() {

        String csvFile = "src/main/resources/com/application/aled/support.files/MedicalParameters.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            //System.out.println(br.readLine());
            hsmp2=new HashMap<String, HashMap<String, List<String>>>();

            while ((line = br.readLine()) != null) {
                Bracelet b = new Bracelet();

                String[] split = line.split(cvsSplitBy);
                lstValues = new ArrayList<String>();
                for (int i = 2; i < split.length; i++) {

                    lstValues.add(split[i]);
                }
                hsmp = new HashMap<String, List<String>>();
                hsmp.put(split[1], lstValues);
                hsmp2.put(split[0], hsmp);

                b.setRefBracelet(split[0]);
                b.setMcAddress(Long.parseLong(split[1]));
                //b.setIdResident("");
                createifnotexistsbracelets(b);
            }

        } catch (FileNotFoundException e) {

            logger.info("le fichier n'est pas trouvé");
        } catch (IOException e) {
            logger.info(e.getMessage());
            logger.info("Impossible de lire le fichier des commandes");
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private void createifnotexistsbracelets(Bracelet bracelet) {
        //je vérifie si les bracelet avec lesquels je souhaite travailler existent.
        //si ils n'existent pas, je les crée.

        Boolean exist = false;
        for (Bracelet b : braceletService.getAllBracelets()) {
            if (b.getMcAddress() == bracelet.getMcAddress()) {
                exist = true;
                lstBracelet.add(b);
                return;
            }
        }
        if (!exist) {
            braceletService.addBracelet(bracelet);
            lstBracelet.add(bracelet);
        }

    }


    public List<String> getBraceletName()
    {
        List<Double> valuesParameters=null;
        List<Map.Entry<String, List<String>>> myList = null;
        String name="";

        for (Map.Entry<String, HashMap<String, List<String>>> en : hsmp2.entrySet()) {

            braceletName.add(en.getKey());

        }
        return braceletName;
    }

    public String getMac(Bracelet b){

        List<Double> valuesParameters=null;
        List<Map.Entry<String, List<String>>> myList = null;
        String mac="";

        for (Map.Entry<String, HashMap<String, List<String>>> en : hsmp2.entrySet()) {

            if (b.getRefBracelet() == en.getKey())
            {
                Map<String, List<String>> map2 = en.getValue();
                Set<Map.Entry<String, List<String>>> set2 = map2.entrySet();
                myList = new ArrayList<>(set2);

                for (Map.Entry<String, List<String>> ee : myList) {
                    mac = ee.getKey();

                }

            }
        }

        return mac;
    }

    public Object[] convertParameters(Bracelet b) {

        List<String> valuesParameters= new ArrayList<>();
        List<Map.Entry<String, List<String>>> myList;

        for (Map.Entry<String, HashMap<String, List<String>>> en : hsmp2.entrySet()) {

            if (b.getRefBracelet().equals(en.getKey()))
            {

                Map<String, List<String>> map2 = en.getValue();
                Set<Map.Entry<String, List<String>>> set2 = map2.entrySet();
                myList = new ArrayList<>(set2);

                for (Map.Entry<String, List<String>> ee : myList)
                {
                    if(ee.getKey().equals(String.valueOf(b.getMcAddress())))
                    {
                        valuesParameters = ee.getValue();
                    }
                }
                return valuesParameters.toArray();
            }


        }

        return null;
    }

    private void setMac(String mac) {
        this.mac=mac;
    }


    public String getProgram(Bracelet b){

        return (String) convertParameters(b)[0];
    }


    public int getAge(Bracelet b)
    {

        return Integer.parseInt((String) convertParameters(b)[1]);

    }

    public int getThresholdPresureMin(Bracelet b){

        return Integer.parseInt((String) convertParameters(b)[2]);
    }

    public int getThresholdPresureMax(Bracelet b){

        return Integer.parseInt((String) convertParameters(b)[3]);
    }

    public Double getThresholdGlucoseMin(Bracelet b){

        return Double.valueOf((String) convertParameters(b)[4]);
    }

    public Double getThresholdGlucoseMax(Bracelet b){

        return Double.valueOf((String)(convertParameters(b)[5]));
    }

    public int  getNbOfValue(Bracelet b){

        return Integer.valueOf((String) convertParameters(b)[6]);
    }

    public Long getTimeUpdate(Bracelet b){

        Long timeUpdate= Long.valueOf((String) convertParameters(b)[7]);
        return timeUpdate;
    }
    public int getStandarDeviation(Bracelet b) {

        return Integer.valueOf((String) convertParameters(b)[8]);
    }


}