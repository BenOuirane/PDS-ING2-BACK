package com.application.aled.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.application.aled.entity.ReferentialPosition;

public interface ReferentialPositionService {
	
	 public List<ReferentialPosition> getAllReferentialPositions();

}
