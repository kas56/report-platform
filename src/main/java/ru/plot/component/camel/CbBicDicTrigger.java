package ru.plot.component.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.stereotype.Component;

//@Component
public class CbBicDicTrigger extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        CamelContext context = new DefaultCamelContext();

        from("quartz://myGroup/myTimerName?cron=0+0/5+*+?+*+*+*&trigger.misfireInstruction=2")
                .setBody().constant("event")
                .log("${body}")
                .to("direct:startCbBicDictLoading")
        ;
    }
}
