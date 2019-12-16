package com.application.aled.repository;


import java.time.LocalDateTime;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.application.aled.entity.Position;

@Repository
public interface PositionRepository extends CrudRepository<Position, Integer> {

	//@SuppressWarnings("unchecked")
	//public Position save(Position position);
	//Position findByPosId(String posId);
	//Position findByPosDate(LocalDateTime posdate);
	 
   // List<Position> findBy(String n);
   // List<Position> 

}
