package com.application.aled.repository;

import com.application.aled.entity.Objects;
import com.application.aled.entity.Rooms;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ObjectRepository extends CrudRepository<Objects, Long> {

    List<Objects> findByRooms(Rooms room);
    List<Objects> findByState(boolean state);

}
