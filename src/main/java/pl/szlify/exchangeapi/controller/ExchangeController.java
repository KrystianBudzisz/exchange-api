package pl.szlify.exchangeapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.szlify.exchangeapi.model.ConvertReponse;
import pl.szlify.exchangeapi.model.CurrencyResponse;
import pl.szlify.exchangeapi.model.HistoricalRatesResponse;
import pl.szlify.exchangeapi.model.SymbolsResponse;
import pl.szlify.exchangeapi.service.ExchangeService;
import pl.szlify.exchangeapi.service.SendMailService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/exchange")
public class ExchangeController {

    private final ExchangeService exchangeService;


    @GetMapping("/symbols")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public SymbolsResponse getAllSymbols() {
        return exchangeService.getAllSymbols();
    }

    @GetMapping("/historicalDate")
    @PreAuthorize("hasAnyRole('ROLE_USER')")
    public HistoricalRatesResponse getHistoricalRates(
            @RequestParam(value = "date") String date,
            @RequestParam(value = "base", required = false) String base,
            @RequestParam(value = "symbols", required = false) String symbols,
            @RequestParam("toEmail") String toEmail
    ) {
        return exchangeService.getHistoricalRates(date, base, symbols, toEmail);
    }

    @GetMapping("/historicalDateForAdmin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public HistoricalRatesResponse getHistoricalRatesForAdmin(
            @RequestParam(value = "date") String date,
            @RequestParam(value = "base", required = false) String base,
            @RequestParam(value = "symbols", required = false) String symbols,
            @RequestParam(value = "toEmail",required = false) String toEmail
    ) {
        return exchangeService.getHistoricalRates(date, base, symbols, toEmail);
    }

    @GetMapping("/convert")
    @PreAuthorize("hasAnyRole('ROLE_USER')")
    public ConvertReponse getConvertRates(
            @RequestParam("from") String from,
            @RequestParam("to") String to,
            @RequestParam("amount") Double amount,
            @RequestParam(value = "date", required = false) String date,
            @RequestParam("toEmail") String toEmail
    ) {
        return exchangeService.convert(from, to, amount, date, toEmail);
    }

    @GetMapping("/convertForAdmin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ConvertReponse getConvertRatesForAdmin(
            @RequestParam("from") String from,
            @RequestParam("to") String to,
            @RequestParam("amount") Double amount,
            @RequestParam(value = "date", required = false) String date,
            @RequestParam(value = "toEmail", required = false) String toEmail
    ) {
        return exchangeService.convert(from, to, amount, date, toEmail);
    }


}
