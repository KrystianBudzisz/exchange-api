package pl.szlify.exchangeapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.szlify.exchangeapi.client.ExchangeClient;
import pl.szlify.exchangeapi.model.CurrencyResponse;
import pl.szlify.exchangeapi.model.SymbolsResponse;
import pl.szlify.exchangeapi.properties.ExchangeApiProperties;

@Service
@RequiredArgsConstructor
public class ExchangeService {

    private final ExchangeClient exchangeClient;
    private final ExchangeApiProperties properties;


    public CurrencyResponse getAllCurrencies() {
        CurrencyResponse currencies = exchangeClient.getAllCurrencies();
        return new CurrencyResponse(properties.getBaseUrl(), currencies);
    }

    public SymbolsResponse getAllSymbols() {
        return exchangeClient.getAllSymbols();
    }
}
