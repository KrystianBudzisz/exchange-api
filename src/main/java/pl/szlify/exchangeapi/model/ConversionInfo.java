package pl.szlify.exchangeapi.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ConversionInfo {

    private String timestamp;
    private BigDecimal rate;

}
