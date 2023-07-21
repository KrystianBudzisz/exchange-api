package pl.szlify.exchangeapi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "exchangeClient", url = "${exchange.api.base-url}")
public interface ExchangeClient {
    @GetMapping("${exchange.api.all-currencies-endpoint}?access_key=${exchange.api.api-key}")
    String getAllCurrencies();

    @GetMapping("${exchange.api.single-currency-endpoint}/{currencyCode}?access_key=${exchange.api.apiKey}")
    String getCurrency(@PathVariable("currencyCode") String currencyCode);
}
