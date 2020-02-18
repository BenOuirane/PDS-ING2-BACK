package com.application.aled.repository;

import com.application.aled.entity.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Rooms,Long> {
    List<Rooms> findAll();
}
