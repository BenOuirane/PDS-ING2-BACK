package com.application.aled.repository;

import com.application.aled.entity.MensualSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MonthSubscriptionRepository extends JpaRepository<MensualSubscription, Long> {

    @Query("select m.turnover from MensualSubscription m where m.year = ?1 ")
    int[] findSubscriptionByMonth(int year);

}
