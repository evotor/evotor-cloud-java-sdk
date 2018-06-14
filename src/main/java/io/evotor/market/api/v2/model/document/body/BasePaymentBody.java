package io.evotor.market.api.v2.model.document.body;

import io.evotor.market.api.v2.model.document.internal.DocDiscount;
import io.evotor.market.api.v2.model.document.internal.Payment;
import io.evotor.market.api.v2.model.document.internal.PrintGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class BasePaymentBody extends BasePositionBody {

    private List<DocDiscount> docDiscounts = new ArrayList<>();
    private List<Payment> payments = new ArrayList<>();
    private List<PrintGroup> printGroups = new ArrayList<>();
    private List<PosPrintResultBody> posPrintResults = new ArrayList<>();

}
