package pl.szlify.exchangeapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.szlify.exchangeapi.model.TestModel;
import pl.szlify.exchangeapi.service.ExchangeService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/exchange")
public class ExchangeController {

    private final ExchangeService exchangeService;


    @GetMapping("/test")
    public TestModel getAllCurrencies() {
        return exchangeService.getAllCurrencies();
    }

    @GetMapping("/test/{currencyCode}")
    public TestModel getCurrency(@PathVariable String currencyCode) {
        return exchangeService.getCurrency(currencyCode);
    }
}
