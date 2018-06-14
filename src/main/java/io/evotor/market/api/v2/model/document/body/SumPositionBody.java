package io.evotor.market.api.v2.model.document.body;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class SumPositionBody extends BasePositionBody {

    private BigDecimal sum;

}
