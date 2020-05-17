package com.application.aled.service;

import java.util.List;
import com.application.aled.entity.Bracelet;

public interface BraceletService {

	public List<Bracelet> getAllBracelets();
	Bracelet getBraceletById(Long idBrac);
	void addBracelet(Bracelet idBrac);

	void updateBracelet(Bracelet idBrac);

	void removeBracelet(Bracelet idBrac);

	public List<Bracelet> getBraceletByYear(int year);
	public List<Bracelet> getBraceletByYearAndMonth(int year, int month);
	public List<Bracelet> getBraceletByDay(int year, int month, int day);
	Bracelet getBraceletByRefBracelet(String nameBrac);


}
