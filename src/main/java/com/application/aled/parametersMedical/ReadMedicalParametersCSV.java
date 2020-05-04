package com.application.aled.parametersMedical;


import com.application.aled.entity.Bracelet;
import com.application.aled.entity.Resident;
import com.application.aled.service.BraceletServiceImpl;
import com.application.aled.service.ResidentServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;




public class ReadMedicalParametersCSV {

    BraceletServiceImpl braceletService;

    ResidentServiceImpl residentService;

    private List<String> lstValues = Arrays.asList();
    private List<Bracelet> lstBracelet=new ArrayList<>();
    private List<Resident> listResidents = new ArrayList<>();
    HashMap<String, List<String>> hsmp;

    Logger logger = LogManager.getLogger(ReadMedicalParametersCSV.class.getName());

    public ReadMedicalParametersCSV(BraceletServiceImpl braceletService, ResidentServiceImpl residentService) {

        this.braceletService=braceletService;
        this.residentService=residentService;
    }

    public void ReadingCSVfiles() {

        String csvFile = "src/main/resources/com/application/aled/support.files/MedicalParameters.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            hsmp = new HashMap<String, List<String>>();

            while ((line = br.readLine()) != null)
            {
                String[] split = line.split(cvsSplitBy);

                lstValues = new ArrayList<String>();

                for (int i = 1; i < split.length; i++)
                {
                    lstValues.add(split[i]);
                }

                hsmp.put(split[0], lstValues);

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

    public List<Resident> getListResidents(){

        Set<Map.Entry<String, List<String>>> entrySet =
                hsmp.entrySet();

        Iterator<Map.Entry<String, List<String>>> iterator =
                entrySet.iterator();

        while(iterator.hasNext()) {

            Map.Entry<String, List<String>> entry = iterator.next();
            for (Resident r : residentService.getAllResidents()) {

                if (entry.getKey().equalsIgnoreCase(r.getLastName())) {
                    listResidents.add(r);
                }
            }
        }
        return listResidents;
    }

    public List<Bracelet> getListBracelets(){
        for(Resident r : getListResidents()){
            for(Bracelet b : braceletService.getAllBracelets()){
                if(r.getIdResident()==(b.getResidents().getIdResident())){
                    lstBracelet.add(b);
                }
            }
        }
        System.out.println(lstBracelet);
        return lstBracelet;
    }


    public Object[] retrieveParameters(Bracelet b)
    {
        List<String> valuesParameters= new ArrayList<>();

        Set<Map.Entry<String, List<String>>> entrySet =
                hsmp.entrySet();

        Iterator<Map.Entry<String, List<String>>> iterator =
                entrySet.iterator();

        while(iterator.hasNext()) {

            Map.Entry<String, List<String>> entry = iterator.next();
            if (entry.getKey().equals(b.getResidents().getLastName())) {

                valuesParameters = entry.getValue();

            }
        }


        return valuesParameters.toArray();
    }


    public String getProgram(Bracelet b){

        return (String) retrieveParameters(b)[0];
    }

    public int getThresholdPressureMin(Bracelet b){

        return Integer.parseInt((String) retrieveParameters(b)[1]);
    }

    public int getThresholdPressureMax(Bracelet b){

        return Integer.parseInt((String) retrieveParameters(b)[2]);
    }

    public Double getThresholdGlucoseMin(Bracelet b){

        return Double.valueOf((String) retrieveParameters(b)[3]);
    }

    public Double getThresholdGlucoseMax(Bracelet b){

        return Double.valueOf((String)(retrieveParameters(b)[4]));
    }

    public int  getNbOfValue(Bracelet b){

        return Integer.valueOf((String) retrieveParameters(b)[5]);
    }

    public Long getTimeUpdate(Bracelet b){

        Long timeUpdate= Long.valueOf((String) retrieveParameters(b)[6]);
        return timeUpdate;
    }
    public Double getStandarDeviation(Bracelet b) {

        return Double.valueOf((String) retrieveParameters(b)[7]);
    }


}
