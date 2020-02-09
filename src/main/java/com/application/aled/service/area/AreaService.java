package com.application.aled.service.area;
import com.application.aled.entity.Area;

import java.util.List;

public interface AreaService {
	
	public List<Area> getAllAreas();
	public Area getAreaByName(String name);
	void addArea (Area area);
	void updateArea (Area area);
	void removeArea (Area area);
}
