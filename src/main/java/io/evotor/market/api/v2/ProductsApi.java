package io.evotor.market.api.v2;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import io.evotor.market.api.v2.model.BulkTask;
import io.evotor.market.api.v2.model.Page;
import io.evotor.market.api.v2.model.product.AnyProduct;
import io.evotor.market.api.v2.model.product.ProductUpdateFields;

import java.util.Collection;
import java.util.UUID;

public interface ProductsApi {

    @Scope(value = "product:read", optional = { "product.quantity:read", "product.image:read" })
    @RequestLine("GET /stores/{store_id}/products?cursor={cursor}")
    Page<AnyProduct> fetch(@Param("store_id") String storeId,
                           @Param("cursor") String cursor);

    @Scope(value = "product:read", optional = { "product.quantity:read", "product.image:read" })
    @RequestLine("GET /stores/{store_id}/products/{product_id}")
    AnyProduct fetchOne(@Param("store_id") String storeId,
                        @Param("product_id") UUID productId);

    @Scope(value = "product:write", optional = "product.quantity:write")
    @RequestLine("PUT /stores/{store_id}/products/{product_id}")
    AnyProduct replace(@Param("store_id") String storeId,
                       @Param("product_id") UUID productId,
                       AnyProduct product);

    @Scope(value = "product:write", optional = "product.quantity:write")
    @RequestLine("PATCH /stores/{store_id}/products/{product_id}")
    AnyProduct update(@Param("store_id") String storeId,
                      @Param("product_id") UUID productId,
                      ProductUpdateFields fields);

    @Scope(value = "product:write", optional = "product.quantity:write")
    @RequestLine("POST /stores/{store_id}/products")
    AnyProduct create(@Param("store_id") String storeId,
                      AnyProduct product);

    @Headers("Content-Type: application/vnd.evotor.v2+bulk+json")
    @Scope(value = "product:write", optional = "product.quantity:write")
    @RequestLine("POST /stores/{store_id}/products")
    BulkTask<AnyProduct> createBulk(@Param("store_id") String storeId,
                                    Collection<AnyProduct> products);

    @RequestLine("GET /bulks/{task_id}")
    BulkTask<AnyProduct> bulkStatus(@Param("task_id") UUID taskId);

    @Scope(value = "product:write", optional = "product.quantity:write")
    @RequestLine("DELETE /stores/{store_id}/products?id={product_id}")
    void delete(@Param("store_id") String storeId,
                @Param("product_id") Collection<UUID> id);

    @Scope(value = "product:write", optional = "product.quantity:write")
    @RequestLine("DELETE /stores/{store_id}/products/{product_id}")
    void delete(@Param("store_id") String storeId,
                @Param("product_id") UUID productId);

}
