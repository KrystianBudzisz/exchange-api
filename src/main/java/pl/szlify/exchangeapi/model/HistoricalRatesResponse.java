package pl.szlify.exchangeapi.model;

import lombok.*;

import java.util.Map;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class HistoricalRatesResponse {

    private boolean success;
    private boolean historical;
    private String date;
    private long timestamp;
    private String base;
    private Map<String, Double> rates;

}

