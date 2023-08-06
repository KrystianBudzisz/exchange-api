package pl.szlify.exchangeapi.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExchangeClientConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("apikey", "KQ7o2u5nhwiDtGeEvrj5ccS4NNAhOp7w");
        };
    }
}
