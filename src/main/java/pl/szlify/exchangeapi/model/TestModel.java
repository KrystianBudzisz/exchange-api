package pl.szlify.exchangeapi.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TestModel {


    private String currencyCode;
    private String currencyValue;

}
