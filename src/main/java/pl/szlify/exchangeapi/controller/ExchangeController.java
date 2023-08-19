package pl.szlify.exchangeapi.controller;

import lombok.RequiredArgsConstructor;
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
    private final SendMailService mailService;


//    @GetMapping("/test")
//    public CurrencyResponse getAllCurrencies() {
//        return exchangeService.getAllCurrencies();
//    }

    @GetMapping("/symbols")
    public SymbolsResponse getAllSymbols() {
//        mailService.sendSimpleMessage("mlaskowski93@gmail.com","adsad", "sadads");
        return exchangeService.getAllSymbols();
    }
    @GetMapping("/historicalDate")
    public HistoricalRatesResponse  getHistoricalRates(
            @RequestParam(value = "date") String date,
            @RequestParam(value = "base", required = false) String base,
            @RequestParam(value = "symbols", required = false) String symbols,
            @RequestParam("toEmail") String toEmail
    ) {
        return exchangeService.getHistoricalRates(date, base, symbols,toEmail);
    }

    @GetMapping("/convert")
    public ConvertReponse getConvertRates(
            @RequestParam("from") String from,
            @RequestParam("to") String to,
            @RequestParam("amount") Double amount,
            @RequestParam(value = "date", required = false) String date,
            @RequestParam("toEmail") String toEmail
    )
    {

        return exchangeService.convert(from,to,amount,date,toEmail);
    }

}
