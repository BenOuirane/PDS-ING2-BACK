<<<<<<< HEAD
package com.application.aled.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import com.application.aled.entity.Bracelet;
import com.application.aled.entity.CurrentArea;
import com.application.aled.entity.model.link.SumCurrentAreaBracelet;

@Service
public interface CurrentAreaService {
	
	public List<CurrentArea> getAllAreas();
	public List<CurrentArea> getAreas();
	public CurrentArea getCurrentAreaById(int idarea);
	
	public CurrentArea[] getCurrentAreaByBracelet(Bracelet idbrac);
	
	public Map<Long, Long>  getAreaBraceletNbPassage(Bracelet bracelet);

	//public  List<CurrentArea> getSumAreaBracelet(int bracelet);
	
	void addArea(CurrentArea idarea);

	void updateArea(CurrentArea idarea);

	void removeArea(CurrentArea idarea);
	

	public List<CurrentArea> getAreasByYear(LocalDateTime year);

	public List<CurrentArea> getAreasByYearAndMonth(int year, int month);

	public List<CurrentArea> getAreasByDay(int year, int month, int day);



=======
package com.application.aled.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import com.application.aled.entity.Bracelet;
import com.application.aled.entity.CurrentArea;
import com.application.aled.entity.model.link.SumCurrentAreaBracelet;

@Service
public interface CurrentAreaService {
	
	public List<CurrentArea> getAllAreas();
	public List<CurrentArea> getAreas();
	public CurrentArea getCurrentAreaById(int idarea);
	
	public CurrentArea[] getCurrentAreaByBracelet(Bracelet idbrac);
	
	public Map<Long, Long>  getAreaBraceletNbPassage(Bracelet bracelet);

	//public  List<CurrentArea> getSumAreaBracelet(int bracelet);
	
	void addArea(CurrentArea idarea);

	void updateArea(CurrentArea idarea);

	void removeArea(CurrentArea idarea);
	

	public List<CurrentArea> getAreasByYear(LocalDateTime year);

	public List<CurrentArea> getAreasByYearAndMonth(int year, int month);

	public List<CurrentArea> getAreasByDay(int year, int month, int day);



>>>>>>> 8d1da6dc7d21bfe8feb6c1f59c4d4d4e90d499cc
}