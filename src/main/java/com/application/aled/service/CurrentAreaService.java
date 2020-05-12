package com.application.aled.service;

import java.util.List;

import com.application.aled.entity.Bracelet;
import com.application.aled.entity.CurrentArea;


public interface CurrentAreaService {
	
	public List<CurrentArea> getAllAreas();
	public List<CurrentArea> getAreas();
	public CurrentArea getCurrentAreaById(int idarea);
	
	public CurrentArea[] getCurrentAreaByBracelet(Bracelet idbrac);
	
	public CurrentArea[]  getAreaBraceletNbPassage(Bracelet bracelet);

	public  List<CurrentArea> getSumAreaBracelet(int idbrac);
	
	void addArea(CurrentArea idarea);

	void updateArea(CurrentArea idarea);

	void removeArea(CurrentArea idarea);
	

	public List<CurrentArea> getAreasByYear(String year);

	public List<CurrentArea> getAreasByYearAndMonth(int year, int month);

	public List<CurrentArea> getAreasByDay(int year, int month, int day);



}