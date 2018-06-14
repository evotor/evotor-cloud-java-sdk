package io.evotor.market.api.v2.model.product.image;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class ProductImage {

    private UUID id;
    private String url;
    private Date updatedAt;

}
