package com.application.aled.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.application.aled.entity.Area;
import com.application.aled.service.area.AreaService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class AreaController {

	
	
	@Autowired
	AreaService areaService;
	
	
	@GetMapping("/areas/list")
	public List<Area> getAreas() {
	 List<Area> areas = areaService.getAllAreas();
	 return areas;

	}
	
	/*@GetMapping("/area/map")
	public List<Area> getAllAreas(@RequestBody String areas){
		List<Area> _areas = areaService.getAreaByName(areas);
		
	}*/
	
	/*@GetMapping("/areas/byname")
	public List<Area> findAreaByName(){
		Area areaName = areaService.findAreaByName();
		return areaName;
	}*/
}
