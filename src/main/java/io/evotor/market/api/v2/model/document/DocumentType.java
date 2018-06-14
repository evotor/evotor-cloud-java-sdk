package io.evotor.market.api.v2.model.document;

public enum DocumentType {
    UNKNOWN,
    SELL,
    PAYBACK,
    CASH_INCOME,
    CASH_OUTCOME,
    OPEN_SESSION,
    FPRINT,
    CLOSE_SESSION,
    INVENTORY,
    ACCEPT,
    RETURN,
    WRITE_OFF,
    REVALUATION,
    OPEN_TARE,
    Z_REPORT,
    X_REPORT,
    POS_OPEN_SESSION,
    BUY,
    BUYBACK
    ;

    public static DocumentType find(String name) {
        try {
            return valueOf(name);
        } catch (IllegalArgumentException ex) {
            return DocumentType.UNKNOWN;
        }
    }
}
