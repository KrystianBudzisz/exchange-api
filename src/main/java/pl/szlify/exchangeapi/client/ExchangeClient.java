package pl.szlify.exchangeapi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import pl.szlify.exchangeapi.model.CurrencyResponse;
import pl.szlify.exchangeapi.model.SymbolsResponse;

@FeignClient(name = "exchangeClient", url = "${exchange.api.base-url}")
public interface ExchangeClient {
    @GetMapping("${exchange.api.all-currencies-endpoint}?access_key=${exchange.api.api-key}")
    CurrencyResponse getAllCurrencies();

    @GetMapping("${exchange.api.symbols-endpoint}?access_key=${exchange.api.api-key}")
    SymbolsResponse getAllSymbols();

}
