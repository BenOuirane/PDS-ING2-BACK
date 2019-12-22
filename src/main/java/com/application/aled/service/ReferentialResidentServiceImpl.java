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
//this impl will be removed
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
	
	public ReferentialResident getResidentById(int refResi) throws NullPointerException {
		System.out.println("Getting the reference of the Resident");
		ReferentialResident ref = referentialResidentRepository.findById(refResi).get();
		return ref;
	}

	

}
