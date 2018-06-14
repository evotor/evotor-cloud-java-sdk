package io.evotor.market.api.v2.model.document.body;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
public class PaybackDocumentBody extends BuyDocumentBody {

    private UUID baseDocumentId;
    private Integer baseDocumentNumber;

}
