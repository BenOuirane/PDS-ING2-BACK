/**
 * 
 */
package com.application.aled.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.application.aled.entity.Measure;
import com.application.aled.repository.MeasureRepository;

/**
 * @author ISMAIL EL HAMMOUD
 *
 */
public class MeasureServiceImpl implements MeasureService {
	@Autowired
	MeasureRepository repository;

	@Override
	public List<Measure> getAllMeasures() {
		// TODO Auto-generated method stub
		return null;
	}

}
