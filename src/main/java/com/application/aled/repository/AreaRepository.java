package com.application.aled.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.application.aled.entity.Area;


@Repository
public interface AreaRepository extends CrudRepository<Area, String> {
	public Area findAreaByName(String name);
	public Area getAreaDetails(Area area);
	public Area findAreaByCode(Integer code);

	
}
