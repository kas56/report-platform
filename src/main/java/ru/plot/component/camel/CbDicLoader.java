package ru.plot.component.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.apache.camel.spi.DataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.plot.jaxb.cb.ValCursType;
import ru.plot.service.CursService;

import java.time.LocalDate;

/**
 * http://www.cbr.ru/scripts/XML_daily.asp?date_req=02/03/2002
 * Компонент закгрузки данных из центробанка по курсам валют
 */
@Component
public class CbDicLoader extends RouteBuilder {
    @Value("${cd.daily.url:https://www.cbr.ru/scripts/XML_daily.asp}")
    private String cbDailyUrl;

    @Autowired
    private CursService cursService;

    @Override
    public void configure() throws Exception {
        DataFormat jaxbDataFormat = new JaxbDataFormat("ru.plot.jaxb.cb");

        CamelContext context = new DefaultCamelContext();
        from("direct:startCbDictLoading")
                .setHeader(Exchange.HTTP_METHOD, constant("GET"))
                .to("ahc:"+cbDailyUrl)
                .unmarshal(jaxbDataFormat)
                .log("${body}")
                        .process(exchange -> {
                            ValCursType body = exchange.getIn().getBody(ValCursType.class);
                            cursService.saveCurse(body);
                            exchange.getOut().setBody("Ok");
                        })
                .setBody().constant("Курсы валют за " + LocalDate.now() + " успешно загружены. Не забудьте сформировать ежедневный отчет до 11:00")

                .to("direct:notifyBalanceDay");
    }
}
