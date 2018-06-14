package io.evotor.market.api.v2.model.document.internal;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class TaxValue {

    private String type;
    private BigDecimal sum;
    private BigDecimal resultSum;

}
