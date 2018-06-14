package io.evotor.market.api.v2.model.document.internal;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentSection {

    private Integer number;
    private String name;
    private BigDecimal value;

}
