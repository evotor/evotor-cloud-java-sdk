package io.evotor.market.api.v2.model.product;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.LinkedHashSet;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MarkedAlcoholProduct extends AlcoholProduct {

    @NotNull
    @NotEmpty
    private Collection<String> alcoholCodes;

    public static Builder builder() {
        return new Builder(new MarkedAlcoholProduct());
    }

    public static class Builder extends AlcoholProduct.Builder<MarkedAlcoholProduct, Builder> {

        private Builder(MarkedAlcoholProduct toBuild) {
            super(toBuild);
        }

        public Builder withAlcoholCode(String alcoholCode) {
            Collection<String> alcoholCodes = toBuild.getAlcoholCodes();
            if (alcoholCodes == null) {
                alcoholCodes = new LinkedHashSet<>();
                toBuild.setAlcoholCodes(alcoholCodes);
            }

            alcoholCodes.add(alcoholCode);
            return this;
        }
    }

    @Override
    public ProductType getType() {
        return ProductType.ALCOHOL_MARKED;
    }
}
