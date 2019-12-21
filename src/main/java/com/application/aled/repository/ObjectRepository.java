package com.application.aled.repository;

import com.application.aled.entity.Object;
import com.application.aled.entity.Rooms;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ObjectRepository extends CrudRepository<Object, Long> {

    public List<Object> findByRooms(Rooms room);

}
