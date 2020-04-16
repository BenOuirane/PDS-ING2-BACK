package com.application.aled.controller.audit;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.aled.controller.BraceletController;
import com.application.aled.controller.exception.CustomHandler;
import com.application.aled.entity.CurrentArea;
import com.application.aled.service.CurrentAreaService;
import com.application.aled.service.audit.CurrentAreaAuditService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class CurrentAreaAuditController {
	static final Logger logger = LogManager.getLogger(CurrentAreaAuditController.class.getName());
	
	@Autowired
	CurrentAreaAuditService currentAreaAuditService; 
	
	//TODO new controller.. not sure to keep it alive
	

}
