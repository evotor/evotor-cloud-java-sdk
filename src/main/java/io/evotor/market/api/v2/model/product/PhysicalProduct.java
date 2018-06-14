package io.evotor.market.api.v2.model.product;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PhysicalProduct extends Product {

    @NotNull
    @PositiveOrZero
    @Digits(integer = 7, fraction = 2)
    private BigDecimal costPrice;

    @NotNull
    @Digits(integer = 7, fraction = 3)
    private BigDecimal quantity;

    @Override
    public ProductType getType() {
        return ProductType.NORMAL;
    }

    public static Builder builder() {
        return new Builder(new PhysicalProduct());
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends PhysicalProduct, B extends Builder<T, ?>> extends Product.Builder<T, B> {

        Builder(PhysicalProduct toBuild) {
            super((T) toBuild);
        }

        public B withCostPrice(BigDecimal costPrice) {
            toBuild.setCostPrice(costPrice);
            return (B) this;
        }

        public B withQuantity(BigDecimal quantity) {
            toBuild.setQuantity(quantity);
            return (B) this;
        }
    }
}

