package com.application.aled.controller;

import java.time.LocalDateTime;
import java.util.List;

import com.application.aled.service.PositionService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.application.aled.controller.exception.CustomHandler;
import com.application.aled.entity.Position;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class PositionController {
	
	static final Logger logger = LogManager.getLogger(ReferentialPositionController.class.getName());

	@Autowired
	PositionService positionService;

	@GetMapping("/positions")
	public List<Position> getAllPositions() {
		//System.out.println("Get all Position...");
		logger.info("Getting all positions from position table...");
		List<Position> positions = positionService.getAllPositions();

		logger.info("Positions well extracted from postion table ...");
		return positions;
	}
	
	@GetMapping("/positions/{positionId}")
	public Position positionId(@PathVariable(name = "positionId") String positionId) throws NullPointerException {
		 logger.info("Getting this position" + positionId + "from position table...");
		 Position _idpos = positionService.getPositionById(Integer.parseInt(positionId));
		
		 if (_idpos == null) {
				logger.error("Id Position not found");
				throw new CustomHandler("Position not found");
			} else {
				System.out.println(_idpos.toString());
				
				logger.info(positionId + "is well referenced...");
				return _idpos;
			}
		}
	@RequestMapping(value = "/generate_positions", method= RequestMethod.POST)
	public ResponseEntity<Void> createDataMock(){
		System.out.println("generating positions");
		logger.info("Positions were generated into position table...");

		for (int i=1; i<1000; i++) {
			Position position = new Position();
			position.setId(i++);
			position.setLat_pos(1.2);
			position.setLong_pos(14.697);
			position.setDate_pos(LocalDateTime.now());
			position.setRef_pos(null);
			
			positionService.addPosition(position);
		}
		logger.info("Positions were generated into position table...");
		return ResponseEntity.ok().build();
	}
	
	
	


}