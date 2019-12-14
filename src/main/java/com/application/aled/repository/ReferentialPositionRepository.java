package com.application.aled.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.application.aled.entity.ReferentialPosition;

@Repository
public interface ReferentialPositionRepository extends CrudRepository<ReferentialPosition, Integer> {

}
