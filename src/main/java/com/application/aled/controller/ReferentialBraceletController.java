/**
 * 
 */
package com.application.aled.controller;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.application.aled.entity.ReferentialBracelet;
import com.application.aled.service.referential.bracelet.ReferentialBraceletService;

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
	
	
	
	//TODO add the other methods

	
	

}