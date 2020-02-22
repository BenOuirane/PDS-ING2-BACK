package com.application.aled.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.application.aled.controller.exception.CustomHandler;
import com.application.aled.entity.Area;
import com.application.aled.entity.Bracelet;
import com.application.aled.service.AreaService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class AreaController {

	
	static final Logger logger = LogManager.getLogger(AreaController.class.getName());
	
	@Autowired
	AreaService areaService;
	
	
	@GetMapping("/areas/list")
	@ResponseBody
	public ResponseEntity<List<Area>> getAreas() {
		logger.info("Getting all areas from area table...");
		List<Area> areas = areaService.getAllAreas();
		logger.info("Positions well extracted from area table ...");
		return ResponseEntity.ok(areas);

	}
			
	@GetMapping("/areas/byname")
	
	public Area areaCode(@PathVariable(name = "areaCode")  int areaCode) throws NullPointerException {
		logger.info("Getting area by code..");
		Area _area = areaService.getAreasById((areaCode));
		
		if (_area == null) {
			logger.error("There's no data in area table..");
			throw new CustomHandler("Area not found");

		} else {
			logger.info(_area.toString());
			return _area;
		}
	}
	
	
	
	
	//TODO add the other methods once it's confirmed with profs
}
