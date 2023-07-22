package pl.szlify.exchangeapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyResponse {

    private String baseUrl;
    private boolean success;
    private long timestamp;
    private String base;
    private String date;
    private Map<String, Double> rates;

    public CurrencyResponse(String baseUrl, CurrencyResponse response) {
        this.baseUrl = baseUrl;
        this.success = response.isSuccess();
        this.timestamp = response.getTimestamp();
        this.base = response.getBase();
        this.date = response.getDate();
        this.rates = response.getRates();
    }

}
