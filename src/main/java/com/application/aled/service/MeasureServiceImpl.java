/**
 * 
 */
package com.application.aled.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.aled.entity.Measure;
import com.application.aled.entity.ReferentialPosition;
import com.application.aled.repository.MeasureRepository;

/**
 * @author ISMAIL EL HAMMOUD
 *
 */

//this impl will be removed
@Service
public class MeasureServiceImpl implements MeasureService {
	@Autowired
	MeasureRepository measureRepository;

	@Override
	public List<Measure> getAllMeasures() {
		List<Measure> measlist = new ArrayList<Measure>();

		measureRepository.findAll().forEach(measlist::add);
		return measlist;
	}

	@Override
	public void addMeasure(Measure measId) {
		if (measId == null) {
			// FIXME: action non autorisee

			return;
		}
		measureRepository.save(measId);

	}

	@Override
	public void updateMeasure(Measure measId) {
		if (measId == null) {
			// FIXME: action non autorisee

			return;
		}
		measureRepository.save(measId);
	}

	@Override
	public void removeMeasure(Measure measId) {
		measureRepository.delete(measId);
		
	}

}
