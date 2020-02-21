package com.application.aled.repository;

import com.application.aled.entity.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface RoomRepository extends JpaRepository<Rooms,Long> {
    List<Rooms> findAll();
}
