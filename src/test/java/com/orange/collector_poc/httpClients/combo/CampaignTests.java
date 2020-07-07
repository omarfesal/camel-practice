package com.orange.collector_poc.httpClients.combo;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;
import org.springframework.stereotype.Component;

@Component
public class CampaignTests extends CamelTestSupport {

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
