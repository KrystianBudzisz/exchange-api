package pl.szlify.exchangeapi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import pl.szlify.exchangeapi.model.CurrencyResponse;
import pl.szlify.exchangeapi.model.HistoricalRatesResponse;
import pl.szlify.exchangeapi.model.SymbolsResponse;

@FeignClient(name = "exchangeClient", url = "${exchange.api.base-url}")
public interface ExchangeClient {
    @GetMapping("${exchange.api.all-currencies-endpoint}?access_key=${exchange.api.api-key}")
    CurrencyResponse getAllCurrencies();

    @GetMapping("${exchange.api.symbols-endpoint}?access_key=${exchange.api.api-key}")
    SymbolsResponse getAllSymbols();

    @GetMapping("${exchange.api.historical-endpoint}/{date}")
    HistoricalRatesResponse getHistoricalRates(
            @PathVariable("date") String date,
            @RequestParam("access_key") String apiKey,
            @RequestParam(value = "base", required = false) String base,
            @RequestParam(value = "symbols", required = false) String symbols);
}
