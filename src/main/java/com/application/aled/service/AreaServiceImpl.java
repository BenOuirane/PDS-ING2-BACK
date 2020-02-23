package com.application.aled.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.aled.entity.Area;
import com.application.aled.repository.AreaRepository;
import com.application.aled.repository.CurrentAreaRepository;

@Service
public class AreaServiceImpl implements AreaService {
	@Autowired
	AreaRepository areaRepository;
	
	@Override
	public List<Area> getAllAreas() {
		List<Area> arealist = new ArrayList<Area>();
		areaRepository.findAll().forEach(arealist::add);
		return arealist;
	}

	@Override
	public void addArea(Area area) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateArea(Area area) {
		if (area == null) {
			// FIXME: action non autorisee
			return;
		}
		areaRepository.save(area);

	}
		
	@Override
	public void removeArea(Area area) {
		areaRepository.delete(area);
		
	}

	@Override
	public Area getAreasById(int code) {
		// TODO Auto-generated method stub
		return null;
	}

}
