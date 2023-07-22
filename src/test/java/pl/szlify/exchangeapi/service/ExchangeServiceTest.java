package pl.szlify.exchangeapi.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.szlify.exchangeapi.client.ExchangeClient;
import pl.szlify.exchangeapi.exception.ExchangeApiException;
import pl.szlify.exchangeapi.model.HistoricalRatesResponse;
import pl.szlify.exchangeapi.model.SymbolsResponse;
import pl.szlify.exchangeapi.properties.ExchangeApiProperties;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class ExchangeServiceTest {

    @InjectMocks
    private ExchangeService exchangeService;

    @Mock
    private ExchangeClient exchangeClient;

    @Mock
    private ExchangeApiProperties properties;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        when(properties.getApiKey()).thenReturn("mockApiKey");
        when(properties.getBaseUrl()).thenReturn("mockBaseUrl");
    }

//    @Test
//    public void testGetAllCurrencies() {
//        CurrencyResponse mockResponse = new CurrencyResponse("mockBaseUrl", null);
//        when(exchangeClient.getAllCurrencies()).thenReturn(mockResponse);
//
//        CurrencyResponse result = exchangeService.getAllCurrencies();
//        assertEquals("mockBaseUrl", result.getBaseUrl());
//
//        verify(exchangeClient, times(1)).getAllCurrencies();
//    }

    @Test
    public void testGetAllSymbols() {
        SymbolsResponse mockResponse = new SymbolsResponse();
        when(exchangeClient.getAllSymbols()).thenReturn(mockResponse);

        SymbolsResponse result = exchangeService.getAllSymbols();
        assertNotNull(result);

        verify(exchangeClient, times(1)).getAllSymbols();
    }

    @Test
    public void testGetHistoricalRates() {
        HistoricalRatesResponse mockResponse = new HistoricalRatesResponse();
        when(exchangeClient.getHistoricalRates("2021-01-01", "mockApiKey", "USD", "EUR")).thenReturn(mockResponse);

        HistoricalRatesResponse result = exchangeService.getHistoricalRates("2021-01-01", "USD", "EUR");
        assertNotNull(result);

        verify(exchangeClient, times(1)).getHistoricalRates("2021-01-01", "mockApiKey", "USD", "EUR");
    }

    @Test
    public void testGetAllCurrenciesFailure() {
        when(exchangeClient.getAllCurrencies()).thenThrow(new RuntimeException("mock exception"));

        assertThrows(ExchangeApiException.class, () -> {
            exchangeService.getAllCurrencies();
        });
    }

    @Test
    public void testGetAllSymbolsFailure() {
        when(exchangeClient.getAllSymbols()).thenThrow(new RuntimeException("mock exception"));

        assertThrows(ExchangeApiException.class, () -> {
            exchangeService.getAllSymbols();
        });
    }

    @Test
    public void testGetHistoricalRatesFailure() {
        when(exchangeClient.getHistoricalRates(anyString(), anyString(), anyString(), anyString()))
                .thenThrow(new RuntimeException("mock exception"));

        assertThrows(ExchangeApiException.class, () -> {
            exchangeService.getHistoricalRates("2021-01-01", "USD", "EUR");
        });
    }
}
