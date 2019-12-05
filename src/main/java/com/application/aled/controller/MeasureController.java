package com.application.aled.controller;

import java.util.ArrayList;
import java.util.List;

import com.application.aled.service.MeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.aled.entity.Measure;
import com.application.aled.repository.MeasureRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")

public class MeasureController {

@Autowired
MeasureRepository repository;
	
@Autowired
MeasureService measureService;

@GetMapping("/measure")
public List<Measure> getAllMeasure() {
	System.out.println("Get all Measures...");
	List<Measure> measures = measureService.getAllMeasures();
	return measures;
}
}
