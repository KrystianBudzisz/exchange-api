package pl.szlify.exchangeapi.model;

import lombok.Data;

@Data
public class ConversionQuery {

    private String from;
    private String to;
    private int amount;

}
