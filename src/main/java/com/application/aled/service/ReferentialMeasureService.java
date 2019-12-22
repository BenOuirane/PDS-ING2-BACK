/**
 * 
 */
package com.application.aled.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.application.aled.entity.ReferentialMeasure;

/**
 * @author ISMAIL EL HAMMOUD
 *
 */



//this service will be removed


public interface ReferentialMeasureService {
	public List<ReferentialMeasure> getAllReferentialMeasures();

	void addMeasureRef(ReferentialMeasure refMeasu);

	void updateMeasureRef(ReferentialMeasure refMeasu);

	void removeMeasureRef(ReferentialMeasure refMeasu);
}
