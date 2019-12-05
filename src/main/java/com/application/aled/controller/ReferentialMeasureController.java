package com.application.aled.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.aled.entity.ReferentialMeasure;
import com.application.aled.service.ReferentialMeasureService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/")
public class ReferentialMeasureController {

	
	@Autowired
	ReferentialMeasureService referentialMeasureService;

	@GetMapping("/referential_measure")
	public List<ReferentialMeasure> getAllReferentialMeasure() {
		System.out.println("Get all Referential Measures...");

		List<ReferentialMeasure> refmeasures = referentialMeasureService.getAllReferentialMeasures();

		return refmeasures;
	}
}
