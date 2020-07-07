package com.orange.collector_poc.repos;

import com.orange.collector_poc.models.Campaign;
import com.orange.collector_poc.models.ChildCampaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface ChildCampaignRepository extends JpaRepository<ChildCampaign,Long> {

    public static final String UNFINISHED_SUB_CAMPAIGNS_QUERY = "SELECT trigger_id FROM campaigns_ids WHERE status = FALSE;";


    @Query(value = UNFINISHED_SUB_CAMPAIGNS_QUERY, nativeQuery = true )
    Collection<String> findUnfinishedSubCampaigns();

}
