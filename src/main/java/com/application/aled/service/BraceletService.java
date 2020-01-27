package com.application.aled.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.application.aled.entity.Bracelet;




public interface BraceletService {

	public List<Bracelet> getAllBracelets();
	
	Bracelet getBraceletById(Bracelet idBrac);
	
	void addBracelet(Bracelet idBrac);

	void updateBracelet(Bracelet idBrac);

	void removeBracelet(Bracelet idBrac);
}
