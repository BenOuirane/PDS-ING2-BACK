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
import com.application.aled.entity.Bracelet;
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

	//TODO to send to audit
	@GetMapping("/currentlocations")
	@ResponseBody
	public ResponseEntity<List<CurrentArea>> getAllLocation() {
		logger.info("Getting all current areas from current area table...");
		List<CurrentArea> locations = currentAreaService.getAllAreas();
		logger.info("Positions well extracted from current area table ...");
		//TODO here we use a design pattern 
		return ResponseEntity.ok(locations);
	}

	
	//TODO to send to audit
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
	@RequestMapping(path = "/track/{braceletId}/date/{crossDate}",  method=RequestMethod.GET)
	public CurrentArea findBraceletArea(@PathVariable int braceletId, @PathVariable LocalDateTime crossDate)
																throws NullPointerException {
		logger.info("Getting bracelet by id..");
		System.out.println("Here");
		CurrentArea _braceletArea = currentAreaService.findAreaByBraceletIdAndCross_date(braceletId, crossDate);
		System.out.println("here2");
		if (_braceletArea == null) {
			logger.error("There's no data in the table..");
			throw new CustomHandler("Bracelet not found");

		} else {
			logger.info(_braceletArea.toString());
			return _braceletArea;
		}
	}
	
	
	
	
	
	
	//TODO add the other methods
	//TODO sending to audit is not an emergency.. could be done at the end
}