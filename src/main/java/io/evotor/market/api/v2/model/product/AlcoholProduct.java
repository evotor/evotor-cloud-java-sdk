package io.evotor.market.api.v2.model.product;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AlcoholProduct extends PhysicalProduct {

    @NotNull
    @Digits(integer = 2, fraction = 3)
    @DecimalMin(value = "0.001", message = "must be greater or equal than 0.001")
    private BigDecimal alcoholByVolume;

    @NotNull
    @Min(value = 1)
    @Max(value = 999)
    private Integer alcoholProductKindCode;

    @NotNull
    @Digits(integer = 3, fraction = 3)
    @DecimalMin(value = "0.001", message = "must be greater or equal than 0.001")
    private BigDecimal tareVolume;

    @Override
    public ProductType getType() {
        return ProductType.ALCOHOL_NOT_MARKED;
    }

    public static Builder builder() {
        return new Builder(new AlcoholProduct());
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends AlcoholProduct, B extends Builder<T, ?>> extends PhysicalProduct.Builder<T, B> {

        Builder(AlcoholProduct toBuild) {
            super(toBuild);
        }

        public B withAlcoholByVolume(BigDecimal alcoholByVolume) {
            toBuild.setAlcoholByVolume(alcoholByVolume);
            return (B) this;
        }

        public B withAlcoholProductKindCode(Integer alcoholProductKindCode) {
            toBuild.setAlcoholProductKindCode(alcoholProductKindCode);
            return (B) this;
        }

        public B withTareVolume(BigDecimal tareVolume) {
            toBuild.setTareVolume(tareVolume);
            return (B) this;
        }
    }
}
