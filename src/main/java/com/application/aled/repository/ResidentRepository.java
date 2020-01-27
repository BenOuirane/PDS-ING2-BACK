package com.application.aled.repository;

import com.application.aled.entity.Resident;
import com.application.aled.entity.Residents;
import com.application.aled.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface  ResidentRepository extends CrudRepository<Residents,Long> {
    Residents findByUser(User user);
}

