package com.application.aled.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.aled.entity.Bracelet;
import com.application.aled.repository.BraceletRepository;
import com.application.aled.service.BraceletService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/")
public class BraceletController {

	@Autowired
	BraceletService braceletService;

	@GetMapping("/bracelets")
	public List<Bracelet> getAllBracelets() {
		System.out.println("Get all Bracelets...");

		List<Bracelet> bracelets = braceletService.getAllBracelets();

		return bracelets;
	}
	
	

}
