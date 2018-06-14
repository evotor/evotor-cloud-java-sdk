package io.evotor.market.api.v2.model.document.body;

import io.evotor.market.api.v2.model.document.DocumentBody;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CloseSessionDocumentBody implements DocumentBody {

    private BigDecimal revenue;
    private BigDecimal total;

}
