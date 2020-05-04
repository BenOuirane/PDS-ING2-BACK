/**
 * 
 */
package com.application.aled.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.application.aled.controller.exception.CustomHandler;
import com.application.aled.entity.CurrentArea;
import com.application.aled.service.CurrentAreaService;
import com.application.aled.service.bracelet.BraceletService;

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
		logger.info("Generating current areas in current area table..");
		for (int i = 1; i < 10; i++) {
			CurrentArea currentarea = new CurrentArea();
			// currentarea.setId_bracelet(i);
			// currentarea.setDate(LocalDateTime.now());
			// currentAreaService.addLocation(currentarea);
		}
		logger.info("Data has been well generated in the table current area..");
		return ResponseEntity.ok().build();

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

	// TODO
	/*@GetMapping("/currentlocation/bracelet/{braceletId}")
	public CurrentArea getCurrentAreaBracelet(@PathVariable(name = "braceletId") int braceletId)
			throws NullPointerException {
		logger.info("Getting bracelet by id..");
		CurrentArea _area = currentAreaService.getCurrentAreaByBraceletId((braceletId));

		if (_area == null) {
			logger.error("There's no data in bracelet table..");
			throw new CustomHandler("Bracelet not found");

		} else {
			logger.info(_area.toString());
			return _area;

		}*/
	
/*	@GetMapping("/currentlocation/area/{areatId}")
	public CurrentArea getCurrentAreaSumPassage(@PathVariable(name = "braceletId") int braceletId) 
			throws NullPointerException {
		CurrentArea _area = currentAreaService.getAreaBraceletNbPassage(braceletId);
		if (_area == null) {
			logger.error("There's no data in bracelet table..");
			throw new CustomHandler("Bracelet not found");

		} else {
			logger.info(_area.toString());
			return _area;
		}
	}*/
	
	

	@GetMapping("/currentlocalion/year/{year}")
	public int getAreaByYear(@RequestParam(required = false)  String year) {
		int areaByYear = currentAreaService.getAreasByYear(year).size();
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