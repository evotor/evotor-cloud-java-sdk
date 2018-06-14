package io.evotor.market.api.v2.model.document.internal;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BasicPosition {

    private String productId;
    private BigDecimal quantity;
    private BigDecimal initialQuantity;
    private String barCode;
    private ProductType productType;
    private String mark;
    private BigDecimal alcoholByVolume;
    private Integer alcoholProductKindCode;
    private BigDecimal tareVolume;
    private String code;
    private String productName;
    private String measureName;
}
