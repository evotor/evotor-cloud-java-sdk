package io.evotor.market.api.v2.model.product;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public abstract class Product extends AnyProduct {

    @NotNull
    private String description;

    @NotNull
    @PositiveOrZero
    @Digits(integer = 7, fraction = 2)
    private BigDecimal price;

    @NotNull
    private String measureName;

    @NotNull
    private TaxType tax;

    @NotNull
    private Boolean allowToSell;

    private String articleNumber;
    private Collection<String> barcodes;

    @SuppressWarnings("unchecked")
    public static class Builder<T extends Product, B extends Builder<T, ?>> extends AnyProduct.Builder<T, B> {

        Builder(Product toBuild) {
            super((T) toBuild);
        }

        public B withDescription(String description) {
            toBuild.setDescription(description);
            return (B) this;
        }

        public B withPrice(BigDecimal price) {
            toBuild.setPrice(price);
            return (B) this;
        }

        public B withMeasureName(String measureName) {
            toBuild.setMeasureName(measureName);
            return (B) this;
        }

        public B notAllowedToSell() {
            toBuild.setAllowToSell(false);
            return (B) this;
        }

        public B allowedToSell() {
            toBuild.setAllowToSell(true);
            return (B) this;
        }

        public B allowedToSell(Boolean allowedToSell) {
            toBuild.setAllowToSell(allowedToSell);
            return (B) this;
        }

        public B withBarCode(String barCode) {
            Collection<String> barCodes = toBuild.getBarcodes();
            if (barCodes == null) {
                barCodes = new ArrayList<>();
                toBuild.setBarcodes(barCodes);
            }

            barCodes.add(barCode);
            return (B) this;
        }

        public B withTax(TaxType tax) {
            toBuild.setTax(tax);
            return (B) this;
        }

        public B withArticleNumber(String articleNumber) {
            toBuild.setArticleNumber(articleNumber);
            return (B) this;
        }
    }

    @NotNull
    public abstract ProductType getType();

}
