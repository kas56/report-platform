package ru.plot.component.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.apache.camel.spi.DataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.plot.jaxb.cb.ValCursType;
import ru.plot.service.RateService;

/**
 * http://www.cbr.ru/scripts/XML_daily.asp?date_req=02/03/2002
 * Компонент закгрузки данных из центробанка по курсам валют
 */
@Component
public class CbRateDicLoader extends RouteBuilder {
    @Value("${cd.daily.url:https://www.cbr.ru/scripts/XML_daily.asp}")
    private String cbDailyUrl;

    @Autowired
    private RateService rateService;

    @Override
    public void configure() throws Exception {
        DataFormat jaxbDataFormat = new JaxbDataFormat("ru.plot.jaxb.cb");

        CamelContext context = new DefaultCamelContext();
        from("direct:startCbRateDictLoading")
                .setHeader(Exchange.HTTP_METHOD, constant("GET"))
                .to("ahc:"+cbDailyUrl)
                .unmarshal(jaxbDataFormat)
                .log("${body}")
                        .process(exchange -> {
                            ValCursType body = exchange.getIn().getBody(ValCursType.class);
                            rateService.saveCurse(body);
                            exchange.getOut().setBody("Ok");
                        })
                .setBody().constant("Добрый день! Не забудьте сформировать ежедневный отчет об остатках на счетах до 11:00. Помните, дисциплина отчетности очень важна для компании.\n Желаю хорошего дня!")

                .to("direct:notifyBalanceDay");
    }
}
