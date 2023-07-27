package pl.szlify.exchangeapi.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import pl.szlify.exchangeapi.client.ExchangeClient;
import pl.szlify.exchangeapi.model.CurrencyResponse;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ExchangeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ExchangeClient exchangeClient;

//    @Test
//    public void testGetAllCurrencies() throws Exception {
//        CurrencyResponse mockCurrencyResponse = new CurrencyResponse();
//        when(exchangeClient.getAllCurrencies()).thenReturn(mockCurrencyResponse);
//
//        mockMvc.perform(get("/test"))
//                .andExpect(status().isOk())
//                .andExpect();
//    }
}
