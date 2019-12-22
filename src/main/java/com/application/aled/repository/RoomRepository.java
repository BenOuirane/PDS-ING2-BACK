package com.application.aled.repository;

import com.application.aled.entity.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Rooms,Long> {

}