/**
 * 
 */
package com.application.aled.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.application.aled.controller.exception.CustomHandler;
import com.application.aled.entity.CurrentLocation;
import com.application.aled.service.CurrentLocationService;

/**
 * @author ISMAIL EL HAMMOUD
 *
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class CurrentLocationController {

	@Autowired
	CurrentLocationService currentLocationService;

	@GetMapping("/currentlocations")
	public List<CurrentLocation> getAllLocation() {
		// System.out.println("Get all Position...");
		// logger.info("Getting all positions from position table...");
		List<CurrentLocation> locations = currentLocationService.getAllLocation();

		// logger.info("Positions well extracted from postion table ...");
		return locations;
	}

	@GetMapping("/currentlocation/{locationId}")
	public CurrentLocation positionId(@PathVariable(name = "locationId") String locationId) throws NullPointerException {
		 //logger.info("Getting this position" + positionId + "from position table...");
		CurrentLocation _idlocation  = currentLocationService.getLocationById(Integer.parseInt(locationId));
		
		 if (_idlocation == null) {
				
				throw new CustomHandler("Position not found");
			} else {
				System.out.println(_idlocation.toString());
				
				
				return _idlocation;
			}
	}

	@RequestMapping(value = "/generate_currentlocations", method = RequestMethod.POST)
	public ResponseEntity<Void> createDataMock() {
		System.out.println("generating locations");

		for (int i = 1; i <10; i++) {
			CurrentLocation currentlocation = new CurrentLocation();
			currentlocation.setId_bracelet(i);
			currentlocation.setDate(LocalDateTime.now());
			currentlocation.setId_location(i+1);
			currentLocationService.addLocation(currentlocation);
		}
		return ResponseEntity.ok().build();
			
	}
}