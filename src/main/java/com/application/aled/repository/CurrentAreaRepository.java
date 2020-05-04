package com.application.aled.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.application.aled.entity.CurrentArea;

@Repository
public interface CurrentAreaRepository extends CrudRepository<CurrentArea, Integer> {

	// TODO to be deactivated
	void deleteAll();

	List<CurrentArea> findByArea(String name);
	// public CurrentArea findAreaByBraceletId(Long idBrac);

	@Query(value = "select a from current_area a where a.braceletId = ? orderby area_id ", nativeQuery = true)
	List<CurrentArea> findAreaBraceletSumTime(int area_id);

	@Query(value = "select area_id  from current_area a where year(a.cross_date) = '2020' ", nativeQuery = true)
	List<CurrentArea> findAreaByYY(String year);

	@Query(value = "select a from current_area a where year(a.cross_date) = ?1 and month(a.cross_date)= ?2", nativeQuery = true)
	List<CurrentArea> findAreaByYYMM(int year, int month);

	@Query(value = "select a from current_area a where year(a.cross_date) = ?1 and month(a.cross_date)= ?2 and day(a.cross_date)= ?3", nativeQuery = true)
	List<CurrentArea> findAreaByYYMMDD(int year, int month, int date);

}
