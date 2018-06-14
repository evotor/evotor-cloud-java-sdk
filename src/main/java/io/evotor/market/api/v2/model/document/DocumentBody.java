package io.evotor.market.api.v2.model.document;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import io.evotor.market.api.v2.model.document.body.*;

@JsonSubTypes({
        @JsonSubTypes.Type(value = SellDocumentBody.class, name = "SELL"),
        @JsonSubTypes.Type(value = PaybackDocumentBody.class, name = "PAYBACK"),
        @JsonSubTypes.Type(value = RevaluationDocumentBody.class, name = "REVALUATION"),
        @JsonSubTypes.Type(value = InventoryDocumentBody.class, name = "INVENTORY"),
        @JsonSubTypes.Type(value = CashIncomeDocumentBody.class, name = "CASH_INCOME"),
        @JsonSubTypes.Type(value = CashOutcomeDocumentBody.class, name = "CASH_OUTCOME"),
        @JsonSubTypes.Type(value = OpenSessionDocumentBody.class, name = "OPEN_SESSION"),
        @JsonSubTypes.Type(value = CloseSessionDocumentBody.class, name = "CLOSE_SESSION"),
        @JsonSubTypes.Type(value = OpenTareDocumentBody.class, name = "OPEN_TARE"),
        @JsonSubTypes.Type(value = AcceptDocumentBody.class, name = "ACCEPT"),
        @JsonSubTypes.Type(value = ReturnDocumentBody.class, name = "RETURN"),
        @JsonSubTypes.Type(value = XReportDocumentBody.class, name = "X_REPORT"),
        @JsonSubTypes.Type(value = XReportDocumentBody.class, name = "FPRINT"),
        @JsonSubTypes.Type(value = ZReportDocumentBody.class, name = "Z_REPORT"),
        @JsonSubTypes.Type(value = WriteOffDocumentBody.class, name = "WRITE_OFF"),
        @JsonSubTypes.Type(value = PosOpenSessionResultBody.class, name = "POS_OPEN_SESSION"),
        @JsonSubTypes.Type(value = BuyDocumentBody.class, name = "BUY"),
        @JsonSubTypes.Type(value = BuybackDocumentBody.class, name = "BUYBACK")
})
public interface DocumentBody {

}
