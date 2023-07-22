package pl.szlify.exchangeapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.szlify.exchangeapi.model.CurrencyResponse;
import pl.szlify.exchangeapi.model.HistoricalRatesResponse;
import pl.szlify.exchangeapi.model.SymbolsResponse;
import pl.szlify.exchangeapi.service.ExchangeService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/exchange")
public class ExchangeController {

    private final ExchangeService exchangeService;


    @GetMapping("/test")
    public CurrencyResponse getAllCurrencies() {
        return exchangeService.getAllCurrencies();
    }

    @GetMapping("/symbols")
    public SymbolsResponse getAllSymbols() {
        return exchangeService.getAllSymbols();
    }

    @GetMapping("/historical/{date}")
    public HistoricalRatesResponse  getHistoricalRates(
            @PathVariable String date,
            @RequestParam(value = "base", required = false) String base,
            @RequestParam(value = "symbols", required = false) String symbols) {
        return exchangeService.getHistoricalRates(date, base, symbols);
    }
}
