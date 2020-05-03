package com.application.aled.repository;


import java.sql.Timestamp;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.application.aled.entity.ReferentialBracelet;

@Repository
public interface ReferentialBraceletRepository extends CrudRepository<ReferentialBracelet, String> {
	
	
	/*@SuppressWarnings("unchecked")
	public ReferentialBracelet save(ReferentialBracelet refbracelet);
	public void findByRefBracId(ReferentialBracelet refbracelet);
	List<ReferentialBracelet> findByName (String namebracelet);
	List<ReferentialBracelet> findByBrand (String brand);
	List<ReferentialBracelet> findByWipDate(Timestamp wipdate);
	*/
}
