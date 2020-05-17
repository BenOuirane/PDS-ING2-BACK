package com.application.aled.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.application.aled.entity.Bracelet;
import com.application.aled.entity.CurrentArea;
import com.application.aled.entity.model.link.ISumCurrentBracelet;
import com.application.aled.entity.model.link.SumCurrentAreaBracelet;


@Repository
public interface CurrentAreaRepository extends  JpaRepository<CurrentArea, Integer> {

	List<CurrentArea> findByArea(String name);

	CurrentArea [] findAreaByBracelet(Bracelet bracelet);
	 
//	@Query(value ="SELECT com.application.aled.entity.model.link.SumCurrentAreaBracelet(a.id, a.area_id, count(a.braceletId)) "+
//	"FROM CurrentArea a WHERE a.braceletId = ?1 GROUP BY (a.braceletId, a.area_id)")
//	public List<SumCurrentAreaBracelet[]> findAreaBraceletSumTime(int idbrac);

	
//	@Query(value ="select a.bracelet_id from current_area  a where a.bracelet_id=?1 ")
//	public List<CurrentArea> findallAreaBraceletd(int idbrac);

	
	@Query(value = "select a.cross_date  from current_area a where year(a.cross_date) = '2020' ", nativeQuery = true)
	int[] findAreaByYY(LocalDateTime year);

	@Query(value = "select a.cross_date from current_area a where year(a.cross_date) = ?1 and month(a.cross_date)= ?2", nativeQuery = true)
	List<CurrentArea> findAreaByYYMM(int year, int month);

	@Query(value = "select a.cross from current_area a where year(a.cross_date) = ?1 and month(a.cross_date)= ?2 and day(a.cross_date)= ?3", nativeQuery = true)
	List<CurrentArea> findAreaByYYMMDD(int year, int month, int date);

}
