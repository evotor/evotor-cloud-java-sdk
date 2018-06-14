package io.evotor.market.api.v2.model.document.body;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
public class CashOutcomeDocumentBody extends BasePosPrintResultBody {

    private BigDecimal sum;
    private String receiver;
    private String description;
    private Long paymentCategoryId;
    private String paymentCategoryName;

}
