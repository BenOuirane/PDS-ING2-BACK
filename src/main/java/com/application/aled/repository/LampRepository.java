package com.application.aled.repository;

import com.application.aled.entity.Lamp;
import com.application.aled.entity.Objects;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LampRepository extends CrudRepository<Lamp, Long> {

    List<Lamp> findAllByObjects(Objects objects);

}
