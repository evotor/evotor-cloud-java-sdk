package io.evotor.market.api.v2.model.document.internal;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ZReportAdditionalData {

    private final ZReportActions sales;
    private final ZReportActions purchases;
    private final BigDecimal cashInSumm;
    private final BigDecimal cashInQuantity;
    private final BigDecimal cashOutSumm;
    private final BigDecimal cashOutQuantity;
    private final BigDecimal collection;
    private final BigDecimal revenue;
    private final BigDecimal sessionSalesResults;
    private final BigDecimal sessionPurchasesResults;
    private final BigDecimal nonzeroSumSales;
    private final BigDecimal nonzeroSumPurchases;

    @Data
    public static class ZReportActions {
        private BigDecimal actionSumm;
        private BigDecimal actionQuantity;
        private BigDecimal actionReversalSumm;
        private BigDecimal actionReversalQuantity;
        private List<ZReportPaymentSection> actionPaymentSections;
        private BigDecimal backActionSumm;
        private BigDecimal backActionQuantity;
        private BigDecimal backActionReversalSumm;
        private BigDecimal backActionReversalQuantity;
        private List<ZReportPaymentSection> backActionPaymentSections;
    }

    @Data
    public static class ZReportPaymentSection {
        private int number;
        private String name;
        private BigDecimal value;
    }

    @Data
    public static class Quantity {
        private BigDecimal quantity;
        private BigDecimal reversal;
        private BigDecimal back;
        private BigDecimal reversalBack;
    }

    @Data
    public static class Parameters {
        private BigDecimal summ;
        private BigDecimal reversal;
        private List<ZReportAdditionalData.ZReportPaymentSection> sections;
    }
}
