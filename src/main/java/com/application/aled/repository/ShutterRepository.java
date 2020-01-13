package com.application.aled.repository;


import com.application.aled.entity.Objects;
import com.application.aled.entity.Shutter;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ShutterRepository extends CrudRepository<Shutter, Long> {

    List<Shutter> findAllByObjects(Objects objects);
}
