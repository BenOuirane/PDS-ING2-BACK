package com.application.aled.repository;



import com.application.aled.entity.MedicalMeasurementType;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.application.aled.entity.Bracelet;

@Repository
public interface BraceletRepository extends CrudRepository<Bracelet, String> {

	//public void findByRefBracId(Bracelet idbracelet);
	//public List<Bracelet> findByWipDate(LocalDateTime lastsentdata);
	public Bracelet findBraceletById(Long idBrac);
	public Bracelet findBraceletByRefBracelet(String name);

}
