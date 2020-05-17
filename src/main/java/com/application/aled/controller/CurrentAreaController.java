/**
 * 
 */
package com.application.aled.controller;

import java.time.LocalDateTime;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.application.aled.controller.exception.CustomHandler;
import com.application.aled.entity.CurrentArea;
import com.application.aled.service.CurrentAreaService;

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

	@GetMapping("/currentlocations")
	@ResponseBody
	public ResponseEntity<List<CurrentArea>> getAllLocation() {
		logger.info("Getting all current areas from current area table...");
		List<CurrentArea> locations = currentAreaService.getAllAreas();
		logger.info("Positions well extracted from current area table ...");
		//TODO here we use a design pattern called XXX 
		return ResponseEntity.ok(locations);
	}

	@GetMapping("/currentlocation/{locationId}")
	public CurrentArea positionId(@PathVariable(name = "locationId") String locationId) throws NullPointerException {
		logger.info("Getting this area" + locationId + "from current area table...");
		CurrentArea _idlocation  = currentAreaService.getCurrentAreaById(Integer.parseInt(locationId));
		if (_idlocation == null) {
				
				throw new CustomHandler("Area not found");
			} else {
				logger.info(_idlocation.toString());
				return _idlocation;
			}
	}

	@RequestMapping(value = "/generate_currentlocations", method = RequestMethod.POST)
	public ResponseEntity<Void> createDataMock() {
		logger.info("Generating current areas in current area table..");
		for (int i = 1; i <10; i++) {
			CurrentArea currentarea = new CurrentArea();
			//currentarea.setId_bracelet(i);
			//currentarea.setDate(LocalDateTime.now());
			//currentAreaService.addLocation(currentarea);
		}
		logger.info("Data has been well generated in the table current area..");
		return ResponseEntity.ok().build();
			
	}
	
	//TODO add the other methods
}