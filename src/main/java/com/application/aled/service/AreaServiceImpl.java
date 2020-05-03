package com.application.aled.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.application.aled.entity.Area;
import com.application.aled.repository.AreaRepository;

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

	//The second way to do mocks, csv and this short algo
	@Override
	public void addArea(Area area) {
		/*if(area ==null) {
			for (int i=0; i<=10; i++) {
				area = new Area();
				area.setArea_id((long) 10);
				area.setName("Chamrbe" + i);
				area.setId_capteur("Capteur" + i);
				area.setSurface(17.58);
			return ;	
		}
			areaRepository.save(area);
		}*/
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
		// FIXME: unauthorized action
	}

	/*@Override
	public Area getAreasById(Long code) {
		Area area = areaRepository.findAreaByCode(code);
		return area;
	}
	*/
	/*@Override
	public Area getAreaByName(String areaname) {
		Area area = areaRepository.findAreaByName(areaname);
		return area;
	}
	
	 @Override
	 public Area getAreaDetails(Area areadetails) {
		 Area area = areaRepository.findAreaDetails(areadetails);
		 return area;
	 }*/

}
