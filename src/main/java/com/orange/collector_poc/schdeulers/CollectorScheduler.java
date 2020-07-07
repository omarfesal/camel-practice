package com.orange.collector_poc.schdeulers;

import com.orange.collector_poc.repos.CampaignRepository;
import com.orange.collector_poc.repos.ChildCampaignRepository;
import com.orange.collector_poc.repos.MsisdnRepository;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CollectorScheduler extends RouteBuilder {
    @Autowired
    ChildCampaignRepository childCampaignRepository;

    @Override
    public void configure() throws Exception {

        from("quartz://collector/collectTimer?cron=0 0/1 * * * ?")
                .id("collector-route")
                .log("====================== Start Get Un Finished Sub Campaign =============================")
                .to("direct:requestChildCampaignsFromDB");

        from("direct:getChildCampaignsFromDB")
                .log("====================== End Get Un Finished Sub Campaign =============================")
                .log("====================== Start Split Sub Campaigns =============================")
                .split(body())
                .parallelProcessing()
                .log("Sub Campaign Id ==> ${body}")
                .log("====================== End Split Sub Campaigns =============================")
                .to("direct:requestGetCampaignResult");

        from("direct:getCampaignResult")
                .log("============================== Start Result of Campaign ===================================")
                .log("${body}")
                .log("============================== End Result of Campaign ===================================")
                .to("direct:collectorFinished");
    }
}


