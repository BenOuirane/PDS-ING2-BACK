package com.application.aled.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.application.aled.entity.Position;

@Repository
public interface PositionRepository extends CrudRepository<Position, String> {

}
