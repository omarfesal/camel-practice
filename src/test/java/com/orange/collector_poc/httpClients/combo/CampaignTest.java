package com.orange.collector_poc.httpClients.combo;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.jupiter.api.Test;

public class CampaignTest extends CamelTestSupport {

    public class ChildCampaignRepository extends CamelTestSupport {
        @Override
        protected RouteBuilder createRouteBuilder() {
            return new Campaign();
        }
    }

    @Test
    public void testPrintFile() throws Exception {
        MockEndpoint mock = getMockEndpoint("direct:getCampaignResult");
        mock.expectedMessageCount(1);

    }
}
