package io.evotor.market.api.v2.model.document.body;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.UUID;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class AcceptDocumentBody extends SumPositionBody {

    private UUID supplierId;

}
