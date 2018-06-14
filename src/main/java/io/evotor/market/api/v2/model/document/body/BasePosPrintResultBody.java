package io.evotor.market.api.v2.model.document.body;

import io.evotor.market.api.v2.model.document.DocumentBody;
import lombok.Data;

@Data
public class BasePosPrintResultBody implements DocumentBody {

    private Integer receiptNumber;
    private Integer documentNumber;
    private Integer sessionNumber;
    private String receiptDate;
    private String fnRegNumber;
    private String fiscalSignDocNumber;
    private Integer fiscalDocumentNumber;

}
