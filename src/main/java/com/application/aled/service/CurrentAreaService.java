package com.application.aled.service;

import java.util.List;


import com.application.aled.entity.CurrentArea;


public interface CurrentAreaService {
	
	public List<CurrentArea> getAllAreas();
	
	public CurrentArea getCurrentAreaById(int idarea);
	public CurrentArea getCurrentAreaByBraceletId(int idbrac);


	void addArea(CurrentArea idarea);

	void updateArea(CurrentArea idarea);

	void removeArea(CurrentArea idarea);
	
	//public List<CurrentArea> getAreaBraceletNbPassage(int bracelet_id);

	public List<CurrentArea> getAreasByYear(String year);

	public List<CurrentArea> getAreasByYearAndMonth(int year, int month);

	public List<CurrentArea> getAreasByDay(int year, int month, int day);

	public  int[] getSumAreaBracelet();
	public List<CurrentArea> getAreasByBracelet(Long idbrac);

}