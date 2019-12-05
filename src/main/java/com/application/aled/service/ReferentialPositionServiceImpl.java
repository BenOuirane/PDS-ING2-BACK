/**
 * 
 */
package com.application.aled.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.application.aled.entity.ReferentialPosition;
import com.application.aled.repository.PositionRepository;
import com.application.aled.repository.ReferentialPositionRepository;

/**
 * @author ISMAIL EL HAMMOUD
 *
 */
public class ReferentialPositionServiceImpl implements ReferentialPositionService {
	@Autowired
	ReferentialPositionRepository repository;
	
	@Override
	public List<ReferentialPosition> getAllReferentialPositions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addPositionRef(ReferentialPosition refPosi) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateResidentRef(ReferentialPosition refPosi) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeResidentRef(ReferentialPosition refPosi) {
		// TODO Auto-generated method stub
		
	}
	
	//@Override
	//public void addPositionRef()

}
