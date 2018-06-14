package io.evotor.market.api.v2.model.document.internal;

import lombok.Data;

import java.util.UUID;

@Data
public class PrintGroup {

    public enum Type {
        CASH_RECEIPT, INVOICE, STRING_UTII
    }

    public enum TaxationSystem {
        COMMON, SIMPLIFIED_INCOME, SIMPLIFIELD_INCOME_OUTCOME, SINGLE_IMPUTED_INCOME, SINGLE_AGRICULTURE, PATENT
    }

    private UUID id;
    private Type type;
    private String orgName;
    private String orgInn;
    private String orgAddress;
    private TaxationSystem taxationSystem;

}
