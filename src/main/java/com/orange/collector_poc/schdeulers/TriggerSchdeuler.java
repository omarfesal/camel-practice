//package com.orange.collector_poc.schdeulers;
//import com.orange.collector_poc.repos.CampaignRepository;
//import com.orange.collector_poc.repos.MsisdnRepository;
//import org.apache.camel.Exchange;
//import org.apache.camel.Processor;
//import org.apache.camel.builder.RouteBuilder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class TriggerScheduler extends RouteBuilder {
//    @Autowired
//    CampaignRepository campaignRepository;
//
//    @Autowired
//    MsisdnRepository msisdnRepository;
//
//    @Override
//    public void configure() throws Exception {
//        from("quartz://collector/collectTimer?cron=0 0/1 * * * ?")
//                .bean(campaignRepository, "findAllRunningCampaigns")
//                .split(body())
//                .parallelProcessing()
//                .bean(msisdnRepository , "findAllNotLaunchedMsisdns(${body})")
//                .log("${body}");
//
//    }
//}
//

