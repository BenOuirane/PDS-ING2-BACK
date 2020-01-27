package com.application.aled.repository;

import com.application.aled.entity.Objects;
import com.application.aled.entity.Oven;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OvenRepository extends CrudRepository<Oven, Long> {
    List<Oven> findAllByObjects(Objects objects);

}
