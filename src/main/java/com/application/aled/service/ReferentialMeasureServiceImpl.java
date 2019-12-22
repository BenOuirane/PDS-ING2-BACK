/**
 * 
 */
package com.application.aled.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.aled.entity.Measure;
import com.application.aled.entity.ReferentialMeasure;
import com.application.aled.repository.ReferentialMeasureRepository;

/**
 * @author ISMAIL EL HAMMOUD
 *
 */

//this impl will be removed
@Service
public class ReferentialMeasureServiceImpl implements ReferentialMeasureService {

	@Autowired
	private ReferentialMeasureRepository referentialMeasureRepository;

	@Override
	public List<ReferentialMeasure> getAllReferentialMeasures() {
		List<ReferentialMeasure> refmeasureslist = new ArrayList<ReferentialMeasure>();
		referentialMeasureRepository.findAll().forEach(refmeasureslist::add);

		return refmeasureslist;
	}

	@Override
	public void addMeasureRef(ReferentialMeasure refMeasu) {
		if (refMeasu == null) {
			// FIXME: action non autorisee
			return;
		}
		referentialMeasureRepository.save(refMeasu);

	}

	@Override
	public void updateMeasureRef(ReferentialMeasure refMeasu) {
		if (refMeasu == null) {
			// FIXME: action non autorisee
			return;
		}
		referentialMeasureRepository.save(refMeasu);

	}

	@Override
	public void removeMeasureRef(ReferentialMeasure refMeasu) {
		referentialMeasureRepository.delete(refMeasu);

	}

}
