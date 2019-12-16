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
@RequestMapping("/api")
public class ReferentialBraceletController {

	@Autowired
	ReferentialBraceletService referentialBraceletService;

	@GetMapping("/Referential_Bracelet")
	public List<ReferentialBracelet> getAllReferentialBracelet() {
		System.out.println("Get all Referential Measures...");

		List<ReferentialBracelet> refbracelets = referentialBraceletService.getAllReferentialBracelets();

		return refbracelets;
	}
	
	/// the following method will allow us to generate several referential bracelet
	// it will help us to mock data
	//@GetMapping("/generate_referential_bracelet")
	

	
	

}