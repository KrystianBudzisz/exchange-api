package pl.szlify.exchangeapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
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

    public SymbolsResponse getAllSymbols() {

        try {
            return exchangeClient.getAllSymbols();
        } catch (Exception e) {
            throw new ExchangeApiException("Failed to fetch all symbols", e);
        }
    }
    public HistoricalRatesResponse getHistoricalRates(String date, String base, String symbols,String toEmail) {
        try {
            HistoricalRatesResponse response = exchangeClient.getHistoricalRates(date, properties.getApiKey(), base, symbols);

            if(toEmail == null && response.isSuccess()){
                return response;
            }
            else if (response.isSuccess()){
                sendMailService.sendSimpleMessageHistoricalData(toEmail,"Historical Data Exchange", response);
            }
            return exchangeClient.getHistoricalRates(date, properties.getApiKey(), base, symbols);

        } catch (Exception e) {
            throw new ExchangeApiException("Failed to fetch historical rates", e);
        }
    }

    public ConvertReponse convert(String from, String to, Double amount, String date,String toEmail) {
        try {
            ConvertReponse response = exchangeClient.getConvertRate(from, to, amount);
            if(toEmail == null && response.isSuccess()){
                return response;
            }
            else if (response.isSuccess()){
                sendMailService.sendSimpleMessage(toEmail,"Exchange Currency", response);
            }
            return response;
        } catch (Exception e) {
            throw new ExchangeApiException("Failed to convert ", e);
        }
    }
}
