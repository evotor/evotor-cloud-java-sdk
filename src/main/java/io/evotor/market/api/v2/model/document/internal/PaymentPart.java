package io.evotor.market.api.v2.model.document.internal;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class PaymentPart {

    private UUID printGroupId;
    private BigDecimal partSum;
    private BigDecimal change;

}
