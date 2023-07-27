package pl.szlify.exchangeapi.model;

import lombok.*;

import javax.management.Query;
import java.math.BigDecimal;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ConvertReponse {

    private boolean success;
    private ConversionQuery query;
    private ConversionInfo info;
    private String date;
    private BigDecimal result;


}
