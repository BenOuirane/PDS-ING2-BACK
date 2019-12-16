package com.application.aled.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.auditing.CurrentDateTimeProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.application.aled.controller.exception.CustomHandler;
import com.application.aled.entity.ReferentialPosition;
import com.application.aled.service.ReferentialPositionService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class ReferentialPositionController {
	private int i =1;
	static final Logger logger = LogManager.getLogger(ReferentialPositionController.class.getName());
	@Autowired
	ReferentialPositionService referentialPositionService;

	@GetMapping("/referential_postion")
	public List<ReferentialPosition> getAllReferentialPostions() {
		//System.out.println("Get all Referential Positons...");
		logger.info("Getting all positions from the referential");
		List<ReferentialPosition> refpositions = referentialPositionService.getAllReferentialPositions();
		logger.info("Positions well found");
		return refpositions;
	}
	
	@GetMapping("/referential_positions/{positionId}")
	public ReferentialPosition referentialPositionId(@PathVariable(name = "positionId") String positionId) throws NullPointerException{
		 logger.info("Getting this position" + positionId + "from the referential...");

		ReferentialPosition _refposition = referentialPositionService.getPositionById(Integer.parseInt(positionId));

		if (_refposition == null) {
			logger.error("Ref Position not found");
			throw new CustomHandler("Position not found");
		} else {
			System.out.println(_refposition.toString());
			logger.info(positionId + "is well referenced...");
			return _refposition;
		}
	}
	

	// the following method will allow us to generate several referential positions
	// it will help us to mock data
	@RequestMapping( value = "/generate_referential_position", method = RequestMethod.POST)
	public ResponseEntity<Void> createDataMock() {
		 logger.info("Generating positions into the referential...");
		for ( i=1; i<100; i++) {
			ReferentialPosition refposition = new ReferentialPosition();
			refposition.setId(i++);
			refposition.setName("Piece" + Math.random());
			refposition.setSurface(5.2);
			refposition.setEmplacement("1");
			refposition.setWipDate(LocalDateTime.now());
			refposition.setUpDate(LocalDateTime.now());
			referentialPositionService.addPositionRef(refposition);
			}
		 logger.info("Positions were generated into the referential...");
		return ResponseEntity.ok().build();

	}
	
	@RequestMapping(value ="/update_referential_position" , method = RequestMethod.POST)
	public ResponseEntity<Void> updateDataMock() {
		
		for ( i=1; i<50; i++) {
			 logger.info("Update position into the referential...");
			ReferentialPosition refposition = new ReferentialPosition();
			refposition.setEmplacement("2");
			refposition.setName("Couloir");
			referentialPositionService.addPositionRef(refposition);
		}
		// logger.info("Position is updated ...");
		return ResponseEntity.ok().build();
	}
	
	
}
