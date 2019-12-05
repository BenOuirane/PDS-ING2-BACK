package com.application.aled.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.application.aled.entity.Measure;


@Repository
public interface MeasureRepository extends CrudRepository<Measure, String> {

}
