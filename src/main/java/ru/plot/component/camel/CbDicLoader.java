package ru.plot.component.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * http://www.cbr.ru/scripts/XML_daily.asp?date_req=02/03/2002
 */
@Component
public class CbDicLoader extends RouteBuilder {
    @Value("${cd.daily.url:http://www.cbr.ru/scripts/XML_daily.asp}")
    private String cbDailyUrl;

    @Override
    public void configure() throws Exception {

        CamelContext context = new DefaultCamelContext();
        from("direct:startCbDictLoading")
                .setHeader(Exchange.HTTP_METHOD, constant("GET"))
                .to("ahc:"+cbDailyUrl)
                .log("${body}")
                .to("mock:results");
    }
}
