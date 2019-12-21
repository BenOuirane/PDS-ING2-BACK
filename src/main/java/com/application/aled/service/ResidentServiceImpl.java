/**
 * 
 */
package com.application.aled.service;

import java.util.ArrayList;
import java.util.List;

import com.application.aled.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.aled.entity.Residents;
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
	public List<Residents> getAllResidents() {
		List<Residents> reslist = new ArrayList<Residents>();

		//residentRepository.findAll().forEach(reslist::add);
		return reslist;
	}


	@Override
	public void addResident(Residents idResi) {
		if (idResi == null) {
			// FIXME: action non autorisee

			return;
		}
		//residentRepository.save(idResi);

	}

	@Override
	public void updateResident(Residents idResi) {
		if (idResi == null) {
			// FIXME: action non autorisee

			return;
		}
		//residentRepository.save(idResi);

	}

	@Override
	public void removeResident(Residents idResi) {
		//residentRepository.delete(idResi);

	}

	@Override
	public Residents getResidentByUser(User user) {
		return residentRepository.findByUser(user);
	}

}
