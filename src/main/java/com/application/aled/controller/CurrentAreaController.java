/**
 * 
 */
package com.application.aled.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.aled.controller.exception.CustomHandler;
import com.application.aled.entity.Bracelet;
import com.application.aled.entity.CurrentArea;
import com.application.aled.service.BraceletService;
import com.application.aled.service.CurrentAreaService;
import com.application.aled.service.ResidentService;

/**
 * @author ISMAIL EL HAMMOUD
 *
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class CurrentAreaController {

	static final Logger logger = LogManager.getLogger(CurrentAreaController.class.getName());

	@Autowired
	CurrentAreaService currentAreaService;

	@Autowired
	BraceletService braceletService;
	
	@Autowired
	ResidentService residentService;


	@GetMapping("/currentlocations")
	@ResponseBody
	public ResponseEntity<List<CurrentArea>> getAllLocation() {
		logger.info("Getting all current areas from current area table...");
		List<CurrentArea> locations = currentAreaService.getAllAreas();
		logger.info("Positions well extracted from current area table ...");
		// TODO here we use a design pattern
		return ResponseEntity.ok(locations);
	}

	@RequestMapping(value = "/generate_currentlocations", method = RequestMethod.POST)
	public ResponseEntity<Void> createDataMock() {
		Random rd = new Random();
		logger.info("Generating current areas in current area table..");
		for (int i = 1; i < 10; i++) {
			CurrentArea currentarea = new CurrentArea();
			//currentarea.setArea(i++);
			
		}
		logger.info("Data has been well generated in the table current area..");
		return ResponseEntity.ok().build();

	}

	 @GetMapping(value = "/current_area_size")
	 public int getAreaSize() {
		logger.info("Getting current area size from current area table...");
		 int areas = currentAreaService.getAreas().size();
	     return areas;
	  }

	 
	 

	@GetMapping("/currentlocation/{locationId}")
	public CurrentArea positionId(@PathVariable(name = "locationId") String locationId) throws NullPointerException {
		logger.info("Getting this area" + locationId + "from current area table...");
		CurrentArea _idlocation = currentAreaService.getCurrentAreaById(Integer.parseInt(locationId));
		if (_idlocation == null) {

			throw new CustomHandler("Area not found");
		} else {
			logger.info(_idlocation.toString());
			return _idlocation;
		}
	}

	
	@GetMapping("/currentlocation/bracelet/list")
	public CurrentArea [] getCurrentAreaBracelet(@RequestBody Bracelet bracelet)
			throws NullPointerException {
		logger.info("Getting bracelet by id..");
		CurrentArea[] _area = currentAreaService.getCurrentAreaByBracelet((bracelet));

		if (_area == null) {
			logger.error("There's no data in bracelet table..");
			throw new CustomHandler("Bracelet not found");

		} else {
			logger.info(_area.toString());
			return _area;

		}
	}
	
	@GetMapping("/currentlocation/visits/{bracelet_id}")
	public CurrentArea[] getCurrentAreaSumPassage(@PathVariable(name = "bracelet_id") Bracelet bracelet) 
			throws NullPointerException {
		logger.info("Getting bracelet by id..");
		CurrentArea[] _area = currentAreaService.getAreaBraceletNbPassage(bracelet);
		if (_area == null) {
			logger.error("There's no data in bracelet table..");
			throw new CustomHandler("Bracelet not found");

		} else {
			logger.info(_area.toString());
			return _area;
		}
	}
	
	
	@GetMapping("/currentlocation/areabracelet/{bracelet_id}")
	public CurrentArea [] getSumPassageAreaBracelet(@PathVariable(name = "bracelet_id") Bracelet bracelet) 
			throws NullPointerException {
		CurrentArea [] sumPassage = currentAreaService.getSumAreaBracelet(bracelet);
		return sumPassage;
		
	}
	
	

	@GetMapping("/currentlocalion/year/{year}")
	public List<CurrentArea> getAreaByYear(@RequestParam(required = false)  LocalDateTime year) {
		List<CurrentArea> areaByYear = currentAreaService.getAreasByYear(year);
		return areaByYear;
	}

	@GetMapping("currentlocation/month/")
	public int getAreaByYearAndMonth(@RequestParam int year, int month) {
		int areaByMonth = currentAreaService.getAreasByYearAndMonth(year, month).size();
		return areaByMonth;
	}

	@GetMapping("currentlocation/day")
	public int getAreaByDay(@RequestParam int year, int month, int day) {
		int areaByDay = currentAreaService.getAreasByDay(year, month, day).size();
		return areaByDay;
	}

}