package io.evotor.market.api.v2.model.product.image;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProductImageDesc extends ProductImage {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class ImageMeta {

        private String extension;
        private long fileSize;
        private long width;
        private long height;

    }

    private ImageMeta meta;

}
