package com.application.aled.repository;

import com.application.aled.entity.AnnualSubscription;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AnnualSubscriptionRepository extends JpaRepository<AnnualSubscription,Long> {
    @Query("select a.turnover from AnnualSubscription a ")
    int [] findSubscriptionByYear();

}
