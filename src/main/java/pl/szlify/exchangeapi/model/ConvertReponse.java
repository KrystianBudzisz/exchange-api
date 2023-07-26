package pl.szlify.exchangeapi.model;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ConvertReponse {

    private boolean success;
    private Map<String,Double> query;
    private Map<String,Double> info;
    private Map<String,Double> historical;


}
