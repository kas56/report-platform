package ru.plot.component.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class ReportTrigger extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        CamelContext context = new DefaultCamelContext();

        from("timer://foo?fixedRate=true&period=600000")
                .setBody().constant("Report loading")
                .log("${body}")
                .to("direct:startReportLoading")
        ;
    }
}
