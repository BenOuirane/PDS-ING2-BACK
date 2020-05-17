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



}
