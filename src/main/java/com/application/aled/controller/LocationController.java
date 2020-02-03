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
import com.application.aled.entity.ReferentialLocation;
import com.application.aled.service.LocationService;

/**
 * @author ISMAIL EL HAMMOUD
 *
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class LocationController {
	
	@Autowired
	LocationService locationService;
	
	@GetMapping("/location")
	public List<ReferentialLocation> getAllPositions() {
		//System.out.println("Get all Position...");
		//logger.info("Getting all positions from position table...");
		List<ReferentialLocation> location = locationService.getAllLocation();

		//logger.info("Positions well extracted from postion table ...");
		return location;
	}
	
	@GetMapping("/location/{locationId}")
	public 	ReferentialLocation locationId(@PathVariable(name = "locationId") String positionId) throws NullPointerException {
		// logger.info("Getting this position" + positionId + "from position table...");
		 ReferentialLocation _idloc = locationService.getLocationById(Integer.parseInt(positionId));
		
		 if (_idloc == null) {
			//	logger.error("Id Position not found");
				throw new CustomHandler("ReferentialLocation not found");
			} else {
				System.out.println(_idloc.toString());
				
			//	logger.info(positionId + "is well referenced...");
				return _idloc;
			}
		}
	
	
	
	

}
