package com.application.aled.repository;

import com.application.aled.entity.Resident;
import com.application.aled.entity.Rooms;
import com.application.aled.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  ResidentRepository extends CrudRepository<Resident,Long> {
    Resident findByUser(User user);
    List<Resident> findAll();
    Resident findByRoom(Rooms room);
}


