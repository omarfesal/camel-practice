package com.orange.collector_poc.repos;

import com.orange.collector_poc.Services.ChildCampaignService;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


import javax.sql.DataSource;

public class ChildCampaignRepositoryTest extends CamelTestSupport {


    private JdbcTemplate jdbc;

    @Before
    public void setupDatabase() throws Exception {
        DataSource ds = context.getRegistry().lookupByNameAndType("dataSource", DataSource.class);
        jdbc = new JdbcTemplate(ds);

        jdbc.execute("create table incoming_orders "
                + "( part_name varchar(20), quantity int, customer varchar(20))");
    }

    @After
    public void dropDatabase() throws Exception {
        jdbc.execute("drop table incoming_orders");
    }

//    protected JndiRegistry createRegistry() throws Exception {
//        JndiRegistry jndi = super.createRegistry();
//        jndi.bind("orderToSql", new OrderToSqlBean());
//
//        DriverManagerDataSource ds = new DriverManagerDataSource();
//        ds.setDriverClassName("org.apache.derby.jdbc.EmbeddedDriver");
//        ds.setUrl("jdbc:derby:memory:order;create=true");
//        ds.setUsername("sa");
//        ds.setPassword("");
//
//        jndi.bind("dataSource", ds);
//        return jndi;
//    }

    @Override
    protected RouteBuilder createRouteBuilder() {
        return new ChildCampaignService();
    }

    @Test
    public void testPrintFile() throws Exception {
        MockEndpoint mock = getMockEndpoint("direct:getChildCampaignsFromDB");
        mock.expectedMessageCount(1);
    }
}
