package com.application.aled.controller;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.application.aled.entity.MedObject;
import com.application.aled.service.MedObjectService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class MedObjectController {

	static final Logger logger = LogManager.getLogger(MedObjectController.class.getName());

	@Autowired
	MedObjectService medObjectService;

	@GetMapping("/medicalObject")
	public List<MedObject> getAllMedObject() {

		logger.info("Getting all medical object from med object table...");
		List<MedObject> medObjects = medObjectService.getAllMedObject();
		logger.info("Data well extracted from med object table...");
		return medObjects;
	}

}
