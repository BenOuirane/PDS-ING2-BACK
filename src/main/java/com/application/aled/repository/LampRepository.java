package com.application.aled.repository;

import com.application.aled.entity.Lamp;
import com.application.aled.entity.Objects;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LampRepository extends CrudRepository<Lamp, Long> {

<<<<<<< Updated upstream
    List<Lamp> getLampByObject(Objects objects);
=======
    List<Lamp> findAllByObjects(Objects objects);
>>>>>>> Stashed changes

}
