package io.evotor.market.api.v2.model.product.image;

import io.evotor.market.api.v2.model.AbstractResource;
import io.evotor.market.api.v2.model.GUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
public class ProductImage extends AbstractResource {

    private UUID id;
    private String url;
    private ImageMeta meta;
    private UUID productId;
    private GUID storeId;
    private String userId;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class ImageMeta {

        private String extension;
        private long fileSize;
        private long width;
        private long height;

    }
}
