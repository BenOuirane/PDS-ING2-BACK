/**
 * 
 */
package com.application.aled.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.aled.entity.Measure;
import com.application.aled.entity.Resident;
import com.application.aled.repository.ResidentRepository;

/**
 * @author ISMAIL EL HAMMOUD
 *
 */

@Service
public class ResidentServiceImpl implements ResidentService {

	
	@Autowired
	ResidentRepository residentRepository;
	@Override
	public List<Resident> getAllResidents() {
		List<Resident> reslist = new ArrayList<Resident>();

		residentRepository.findAll().forEach(reslist::add);
		return reslist;
	}


	@Override
	public void addResident(Resident idResi) {
		if (idResi == null) {
			// FIXME: action non autorisee

			return;
		}
		residentRepository.save(idResi);

	}

	@Override
	public void updateResident(Resident idResi) {
		if (idResi == null) {
			// FIXME: action non autorisee

			return;
		}
		residentRepository.save(idResi);

	}

	@Override
	public void removeResident(Resident idResi) {
		residentRepository.delete(idResi);

	}

}
