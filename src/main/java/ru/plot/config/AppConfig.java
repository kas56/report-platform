package ru.plot.config;

import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.apache.camel.component.telegram.springboot.TelegramComponentAutoConfiguration;
import org.apache.camel.component.telegram.springboot.TelegramComponentConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.plot.component.camel.TelegramNotifier;

@Configuration
@Import(TelegramComponentAutoConfiguration.class)
public class AppConfig {
    @Value("${plot.api.path:camel}")
    private String contextPath;
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean servlet = new ServletRegistrationBean
                (new CamelHttpTransportServlet(), "/camel/*");
        servlet.setName("CamelServlet");
        return servlet;
    }
}
