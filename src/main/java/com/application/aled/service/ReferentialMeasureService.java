/**
 * 
 */
package com.application.aled.service;

import java.util.List;

import com.application.aled.entity.ReferentialMeasure;

/**
 * @author ISMAIL EL HAMMOUD
 *
 */
public interface ReferentialMeasureService {
	public List<ReferentialMeasure> getAllReferentialMeasures();
	 void addMeasureRef(ReferentialMeasure refMeasu); 
	 void updateMeasureRef(ReferentialMeasure refMeasu);
	 void removeMeasureRef(ReferentialMeasure refMeasu);
}
