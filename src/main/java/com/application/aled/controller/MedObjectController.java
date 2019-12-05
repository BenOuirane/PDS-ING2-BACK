package com.application.aled.controller;

import java.util.List;

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


@Autowired
MedObjectService medObjectService;

@GetMapping("/medicalObject")
public List<MedObject> getAllMedObject() {
	System.out.println("Get all Medical Objects...");

	List<MedObject> medObjects = medObjectService.getAllMedObject();

	return medObjects;
}

}
