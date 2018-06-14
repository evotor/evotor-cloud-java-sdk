package io.evotor.market.api.v2.model.document.internal;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class DocDiscount extends Discount {

    private Integer coupon;

}
