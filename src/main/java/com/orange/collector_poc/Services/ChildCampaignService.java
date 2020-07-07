package com.orange.collector_poc.Services;

import com.orange.collector_poc.repos.CampaignRepository;
import com.orange.collector_poc.repos.ChildCampaignRepository;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChildCampaignService extends RouteBuilder {

    @Autowired
    ChildCampaignRepository childCampaignRepository;

    @Override
    public void configure() throws Exception {
        from("direct:requestChildCampaignsFromDB")
                .bean(childCampaignRepository, "findUnfinishedSubCampaigns")
                .log("${body}")
                .to("direct:getChildCampaignsFromDB");

    }
}
