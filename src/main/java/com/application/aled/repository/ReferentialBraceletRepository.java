package com.application.aled.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.application.aled.entity.ReferentialBracelet;


@Repository
public interface ReferentialBraceletRepository extends CrudRepository<ReferentialBracelet, String>{

}
