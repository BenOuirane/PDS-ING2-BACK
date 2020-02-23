package com.application.aled.service;
import com.application.aled.entity.Area;

import java.util.List;

public interface AreaService {
	
	public List<Area> getAllAreas();
	public Area getAreasById(int code);
	void addArea (Area area);
	void updateArea (Area area);
	void removeArea (Area area);
}
