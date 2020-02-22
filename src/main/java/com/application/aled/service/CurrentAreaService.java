package com.application.aled.service;

import java.util.List;


import com.application.aled.entity.CurrentArea;


public interface CurrentAreaService {
	
	public List<CurrentArea> getAllAreas();
	
	public CurrentArea getCurrentAreaById(int idarea);

	void addArea(CurrentArea idarea);

	void updateArea(CurrentArea idarea);

	void removeArea(CurrentArea idarea);

}