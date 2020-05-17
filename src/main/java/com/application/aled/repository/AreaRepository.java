package com.application.aled.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.application.aled.entity.Area;


@Repository
public interface AreaRepository extends CrudRepository<Area, Integer> {
	//public Area findAreaByName(String name);
	//public Area findAreaDetails(Area area);
	//public Area findAreaByCode(Long code);

	
}
