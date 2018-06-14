package io.evotor.market.api.v2.model.document.body;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
public class BaseReportBody extends BasePosPrintResultBody {

    private BigDecimal total;
    private BigDecimal proceeds;

}
