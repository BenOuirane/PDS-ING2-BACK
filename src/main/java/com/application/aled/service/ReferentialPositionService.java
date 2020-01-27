package com.application.aled.service;

import java.util.List;

import com.application.aled.entity.ReferentialPosition;


public interface ReferentialPositionService {

	public List<ReferentialPosition> getAllReferentialPositions();

	void addPositionRef(ReferentialPosition refPosi);

	void updatePositionRef(ReferentialPosition refPosi);
	void removePositionRef(ReferentialPosition refPosi);
	public ReferentialPosition getPositionById(int refPosi);


}
