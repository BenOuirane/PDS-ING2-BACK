package com.application.aled.service;
import com.application.aled.entity.Area;

import java.util.List;

import org.springframework.stereotype.Service;



public interface AreaService {
	
	public List<Area> getAllAreas();
	//public Area getAreasById(Long code);
	void addArea (Area area);
	void updateArea (Area area);
	void removeArea (Area area);
	//public Area getAreaByName(String areaname);
	//public Area getAreaDetails(Area area);

}
