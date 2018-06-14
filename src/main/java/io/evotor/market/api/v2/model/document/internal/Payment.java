package io.evotor.market.api.v2.model.document.internal;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
public class Payment {

    private UUID id;
    private UUID parentId;
    private BigDecimal sum;
    private String type;
    private List<PaymentPart> parts;
    private AppPayment appPayment;
    private MerchantInfo merchantInfo;
    private BankInfo bankInfo;

}
