package io.evotor.market.api.v2;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import io.evotor.market.api.v2.model.GUID;
import io.evotor.market.api.v2.model.Page;
import io.evotor.market.api.v2.model.product.image.ProductImageDesc;

import java.io.File;
import java.util.UUID;

public interface ProductImagesApi {

    @Scope("product.image:read")
    @RequestLine("GET /stores/{store_id}/products/{product_id}/images")
    Page<ProductImageDesc> fetch(
            @Param("store_id") GUID storeId,
            @Param("product_id") UUID productId);

    @Scope("product.image:read")
    @RequestLine("GET /stores/{store_id}/products/{product_id}/images/{image_id}")
    ProductImageDesc fetchOne(
            @Param("store_id") GUID storeId,
            @Param("product_id") UUID productId,
            @Param("image_id") UUID imageId);

    @Scope("product.image:write")
    @RequestLine("DELETE /stores/{store_id}/products/{product_id}/images/{image_id}")
    void deleteOne(
            @Param("store_id") GUID storeId,
            @Param("product_id") UUID productId,
            @Param("image_id") UUID imageId);

    @Scope("product.image:write")
    @Headers("Content-Type: multipart/form-data")
    @RequestLine("POST /stores/{store_id}/products/{product_id}/images")
    ProductImageDesc create(
            @Param("store_id") GUID storeId,
            @Param("product_id") UUID productId,
            @Param("datafile") File file);

    @Scope("product.image:write")
    @RequestLine("DELETE /stores/{store_id}/products/{product_id}/images")
    void delete(
            @Param("store_id") GUID storeId,
            @Param("product_id") UUID productId);

}
