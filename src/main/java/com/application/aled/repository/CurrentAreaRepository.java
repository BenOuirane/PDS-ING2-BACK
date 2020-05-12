package com.application.aled.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.application.aled.entity.Bracelet;
import com.application.aled.entity.CurrentArea;


public interface CurrentAreaRepository extends JpaRepository<CurrentArea, Integer> {

	// TODO to be deactivated
	void deleteAll();

	List<CurrentArea> findByArea(String name);

	CurrentArea [] findAreaByBracelet(Bracelet bracelet);
	 
	@Query(value = "select count(*) as NombredePassage, bracelet_id, area_id from current_area a where a.bracelet_id = ?1 group by area_id, bracelet_id ", nativeQuery = true)
	List<CurrentArea> findAreaBraceletSumTime(int idbrac);

	@Query(value = "select count(*) as NombredePassage, bracelet_id, area_id from current_area a where a.bracelet_id = ?1 group by area_id, bracelet_id ", nativeQuery = true)
	CurrentArea [] findAreaBraceletNbVisite();
	
	
	
	
	
	@Query(value = "select area_id, bracelet_id, cross_date from current_area a where a.bracelet_id = ? ", nativeQuery = true)
	List<CurrentArea> findAreaByBracelet();
	//Later
	@Query(value = "select a.cross_date  from current_area a where year(a.cross_date) = '2020' ", nativeQuery = true)
	int[] findAreaByYY(String year);

	@Query(value = "select a.cross_date from current_area a where year(a.cross_date) = ?1 and month(a.cross_date)= ?2", nativeQuery = true)
	List<CurrentArea> findAreaByYYMM(int year, int month);

	@Query(value = "select a.cross from current_area a where year(a.cross_date) = ?1 and month(a.cross_date)= ?2 and day(a.cross_date)= ?3", nativeQuery = true)
	List<CurrentArea> findAreaByYYMMDD(int year, int month, int date);

}
