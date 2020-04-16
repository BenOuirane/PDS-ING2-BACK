package com.application.aled.service;

import java.time.LocalDateTime;
import java.util.List;

import com.application.aled.entity.Bracelet;
import com.application.aled.entity.CurrentArea;


public interface CurrentAreaService {
	
	public List<CurrentArea> getAllAreas();
	
	public CurrentArea getCurrentAreaById(int idarea);

	void addArea(CurrentArea idarea);

	void updateArea(CurrentArea idarea);

	void removeArea(CurrentArea idarea);

	public  CurrentArea findAreaByBraceletIdAndCross_date(int braceletId, LocalDateTime cross_date);

}