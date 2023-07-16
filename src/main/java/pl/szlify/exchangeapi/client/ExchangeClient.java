package pl.szlify.exchangeapi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "exchangeClient", url = "${exchange.api.baseUrl}")
public interface ExchangeClient {
    @GetMapping("/path-to-all-currencies-endpoint?access_key=${exchange.api.apiKey}")
    String getAllCurrencies();

    @GetMapping("/path-to-single-currency-endpoint/{currencyCode}?access_key=${exchange.api.apiKey}")
    String getCurrency(@PathVariable("currencyCode") String currencyCode);
}
