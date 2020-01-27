package com.application.aled.repository;

import com.application.aled.entity.Failure;
import com.application.aled.entity.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FailureRepository extends CrudRepository<Failure, Long> {
    Failure findByMacAddress(String mac_address);
}
