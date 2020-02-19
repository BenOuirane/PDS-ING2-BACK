package com.application.aled.repository;


import com.application.aled.entity.Objects;
import com.application.aled.entity.Shutter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ShutterRepository extends CrudRepository<Shutter, Long> {

    List<Shutter> findAllByObjects(Objects objects);
}
