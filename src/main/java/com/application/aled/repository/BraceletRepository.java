package com.application.aled.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.application.aled.entity.Bracelet;

@Repository
public interface BraceletRepository extends CrudRepository<Bracelet, String> {

	//@SuppressWarnings("unchecked")
	//public Bracelet save(Bracelet idbracelet);
	//public void findByRefBracId(Bracelet idbracelet);
	//List<Bracelet> findByWipDate(Timestamp lastsentdata);
	
}
