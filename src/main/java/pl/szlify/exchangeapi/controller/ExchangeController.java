package pl.szlify.exchangeapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.szlify.exchangeapi.model.CurrencyResponse;
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

}
