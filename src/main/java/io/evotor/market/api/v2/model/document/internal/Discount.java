package io.evotor.market.api.v2.model.document.internal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Discount {

    public enum DiscountType {
        PERC(0), SUM(1);

        private int order;

        DiscountType(int order) {
            this.order = order;
        }

        public int getOrder() {
            return order;
        }
    }

    private BigDecimal discountSum;
    private BigDecimal discountPercent;
    private DiscountType discountType;

}
