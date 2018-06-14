package io.evotor.market.api.v2.model.product;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProductGroup extends AnyProduct {

    private final boolean group = true;

    public static Builder builder() {
        return new Builder(new ProductGroup());
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends ProductGroup, B extends ProductGroup.Builder<T, ?>> extends AnyProduct.Builder<T, B> {

        Builder(ProductGroup toBuild) {
            super((T) toBuild);
        }
    }
}
