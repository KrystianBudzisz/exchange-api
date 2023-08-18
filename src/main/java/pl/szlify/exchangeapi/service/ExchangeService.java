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
    private final SendMailService sendMailService;

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
//            String message = exchangeClient.getAllSymbols().toString();
//            sendMailService.sendSimpleMessage("mlaskowski93@gmail.com", "Waluty4", message);
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

    public ConvertReponse convert(String from, String to, Double amount, String date) {
        try {
            ConvertReponse reponse = exchangeClient.getConvertRate(from, to, amount);
            sendMailService.sendSimpleMessage("mimaboj299@dusyum.com","Exchange Currency", reponse);

            return reponse;
        } catch (Exception e) {
            throw new ExchangeApiException("Failed to convert ", e);
        }
    }
}
