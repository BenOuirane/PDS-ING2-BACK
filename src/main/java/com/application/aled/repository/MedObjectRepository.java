package com.application.aled.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.application.aled.entity.MedObject;;

@Repository
public interface MedObjectRepository extends CrudRepository<MedObject, Integer> {

}
