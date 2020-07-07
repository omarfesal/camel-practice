package com.orange.collector_poc.repos;

import com.orange.collector_poc.models.Msisdn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface MsisdnRepository  extends JpaRepository<Msisdn,Long> {

    public static final String RUNNING_CAMPAIGNS_QUERY = "SELECT campaign_id , number FROM msisdns m WHERE m.campaign_id= ?1 and m.status = 'Not_Triggered'";

    @Query(value = RUNNING_CAMPAIGNS_QUERY, nativeQuery = true )
    Collection<Object[]> findAllNotLaunchedMsisdns(Integer campaign_id);

}
