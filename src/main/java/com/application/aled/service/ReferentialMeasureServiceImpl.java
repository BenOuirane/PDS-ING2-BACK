/**
 * 
 */
package com.application.aled.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.application.aled.entity.Measure;
import com.application.aled.entity.ReferentialMeasure;
import com.application.aled.entity.ReferentialResident;
import com.application.aled.repository.ReferentialMeasureRepository;

/**
 * @author ISMAIL EL HAMMOUD
 *
 */
public class ReferentialMeasureServiceImpl implements ReferentialMeasureService {

	@Autowired
	private ReferentialMeasureRepository measureRefRepository;
	
	@Override
	public List<ReferentialMeasure> getAllReferentialMeasures() {
		List<ReferentialMeasure> refmeasureslist = new ArrayList<ReferentialMeasure>();
		measureRefRepository.findAll().forEach(refmeasureslist::add);

		return refmeasureslist;
	}

	@Override
	public void addMeasureRef(ReferentialMeasure refMeasu) {
		if(refMeasu == null) {
			//FIXME: action non autorisee
			return;
		}
		measureRefRepository.save(refMeasu);
		
	}
		
	

	@Override
	public void updateMeasureRef(ReferentialMeasure refMeasu) {
		if(refMeasu == null) {
			//FIXME: action non autorisee
			return;
		}
		measureRefRepository.save(refMeasu);
		
	}
		

	@Override
	public void removeMeasureRef(ReferentialMeasure refMeasu) {
		measureRefRepository.delete(refMeasu);
		
	}

}
