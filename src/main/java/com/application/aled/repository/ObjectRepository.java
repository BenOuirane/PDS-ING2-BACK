package com.application.aled.repository;

import com.application.aled.entity.Objects;
import com.application.aled.entity.Rooms;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ObjectRepository extends CrudRepository<Objects, Long> {

    List<Objects> findByRooms(Rooms room);
    List<Objects> findByState(boolean state);

}
