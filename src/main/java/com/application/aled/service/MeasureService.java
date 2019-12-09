package com.application.aled.service;

import java.util.List;

import com.application.aled.entity.Measure;
import com.application.aled.entity.ReferentialPosition;

public interface MeasureService {

	public List<Measure> getAllMeasures();
	
	void addMeasure(Measure measId);
	void updateMeasure(Measure measId);
	void removeMeasure(Measure measId);

	

}
