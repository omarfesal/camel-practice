package com.orange.collector_poc.repos;

import com.orange.collector_poc.models.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface CampaignRepository extends JpaRepository<Campaign,Long> {

    public static final String RUNNING_CAMPAIGNS_QUERY = "SELECT id FROM campaigns WHERE is_activated = TRUE AND (DATE(date_from) <= DATE(NOW()) AND DATE(date_to) >= DATE(NOW()) AND TIME(time_from) <= TIME(NOW()) AND TIME(time_to) >= TIME(NOW()));";


    @Query(value = RUNNING_CAMPAIGNS_QUERY, nativeQuery = true )
    Collection<String> findAllRunningCampaigns();


}
