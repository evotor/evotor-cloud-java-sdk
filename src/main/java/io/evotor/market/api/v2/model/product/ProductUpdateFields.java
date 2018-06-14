package io.evotor.market.api.v2.model.product;

import lombok.Data;

import javax.validation.constraints.Digits;
import java.math.BigDecimal;

@Data
public class ProductUpdateFields {

    @Digits(integer = 7, fraction = 3)
    private BigDecimal quantity;

}
