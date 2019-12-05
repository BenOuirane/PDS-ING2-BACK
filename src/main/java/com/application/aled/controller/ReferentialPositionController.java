package com.application.aled.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.aled.entity.ReferentialPosition;
import com.application.aled.service.ReferentialPositionService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/")
public class ReferentialPositionController {


@Autowired
ReferentialPositionService referentialPositionService;

@GetMapping("/referential_postion")
public List<ReferentialPosition> getAllReferentialPostions() {
	System.out.println("Get all Referential Positons...");

	List<ReferentialPosition> refpositions = referentialPositionService.getAllReferentialPositions();

	return refpositions;
}

}

