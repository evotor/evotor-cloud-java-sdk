package io.evotor.market.api.v2.model.product;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class ServiceProduct extends Product {

    public static Builder builder() {
        return new Builder(new ServiceProduct());
    }

    public static class Builder extends Product.Builder<ServiceProduct, Builder> {

        private Builder(ServiceProduct toBuild) {
            super(toBuild);
        }
    }

    @Override
    public ProductType getType() {
        return ProductType.SERVICE;
    }
}
