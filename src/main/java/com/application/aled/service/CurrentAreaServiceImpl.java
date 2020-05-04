package com.application.aled.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.application.aled.entity.CurrentArea;
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
	public CurrentArea getCurrentAreaByBraceletId(int idbrac) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<CurrentArea> getAreasByYear(String year) throws NullPointerException{ 
        List<CurrentArea> areasYear = new ArrayList<>();   
        currentareaRepository.findAreaByYY(year).forEach(areasYear::add);
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
	public List<CurrentArea> getAreaBraceletNbPassage(int area_id) {
		List<CurrentArea> nbPassAreas = new ArrayList<>();
		currentareaRepository.findAreaBraceletSumTime(area_id);
		return nbPassAreas;
	}

}
