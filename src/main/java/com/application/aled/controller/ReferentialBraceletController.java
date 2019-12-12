/**
 * 
 */
package com.application.aled.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/")
public class ReferentialBraceletController {

	@Autowired
	ReferentialBraceletService referentialBraceletService;

	@GetMapping("/Referential_Bracelet")
	public List<ReferentialBracelet> getAllReferentialBracelet() {
		System.out.println("Get all Referential Measures...");

		List<ReferentialBracelet> refbracelets = referentialBraceletService.getAllReferentialBracelets();

		return refbracelets;
	}
	
	@GetMapping("/generate_referential_bracelet")
	public void createDataMock(){
		for (int i=1; i<100; i++) {
			ReferentialBracelet refbracelet = new ReferentialBracelet();
			refbracelet.setId(System.currentTimeMillis());
			refbracelet.setBrandBracelet("Fitbit0" + i);
			refbracelet.setNameBracelet("BRAFI");
			refbracelet.setOptioncardiacFrequency(true);
			refbracelet.setOptioncardiacFrequency(true);
			refbracelet.setOptionGPS(true);
			refbracelet.setOptionWaterProofYN(true);
			refbracelet.setUpDate(null);
			refbracelet.setWipDate(null);
			
		}

	}

	
	

}