package com.application.aled.repository;

import java.sql.Timestamp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.application.aled.entity.Position;

@Repository
public interface PositionRepository extends CrudRepository<Position, String> {

	//@SuppressWarnings("unchecked")
	//public Position save(Position position);
	//Position findByPosId(String posId);
	//Position findByPosDate(Timestamp posdate);
	 
   // List<Position> findBy(String n);
   // List<Position> 

}
