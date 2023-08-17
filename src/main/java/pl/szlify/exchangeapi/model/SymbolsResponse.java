package pl.szlify.exchangeapi.model;

import lombok.*;

import java.util.Map;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SymbolsResponse {
    private boolean success;
    private Map<String, String> symbols;
}
