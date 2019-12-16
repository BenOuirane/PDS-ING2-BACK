/**
 * 
 */
package com.application.aled.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.application.aled.controller.exception.CustomHandler;
import com.application.aled.entity.ReferentialPosition;
import com.application.aled.entity.ReferentialResident;
import com.application.aled.service.ReferentialResidentService;

/**
 * @author ISMAIL EL HAMMOUD
 *
 *
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class ReferentialResidentController {

	@Autowired
	ReferentialResidentService referentialResidentService;
	
	@GetMapping("/referential_resident")
	public List<ReferentialResident> getAllReferentialResident() {
		System.out.println("Get all Referential Positons...");

		List<ReferentialResident> refresidents = referentialResidentService.getAllReferentialResidents();

		return refresidents;
	}
	@GetMapping("/referential_resident2/{userId}")
	public ReferentialResident referentialResidentId(@PathVariable(name = "userId")  String userId) throws NullPointerException {
		System.out.println("Getting IdResident..");
		ReferentialResident _refresident = referentialResidentService.getResidentById(Integer.parseInt(userId));
		
		if (_refresident == null) {
			throw new CustomHandler("User not found");
		} else {
			System.out.println(_refresident.toString());
			return _refresident;
		}
	}
	
	
}
