package com.application.aled.repository;


import com.application.aled.entity.Resident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  ResidentRepository extends JpaRepository<Resident,Long> {
}

