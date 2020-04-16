package com.application.aled.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.application.aled.entity.Bracelet;
import com.application.aled.entity.CurrentArea;

public interface CurrentAreaRepository extends CrudRepository<CurrentArea, Integer>{
	
	//TODO to be deactivated
	void deleteAll();
	
	List<CurrentArea> findByArea(String name);
	//public CurrentArea findAreaByBraceletId(Long idBrac);


    @Query("select f from current_area f where year(f.cross_date) = ?1")
    List<CurrentArea> findAreaByYY(int year);

    @Query("select f from current_area f where year(f.cross_date) = ?1 and month(f.cross_date)= ?2")
    List<CurrentArea> findAreaByYYMM(int year, int month);

    @Query("select f from current_area f where year(f.cross_date) = ?1 and month(f.cross_date)= ?2 and day(f.cross_date)= ?3")
    List<CurrentArea> findAreaByYYMMDD(int year, int month, int date);
}
