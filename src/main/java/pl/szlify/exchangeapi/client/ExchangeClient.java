package pl.szlify.exchangeapi.client;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import pl.szlify.exchangeapi.model.ConvertReponse;
import pl.szlify.exchangeapi.model.CurrencyResponse;
import pl.szlify.exchangeapi.model.HistoricalRatesResponse;
import pl.szlify.exchangeapi.model.SymbolsResponse;

@FeignClient(name = "exchangeClient", url = "${exchange.api.base-url}")
public interface ExchangeClient {
//    @GetMapping("${exchange.api.all-currencies-endpoint}?access_key=${exchange.api.api-key}")
//    CurrencyResponse getAllCurrencies();

    @GetMapping("${exchange.api.symbols-endpoint}")
    SymbolsResponse getAllSymbols();

    @GetMapping("${exchange.api.historical-endpoint}/{date}")
    HistoricalRatesResponse getHistoricalRates(
            @PathVariable("date") String date,
            @RequestParam("access_key") String apiKey,
            @RequestParam(value = "base", required = false) String base,
            @RequestParam(value = "symbols", required = false) String symbols);

    @GetMapping("${exchange.api.convert-endpoint}")
    ConvertReponse getConvertRate(
            @RequestParam("from") String from,
            @RequestParam("to") String to,
            @RequestParam("amount") Double amount);

}
