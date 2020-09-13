package ru.plot.component.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.spi.DataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.plot.jaxb.cb.ValCursType;
import ru.plot.jaxb.cb.bic.BicCodeType;
import ru.plot.service.BankService;
import ru.plot.service.RateService;

/**
 * http://www.cbr.ru/scripts/XML_daily.asp?date_req=02/03/2002
 * Компонент закгрузки данных из центробанка по курсам валют
 */
@Component
public class CbBicDicLoader extends RouteBuilder {
    @Value("${cb.dict.bic.url:https://cbr.ru/scripts/XML_bic2.asp}")
    private String cbDictBicUrl;

    @Autowired
    private BankService bankService;

    @Override
    public void configure() throws Exception {
        DataFormat jaxbDataFormat = new JaxbDataFormat("ru.plot.jaxb.cb.bic");

        CamelContext context = new DefaultCamelContext();
        from("direct:startCbBicDictLoading")
                .setHeader(Exchange.HTTP_METHOD, constant("GET"))
                .to("ahc:"+ cbDictBicUrl)
                .unmarshal(jaxbDataFormat)
                .log("${body}")
                        .process(exchange -> {
                            BicCodeType body = exchange.getIn().getBody(BicCodeType.class);
                            bankService.saveBankBic(body);
                            exchange.getOut().setBody("Ok");
                        })
                .setBody().constant("Справочник кредитных организаций обновлен")

                .to("direct:notifyBalanceDay");
    }
}
