package com.application.aled.service;

import java.util.List;
import com.application.aled.entity.Bracelet;

public interface BraceletService {

	public List<Bracelet> getAllBracelets();
<<<<<<< HEAD

	
	//Bracelet getBraceletById(Long idBrac);
	

	Bracelet getBraceletById(Long idBrac);

=======
	Bracelet getBraceletById(Long idBrac);
>>>>>>> 8d1da6dc7d21bfe8feb6c1f59c4d4d4e90d499cc
	void addBracelet(Bracelet idBrac);

	void updateBracelet(Bracelet idBrac);

	void removeBracelet(Bracelet idBrac);

<<<<<<< HEAD

	public List<Bracelet> getBraceletByYear(int year);
	public List<Bracelet> getBraceletByYearAndMonth(int year, int month);
	public List<Bracelet> getBraceletByDay(int year, int month, int day);

=======
	public List<Bracelet> getBraceletByYear(int year);
	public List<Bracelet> getBraceletByYearAndMonth(int year, int month);
	public List<Bracelet> getBraceletByDay(int year, int month, int day);
>>>>>>> 8d1da6dc7d21bfe8feb6c1f59c4d4d4e90d499cc
	Bracelet getBraceletByRefBracelet(String nameBrac);


}
