package com.application.aled.controller;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.application.aled.controller.exception.CustomHandler;
import com.application.aled.entity.Bracelet;
import com.application.aled.service.BraceletService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class BraceletController {

	static final Logger logger = LogManager.getLogger(BraceletController.class.getName());

	@Autowired
	BraceletService braceletService;

	@GetMapping("/bracelets/list")
	public List<Bracelet> getAllBracelets() {
		logger.info("Getting all bracelets from bracelet table...");
		List<Bracelet> bracelets = braceletService.getAllBracelets();
		logger.info("Data well extracted from bracelet table... the list is ready");
		return bracelets;
	}


	@GetMapping("/bracelet/{braceletsId}")
	public Bracelet getBraceletById(@PathVariable(name = "braceletId") Long braceletId) throws NullPointerException {
		Bracelet idbracelet = braceletService.getBraceletById(braceletId);
		return  idbracelet;
	}


	@GetMapping("/bracelets/{braceletId}")
	public Bracelet braceletId(@PathVariable(name = "braceletId") Long braceletId) throws NullPointerException {
		logger.info("Getting bracelet by id..");
		Bracelet _bracelet = braceletService.getBraceletById((braceletId));

		if (_bracelet == null) {
			logger.error("There's no data in bracelet table..");
			throw new CustomHandler("Bracelet not found");

		} else {
			logger.info(_bracelet.toString());
			return _bracelet;
		}
	}


	@GetMapping("/bracelets/year")
	public int getBraceletaByYear(@RequestParam int year) {
		int braceletByYear = braceletService.getBraceletByYear(year).size();
		return braceletByYear;
	}


	@GetMapping("bracelets/month/{month}")
	public int getBraceletByYearAndMonth(@RequestParam int year, int month) {
		int braceletByMonth = braceletService.getBraceletByYearAndMonth(year, month).size();
		return braceletByMonth;
	}

	@GetMapping("/bracelets/day/{day}")
	public int getBraceletByDay(@RequestParam int year, int month, int day) {
		int braceletByDay = braceletService.getBraceletByDay(year, month, day).size();
		return braceletByDay;
	}



}
