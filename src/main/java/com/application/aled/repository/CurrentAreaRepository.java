package com.application.aled.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.application.aled.entity.Bracelet;
import com.application.aled.entity.CurrentArea;


@Repository
public interface CurrentAreaRepository extends  CrudRepository<CurrentArea, Integer> {

	List<CurrentArea> findByArea(String name);

	CurrentArea [] findAreaByBracelet(Bracelet bracelet);
	 
	@Query("SELECT new com.application.aled.entity.model.link.SumCurrentAreaBracelet(a.bracelet_id, COUNT(a.bracelet_id) as NombredePassage,  a.area_id)" + 
	" FROM current_area a WHERE a.bracelet_id = ?1 GROUP BY area_id, bracelet_id ")
	public List<CurrentArea> findAreaBraceletSumTime(Bracelet bracelet);

	
	
	@Query(value = "select a.cross_date  from current_area a where year(a.cross_date) = '2020' ", nativeQuery = true)
	int[] findAreaByYY(LocalDateTime year);

	@Query(value = "select a.cross_date from current_area a where year(a.cross_date) = ?1 and month(a.cross_date)= ?2", nativeQuery = true)
	List<CurrentArea> findAreaByYYMM(int year, int month);

	@Query(value = "select a.cross from current_area a where year(a.cross_date) = ?1 and month(a.cross_date)= ?2 and day(a.cross_date)= ?3", nativeQuery = true)
	List<CurrentArea> findAreaByYYMMDD(int year, int month, int date);

}
