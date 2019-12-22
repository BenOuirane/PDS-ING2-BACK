package com.application.aled.repository;

import com.application.aled.entity.Resident;
import com.application.aled.entity.Residents;
import com.application.aled.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  ResidentRepository extends JpaRepository<Residents,Long> {

    Residents findByUser(User user);
}

