package pl.szlify.exchangeapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.szlify.exchangeapi.client.ExchangeClient;
import pl.szlify.exchangeapi.exception.ExchangeApiException;
import pl.szlify.exchangeapi.model.CurrencyResponse;
import pl.szlify.exchangeapi.model.SymbolsResponse;
import pl.szlify.exchangeapi.properties.ExchangeApiProperties;

@Service
@RequiredArgsConstructor
public class ExchangeService {

    private final ExchangeClient exchangeClient;
    private final ExchangeApiProperties properties;


    public CurrencyResponse getAllCurrencies() {
        try {
            CurrencyResponse currencies = exchangeClient.getAllCurrencies();
            return new CurrencyResponse(properties.getBaseUrl(), currencies);
        } catch (Exception e) {
            throw new ExchangeApiException("Failed to fetch all currencies", e);
        }
    }

    public SymbolsResponse getAllSymbols() {
        try {
            return exchangeClient.getAllSymbols();
        } catch (Exception e) {
            throw new ExchangeApiException("Failed to fetch all symbols", e);
        }
    }
}
