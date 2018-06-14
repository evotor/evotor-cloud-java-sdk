package io.evotor.market.api.v2.model.document.body;

import io.evotor.market.api.v2.model.document.internal.ZReportAdditionalData;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ZReportDocumentBody extends BaseReportBody {

    private BigDecimal cash;
    private BigDecimal zReportNumber;
    private BigDecimal cashInSum;
    private BigDecimal cashOutSum;
    private BigDecimal cashInQuantity;
    private BigDecimal cashOutQuantity;
    private BigDecimal collection;
    private BigDecimal revenue;
    private BigDecimal sessionSalesResults;
    private BigDecimal sessionPurchasesResults;
    private BigDecimal nonzeroSumSales;
    private BigDecimal nonzeroSumPurchases;
    private BigDecimal quantitySalesQuantity;
    private BigDecimal quantitySalesReversal;
    private BigDecimal quantitySalesBack;
    private BigDecimal quantitySalesReversalBack;
    private BigDecimal quantityPurchasesQuantity;
    private BigDecimal quantityPurchasesReversal;
    private BigDecimal quantityPurchasesBack;
    private BigDecimal quantityPurchasesReversalBack;
    private BigDecimal salesSumm;
    private BigDecimal salesReversal;
    private List<ZReportAdditionalData.ZReportPaymentSection> salesSections;
    private BigDecimal salesBackSumm;
    private BigDecimal salesBackReversal;
    private List<ZReportAdditionalData.ZReportPaymentSection> salesBackSections;
    private BigDecimal purchasesSumm;
    private BigDecimal purchasesReversal;
    private List<ZReportAdditionalData.ZReportPaymentSection> purchasesSections;
    private BigDecimal purchasesBackSumm;
    private BigDecimal purchasesBackReversal;
    private List<ZReportAdditionalData.ZReportPaymentSection> purchasesBackSections;
    private ZReportAdditionalData.Quantity quantitySales;
    private ZReportAdditionalData.Quantity quantityPurchases;
    private ZReportAdditionalData.Parameters sales;
    private ZReportAdditionalData.Parameters salesBack;
    private ZReportAdditionalData.Parameters getPurchases;
    private ZReportAdditionalData.Parameters purchases;
    private ZReportAdditionalData.Parameters purchasesBack;
}
