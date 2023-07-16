package pl.szlify.exchangeapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.szlify.exchangeapi.client.ExchangeClient;
import pl.szlify.exchangeapi.model.TestModel;
import pl.szlify.exchangeapi.properties.ExchangeApiProperties;

@Service
@RequiredArgsConstructor
public class ExchangeService {

    private final ExchangeClient exchangeClient;
    private final ExchangeApiProperties properties;

//    private final RestTemplate restTemplate;

    public TestModel getAllCurrencies() {
        String currencies = exchangeClient.getAllCurrencies();
        return new TestModel(properties.getBaseUrl(), currencies);
    }

    public TestModel getCurrency(String currencyCode) {
        String currency = exchangeClient.getCurrency(currencyCode);
        return new TestModel(properties.getBaseUrl(), currency);
    }
}
