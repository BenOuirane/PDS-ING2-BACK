package com.application.aled.repository;

import com.application.aled.entity.AlarmClock;
import com.application.aled.entity.Objects;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlarmClockRepository extends CrudRepository<AlarmClock, Long> {

    List<AlarmClock> findAllByObjects(Objects objects);
}
