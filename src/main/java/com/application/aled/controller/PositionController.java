package com.application.aled.controller;

import java.util.List;

import com.application.aled.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.aled.entity.Position;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")

public class PositionController {

	@Autowired
	PositionService positionService;

	@GetMapping("/positions")
	public List<Position> getAllPositions() {
		System.out.println("Get all Position...");

		List<Position> positions = positionService.getAllPositions();

		return positions;
	}
	
	
	


}