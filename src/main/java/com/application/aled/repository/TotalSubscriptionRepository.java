package com.application.aled.repository;

import com.application.aled.entity.MensualSubscription;
import com.application.aled.entity.TotalSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TotalSubscriptionRepository extends JpaRepository<TotalSubscription,Long> {
    @Query("select t.average from TotalSubscription t where t.year = ?1")
    int [] findSubscriptionByName(int year);

}

