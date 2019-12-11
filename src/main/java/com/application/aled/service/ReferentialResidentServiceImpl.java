/**
 * 
 */
package com.application.aled.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.aled.entity.ReferentialResident;
import com.application.aled.repository.ReferentialResidentRepository;

/**
 * @author ISMAIL EL HAMMOUD
 *
 */
@Service
public class ReferentialResidentServiceImpl implements ReferentialResidentService {

	@Autowired
	private ReferentialResidentRepository referentialResidentRepository;

	@Override
	public List<ReferentialResident> getAllReferentialResidents() {
		List<ReferentialResident> refresidentslist = new ArrayList<ReferentialResident>();

		referentialResidentRepository.findAll().forEach(refresidentslist::add);
		return refresidentslist;
	}

	@Override
	public void addResidentRef(ReferentialResident refResi) {
		if (refResi == null) {
			// FIXME: action non autorisee
			return;
		}
		referentialResidentRepository.save(refResi);

	}

	@Override
	public void updateResidentRef(ReferentialResident refResi) {
		if (refResi == null) {
			// FIXME: action non autorisee
			return;
		}
		referentialResidentRepository.save(refResi);
	}

	@Override
	public void removeResidentRef(ReferentialResident refResi) {
		referentialResidentRepository.delete(refResi);

	}

}
