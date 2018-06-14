package io.evotor.market.api.v2.model.document.internal;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class SaleAction {

    private BigDecimal sum;
    private BigDecimal quantity;
    private BigDecimal reversalSum;
    private BigDecimal reversalQuantity;
    private List<PaymentSection> paymentSections;

}
