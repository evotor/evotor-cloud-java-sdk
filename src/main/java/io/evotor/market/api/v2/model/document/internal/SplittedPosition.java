package io.evotor.market.api.v2.model.document.internal;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SplittedPosition {

    private BigDecimal quantity;
    private BigDecimal resultPrice;
    private BigDecimal resultSum;
    private PositionDiscount positionDiscount;
    private PositionDiscount docDistributedDiscount;
    private TaxValue taxType;
    private BigDecimal taxResultSum;

}
