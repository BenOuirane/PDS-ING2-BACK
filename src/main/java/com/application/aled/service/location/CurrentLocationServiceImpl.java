/**
 * 
 */
package com.application.aled.service.location;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.aled.entity.CurrentLocation;
import com.application.aled.repository.CurrentLocationRepository;

/**
 * @author ISMAIL EL HAMMOUD
 *
 */
@Service
public class CurrentLocationServiceImpl implements CurrentLocationService {

	@Autowired
	CurrentLocationRepository currentlocationRepository;
	@Override
	public List<CurrentLocation> getAllLocation() {
		List<CurrentLocation> currentlocationlist = new ArrayList<CurrentLocation>();

		currentlocationRepository.findAll().forEach(currentlocationlist::add);
		return currentlocationlist;
	}

	

	@Override
	public void removeLocation(CurrentLocation idlocation) {
		// TODO Auto-generated method stub
		currentlocationRepository.delete(idlocation);
	}

	@Override
	public void addLocation(CurrentLocation idlocation) {
		if (idlocation == null) {
			/*	idBrac = new Bracelet();
				idBrac.setId("Bracelet1_" + System.currentTimeMillis());
				idBrac.setIdResident("AK");
				idBrac.setLastSentData(LocalDateTime.now());
				idBrac.setRefBracelet("Fitbit01");*/
						
				// FIXME: action non autorisee
				return;
			}
		currentlocationRepository.save(idlocation);

		}
	@Override
	public void updateLocation(CurrentLocation idlocation) {
		if (idlocation == null) {
			// FIXME: action non autorisee
			return;
		}
		currentlocationRepository.save(idlocation);

	}



	@Override
	public CurrentLocation getLocationById(int idlocation) {
		// TODO Auto-generated method stub
		return null;
	}



}
