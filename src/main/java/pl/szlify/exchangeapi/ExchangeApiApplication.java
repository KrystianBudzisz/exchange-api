package pl.szlify.exchangeapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import pl.szlify.exchangeapi.properties.ExchangeApiProperties;

@SpringBootApplication
@EnableConfigurationProperties(ExchangeApiProperties.class)
@EnableFeignClients
public class ExchangeApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExchangeApiApplication.class, args);
    }

}
