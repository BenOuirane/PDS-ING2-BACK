package com.application.aled.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.application.aled.entity.Bracelet;
import com.application.aled.entity.CurrentArea;

public interface CurrentAreaRepository extends CrudRepository<CurrentArea, Integer>{
	
	//TODO to be deactivated
	void deleteAll();
	
	List<CurrentArea> findByArea(String name);
	//public CurrentArea findAreaByBraceletId(Long idBrac);

	
}
