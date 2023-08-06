package pl.szlify.exchangeapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.szlify.exchangeapi.client.ExchangeClient;
import pl.szlify.exchangeapi.exception.ExchangeApiException;
import pl.szlify.exchangeapi.model.ConvertReponse;
import pl.szlify.exchangeapi.model.CurrencyResponse;
import pl.szlify.exchangeapi.model.HistoricalRatesResponse;
import pl.szlify.exchangeapi.model.SymbolsResponse;
import pl.szlify.exchangeapi.properties.ExchangeApiProperties;

@Service
@RequiredArgsConstructor
public class ExchangeService {

    private final ExchangeClient exchangeClient;
    private final ExchangeApiProperties properties;


//    public CurrencyResponse getAllCurrencies() {
//        try {
//            CurrencyResponse currencies = exchangeClient.getAllCurrencies();
//            return new CurrencyResponse(properties.getBaseUrl(), currencies);
//        } catch (Exception e) {
//            throw new ExchangeApiException("Failed to fetch all currencies", e);
//        }
//    }

    public SymbolsResponse getAllSymbols() {
        try {
            return exchangeClient.getAllSymbols();
        } catch (Exception e) {
            throw new ExchangeApiException("Failed to fetch all symbols", e);
        }
    }

    public HistoricalRatesResponse getHistoricalRates(String date, String base, String symbols) {
        try {
            return exchangeClient.getHistoricalRates(date, properties.getApiKey(), base, symbols);
        } catch (Exception e) {
            throw new ExchangeApiException("Failed to fetch historical rates", e);
        }
    }

    public ConvertReponse getConvertedRates(String from, String to, Double amount, String date) {

        try{
            return exchangeClient.getConvertRate(from,to, amount);
        } catch (Exception e) {
            throw new ExchangeApiException("Failed to convert ", e);
        }
    }
}
