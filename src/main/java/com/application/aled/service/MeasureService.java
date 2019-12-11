package com.application.aled.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.application.aled.entity.Measure;



public interface MeasureService {

	public List<Measure> getAllMeasures();
	
	void addMeasure(Measure measId);
	void updateMeasure(Measure measId);
	void removeMeasure(Measure measId);

	

}
