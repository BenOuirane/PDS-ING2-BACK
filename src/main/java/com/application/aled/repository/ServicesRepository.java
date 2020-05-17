package com.application.aled.repository;

import com.application.aled.entity.Services;
import org.springframework.data.repository.CrudRepository;

public interface ServicesRepository extends CrudRepository<Services, Long> {

    Services findByName(String name);

}
