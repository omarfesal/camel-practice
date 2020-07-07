package com.orange.collector_poc.Services;

import com.orange.collector_poc.models.Campaign;
import com.orange.collector_poc.repos.CampaignRepository;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignService extends RouteBuilder {

    @Autowired
    CampaignRepository campaignRepository;


    @Override
    public void configure() throws Exception {

    }
}
