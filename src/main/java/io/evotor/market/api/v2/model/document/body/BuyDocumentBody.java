package io.evotor.market.api.v2.model.document.body;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
public class BuyDocumentBody extends BasePaymentBody {

    private BigDecimal sum;
    private BigDecimal resultSum;
    private String customerEmail;
    private String customerPhone;

}
