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

import com.application.aled.entity.ReferentialPosition;
import com.application.aled.entity.ReferentialResident;
import com.application.aled.service.ReferentialPositionService;
import com.application.aled.service.ReferentialResidentService;

/**
 * @author ISMAIL EL HAMMOUD
 *
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/")
public class ReferentialResidentController {

	@Autowired
	ReferentialResidentService referentialResidentService;

	@GetMapping("/referential_resident")
	public List<ReferentialResident> getAllReferentialPostions() {
		System.out.println("Get all Referential Positons...");

		List<ReferentialResident> refresidents = referentialResidentService.getAllReferentialResidents();

		return refresidents;
	}
}
