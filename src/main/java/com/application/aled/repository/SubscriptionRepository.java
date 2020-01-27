package com.application.aled.repository;

import com.application.aled.entity.Objects;
import com.application.aled.entity.Services;
import com.application.aled.entity.Subscription;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubscriptionRepository extends CrudRepository<Subscription, Long> {

    Subscription findByName(String name);

    List<Subscription> findByService(Services service);

    List<Subscription> findByObject(Objects Object);

}
