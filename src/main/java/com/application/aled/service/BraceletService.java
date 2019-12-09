package com.application.aled.service;

import java.util.List;

import com.application.aled.entity.Bracelet;

public interface BraceletService {

	public List<Bracelet> getAllBracelets();
	
	void addBracelet(Bracelet idBrac);

	void updateBracelet(Bracelet idBrac);

	void removeBracelet(Bracelet idBrac);
}
