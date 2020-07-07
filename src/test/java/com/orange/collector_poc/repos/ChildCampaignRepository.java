package com.orange.collector_poc.repos;

import com.orange.collector_poc.httpClients.combo.Campaign;
import com.orange.collector_poc.httpClients.combo.CampaignTests;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;

public class ChildCampaignRepository extends CamelTestSupport {
    @Override
    protected RouteBuilder createRouteBuilder() {
        return new Campaign();
    }
}
