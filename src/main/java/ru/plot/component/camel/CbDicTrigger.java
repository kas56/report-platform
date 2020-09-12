package ru.plot.component.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.stereotype.Component;

@Component
public class CbDicTrigger extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        CamelContext context = new DefaultCamelContext();

        from("timer://foo?fixedRate=true&period=600000")
                .setBody().constant("event")
                .log("${body}")
                .to("direct:startCbDictLoading")
        ;
    }
}
