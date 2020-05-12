package com.application.aled.repository;



import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.application.aled.entity.Bracelet;

@Repository
public interface BraceletRepository extends CrudRepository<Bracelet, Long> {

	// public void findByRefBracId(Bracelet idbracelet);
	// public List<Bracelet> findByWipDate(LocalDateTime lastsentdata);
	

	@Query(value = "select b.last_sent, count(*) from bracelet b where year(b.last_sent) = ?1", nativeQuery = true)
	List<Bracelet> findBraceletByYY(int year);

	@Query(value = "select b from bracelet b where year(b.last_sent) = ?1 and month(b.last_sent)= ?2", nativeQuery = true)
	List<Bracelet> findBraceletByYYMM(int year, int month);

	@Query(value = "select b from bracelet b where year(b.last_sent) = ?1 and month(b.last_sent)= ?2 and day(b.last_sent)= ?3", nativeQuery = true)
	List<Bracelet> findBraceletByYYMMDD(int year, int month, int date);
	
	
	public Bracelet findBraceletByRefBracelet(String name);

}
