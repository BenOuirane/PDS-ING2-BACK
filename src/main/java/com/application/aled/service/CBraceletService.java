package com.application.aled.service;

import java.util.List;

import com.application.aled.entity.CBracelet;

public interface CBraceletService {
	
	public List<CBracelet> getAllBracelet();
	void addBracelet(CBracelet idbracelet);
	void updateBracelet(CBracelet idbracelet);
	void removeBracelet(CBracelet idbracelet);
}

