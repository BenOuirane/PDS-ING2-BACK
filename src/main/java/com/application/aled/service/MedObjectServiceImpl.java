/**
 * 
 */
package com.application.aled.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.application.aled.entity.Measure;
import com.application.aled.entity.MedObject;
import com.application.aled.repository.MedObjectRepository;

/**
 * @author ISMAIL EL HAMMOUD
 *
 */
public class MedObjectServiceImpl implements MedObjectService {
	@Autowired
	MedObjectRepository medObjectRepository;

	@Override
	public List<MedObject> getAllMedObject() {
		List<MedObject> medobjlist = new ArrayList<MedObject>();

		medObjectRepository.findAll().forEach(medobjlist::add);
		return medobjlist;
	}

	@Override
	public void addMedObject(MedObject medObj) {
		if (medObj == null) {
			// FIXME: action non autorisee

			return;
		}
		medObjectRepository.save(medObj);

	}

	@Override
	public void updateMedObject(MedObject medObj) {
		if (medObj == null) {
			// FIXME: action non autorisee

			return;
		}
		medObjectRepository.save(medObj);

	}
	

	@Override
	public void removeMedObject(MedObject medObj) {
		medObjectRepository.delete(medObj);
	}

}
