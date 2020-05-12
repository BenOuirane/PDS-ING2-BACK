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
import org.springframework.jdbc.object.RdbmsOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.application.aled.entity.ReferentialBracelet;
import com.application.aled.service.ReferentialBraceletService;

/**
 * @author ISMAIL EL HAMMOUD
 *
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class ReferentialBraceletController {


	static final Logger logger = LogManager.getLogger(ReferentialBraceletController.class.getName());

	@Autowired
	ReferentialBraceletService referentialBraceletService;

	@GetMapping("/Referential_Bracelet")
	public List<ReferentialBracelet> getAllReferentialBracelet() {
		logger.info("Getting all bracelets from referential bracelet table...");
		List<ReferentialBracelet> refbracelets = referentialBraceletService.getAllReferentialBracelets();
		logger.info("Data well extracted from bracelet table..");
		return refbracelets;
	}
	
	@GetMapping("/generate_referential_bracelet")
	public void createDataMock(){
		for (int i=1; i<100; i++) {
			Random rd = new Random();
			ReferentialBracelet refbracelet = new ReferentialBracelet();
			refbracelet.setId(System.currentTimeMillis());
			refbracelet.setBrandBracelet("Fitbit" + i);
			refbracelet.setNameBracelet("BRAFI");
			refbracelet.setOptioncardiacFrequency(rd.nextBoolean());
			refbracelet.setOptioncardiacFrequency(rd.nextBoolean());
			refbracelet.setOptionGPS(rd.nextBoolean());
			refbracelet.setOptionWaterProofYN(rd.nextBoolean());
			refbracelet.setUpDate(LocalDateTime.now());
			refbracelet.setWipDate(LocalDateTime.MIN.minusDays(5));	
		}
	}
	
	
	

}