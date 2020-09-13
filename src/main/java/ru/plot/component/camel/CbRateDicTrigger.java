package ru.plot.component.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.stereotype.Component;

@Component
public class CbRateDicTrigger extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        CamelContext context = new DefaultCamelContext();

        from("quartz://myGroup/CbRateDicTimer?cron=0+0+0+?+*+*+*&trigger.misfireInstruction=2")
                .setBody().constant("event")
                .log("${body}")
                .to("direct:startCbRateDictLoading")
        ;
    }
}
