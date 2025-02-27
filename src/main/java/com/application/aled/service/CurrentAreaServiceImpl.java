package com.application.aled.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.aled.entity.Bracelet;
import com.application.aled.entity.CurrentArea;
import com.application.aled.entity.model.link.SumCurrentAreaBracelet;
import com.application.aled.repository.CurrentAreaRepository;

/**
 * @author ISMAIL EL HAMMOUD
 *
 */
@Service
public class CurrentAreaServiceImpl implements CurrentAreaService {

    @Autowired
    CurrentAreaRepository currentareaRepository;

    @Override
    public List<CurrentArea> getAllAreas() {
        List<CurrentArea> currentareaslist = new ArrayList<CurrentArea>();
        currentareaRepository.findAll().forEach(currentareaslist::add);
        return currentareaslist;
    }



    @Override
    public void removeArea(CurrentArea idlocation) {
        currentareaRepository.delete(idlocation);
    }

    @Override
    public void addArea(CurrentArea idarea) {
        if (idarea == null) {
			/*	idBrac = new Bracelet();
				idBrac.setId("Bracelet1_" + System.currentTimeMillis());
				idBrac.setIdResident("AK");
				idBrac.setLastSentData(LocalDateTime.now());
				idBrac.setRefBracelet("Fitbit01");*/

            // FIXME: unauthorized action
            return;
        }
        currentareaRepository.save(idarea);

    }
    @Override
    public void updateArea(CurrentArea idarea) {
        if (idarea == null) {
            // FIXME: unauthorized action
            return;
        }
        currentareaRepository.save(idarea);

    }

    @Override
    public CurrentArea getCurrentAreaById(int idarea) {
        // FIXME: unauthorized action
        return null;
    }



    @Override
    public CurrentArea[] getCurrentAreaByBracelet(Bracelet idbrac) {
        CurrentArea [] areas = currentareaRepository.findAreaByBracelet(idbrac);
        return areas;
    }



    @Override
    public List<CurrentArea> getAreasByYear(LocalDateTime year) throws NullPointerException{
        List<CurrentArea> areasYear = new ArrayList<>();
        currentareaRepository.findAreaByYY(year);
        return areasYear;

    }



    @Override
    public List<CurrentArea> getAreasByYearAndMonth(int year, int month)  throws NullPointerException{
        List<CurrentArea> areasYYMM = new ArrayList<>();
        currentareaRepository.findAreaByYYMM(year, month).forEach(areasYYMM::add);
        return areasYYMM;
    }



    @Override
    public List<CurrentArea> getAreasByDay(int year, int month, int day)  throws NullPointerException{
        List<CurrentArea> areasYYMMDD = new ArrayList<>();
        currentareaRepository.findAreaByYYMMDD(year, month, day).forEach(areasYYMMDD::add);
        return areasYYMMDD; }



    @Override
    public Map<Long, Long> getAreaBraceletNbPassage(Bracelet bracelet) {
        CurrentArea [] areas = currentareaRepository.findAreaByBracelet(bracelet);

        List<CurrentArea> listArea=Arrays.asList(areas);



        Map<Long, Long> counting = listArea.stream().collect(
                Collectors.groupingBy(CurrentArea::getAreaId, Collectors.counting()));



        //  System.out.println(counting);


        return counting;
    }



	/*@Override
	public List<CurrentArea> getSumAreaBracelet(int idbrac) {
		List<CurrentArea> sumPassageBraceletInArea = currentareaRepository.findallAreaBraceletd(idbrac);
		return sumPassageBraceletInArea;
	}*/



    @Override
    public List<CurrentArea> getAreas() {
        List<CurrentArea> areas = new ArrayList<CurrentArea>();
        currentareaRepository.findAll().forEach(areas::add);
        return areas;
    }







}
