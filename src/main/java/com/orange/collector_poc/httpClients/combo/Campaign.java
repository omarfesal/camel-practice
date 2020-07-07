package com.orange.collector_poc.httpClients.combo;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.builder.ValueBuilder;
import org.apache.camel.component.http.HttpMethods;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Campaign extends RouteBuilder {
    @Value("${combo.base_url}")
    private static String comboBaseUrl;

    @Value("${combo.token}")
    private static String comboToken;

    @Override
    public void configure() throws Exception {
        from("direct:requestGetCampaignResult")
                .routeId("get-campaign-result-route")
//                .tracing()
//                .log("=================================== Start call combo =================================")
//                .log("{{combo.token}}")
                .setHeader(Exchange.HTTP_METHOD, constant(HttpMethods.GET))
                .setHeader("Authorization", constant("{{combo.token}}") )
                .toD("{{combo.base_url}}/bot-management/getCampaign?campaignID=${body}")
//                .tracing()
//                .log("combo result ${body}")
//                .log("==================================== End Call Combo ============================================")
                .to("direct:getCampaignResult");
    }
}

