package com.application.aled.repository;

import com.application.aled.entity.Objects;
import com.application.aled.entity.Oven;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OvenRepository extends CrudRepository<Oven, Long> {
    List<Oven> findAllByObjects(Objects objects);

}
