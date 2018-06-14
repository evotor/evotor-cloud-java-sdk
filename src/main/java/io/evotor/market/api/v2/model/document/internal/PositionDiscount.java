package io.evotor.market.api.v2.model.document.internal;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class PositionDiscount extends DocDiscount {

    private BigDecimal discountPrice;

}
