package com.application.aled.repository.history;

import com.application.aled.entity.SubscriptionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionHistoryRepository extends JpaRepository<SubscriptionHistory,Long>{
}
