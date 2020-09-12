package ru.plot.component.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.stereotype.Component;

/**
 *
 * Telegram существует специальный бот — @BotFather.
 *
 * Пишем ему /start и получаем список всех его команд.
 * Первая и главная — /newbot — отправляем ему и бот просит придумать имя нашему новому боту.
 * RosatomReportBot
 *
 * https://api.telegram.org/bot1369431787:AAFyB5PNRZ2h8LBVK0Vv9eF30XueGkf5k9g/getUpdates
 */
@Component
public class TelegramNotifier extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        CamelContext context = new DefaultCamelContext();
        from("direct:notifyBalanceDay")
                .setHeader(Exchange.HTTP_METHOD, constant("GET"))
                //to("ahc:https://api.telegram.org/bot1369431787:AAFyB5PNRZ2h8LBVK0Vv9eF30XueGkf5k9g/getUpdates")
           .to("telegram:bots?authorizationToken=1369431787:AAFyB5PNRZ2h8LBVK0Vv9eF30XueGkf5k9g&chatId=397210641");
    }
}
