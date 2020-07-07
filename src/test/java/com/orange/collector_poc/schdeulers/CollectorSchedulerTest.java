package com.orange.collector_poc.schdeulers;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CollectorSchedulerTest extends CamelTestSupport {

//    @Override
//    protected RouteBuilder createRouteBuilder() {
//        return new CollectorScheduler();
//    }

//    @Test
//    public void testCollectorScheduler() throws Exception {
//        getMockEndpoint("direct:collectorFinished").expectedMinimumMessageCount(1);
//        assertMockEndpointsSatisfied();
//    }

    @Test
    public void testPrintFile() throws Exception {
        getMockEndpoint("mock:end").expectedMessageCount(1);

        assertMockEndpointsSatisfied();
    }


    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("quartz2://report?cron=0/2+*+*+*+*+?")
                        .setBody().simple("I was fired at ${header.fireTime}")
                        .to("stream:out")
                        .to("mock:end");
            }
        };
    }


}


