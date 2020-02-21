package com.application.aled.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class ReadMedicalParametersCSV {

    List<String> braceletID;
    List<String> lstValues = Arrays.asList();
    HashMap<String, List<String>> hsmp;
    Map<String, HashMap<String, List<String>>> hsmp2 ;
    Double Tab[]=new Double[10];;

    private String program = "";
    static final Logger logger = LogManager.getLogger(ReadMedicalParametersCSV.class.getName());

    public ReadMedicalParametersCSV() {
        ReadingCSVfiles();
    }

    public void ReadingCSVfiles() {

        String csvFile = "src/main/java/com/application/aled/controller/MedicalParameters.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            //System.out.println(br.readLine());
            hsmp2=new HashMap<String, HashMap<String, List<String>>>();

            while ((line = br.readLine()) != null) {


                String[] split = line.split(cvsSplitBy);
                lstValues= new ArrayList<String>();
                for (int i = 2; i < split.length; i++) {

                    lstValues.add(split[i]);
                }
                hsmp =new HashMap<String, List<String>>();
                hsmp.put(split[1],lstValues);
                hsmp2.put(split[0],hsmp);

            }

        } catch (FileNotFoundException e) {
            logger.info(e.getMessage());
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

    public List<String> getListBracelet() {

        braceletID =new ArrayList<String>() ;
        braceletID.addAll(hsmp2.keySet());
        return braceletID;
    }

    public String getProgram(Integer idBracelet){

        List<Double> valuesParameters=null;
        List<Map.Entry<String, List<String>>> myList = null;
        String prog="";

        for (Map.Entry<String, HashMap<String, List<String>>> en : hsmp2.entrySet()) {

            if (idBracelet == Integer.parseInt(en.getKey()))
            {
                Map<String, List<String>> map2 = en.getValue();
                Set<Map.Entry<String, List<String>>> set2 = map2.entrySet();
                myList = new ArrayList<>(set2);

                for (Map.Entry<String, List<String>> ee : myList) {
                    prog = ee.getKey();

                }

            }
        }

        return prog;
    }

    public Object[] convertParameters(Integer idBracelet) {

        List<String> valuesParameters=null;
        List<Map.Entry<String, List<String>>> myList = null;

        for (Map.Entry<String, HashMap<String, List<String>>> en : hsmp2.entrySet()) {

            if (idBracelet == Integer.parseInt(en.getKey()))
            {
                Map<String, List<String>> map2 = en.getValue();
                Set<Map.Entry<String, List<String>>> set2 = map2.entrySet();
                myList = new ArrayList<>(set2);

                for (Map.Entry<String, List<String>> ee : myList) {
                    setProgram(ee.getKey());
                    valuesParameters = ee.getValue();
                }

                return valuesParameters.toArray();
            }
        }


        return null;
    }

    public int getAge(Integer idBracelet){

        int age=Integer.parseInt((String) convertParameters(idBracelet)[0]);
        return age;
    }

    public int getThresholdPresureMin(Integer idBracelet){

        return Integer.parseInt((String) convertParameters(idBracelet)[1]);
    }

    public int getThresholdPresureMax(Integer idBracelet){

        return Integer.parseInt((String) convertParameters(idBracelet)[2]);
    }

    public Double getThresholdGlucoseMin(Integer idBracelet){

        return Double.valueOf((String) convertParameters(idBracelet)[3]);
    }
    public Double getThresholdGlucoseMax(Integer idBracelet){

        return Double.valueOf((String)(convertParameters(idBracelet)[4]));
    }

    public int  getNbOfValue(Integer idBracelet){

        return Integer.valueOf((String) convertParameters(idBracelet)[5]);
    }

    public Long getTimeUpdate(Integer idBracelet){

        Long timeUpdate= Long.valueOf((String) convertParameters(idBracelet)[6]);
        return timeUpdate;
    }
    public int getStandarDeviation(Integer idBracelet) {

        return Integer.valueOf((String) convertParameters(idBracelet)[7]);
    }

    public List<String> getBraceletID() {
        return braceletID;
    }

    public void setBraceletID(List<String> braceletID) {
        this.braceletID = braceletID;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    /*public static void main(String[] args) {
        ReadCSV r = new ReadCSV();
        System.out.println(r.getListBracelet());

    }*/


}