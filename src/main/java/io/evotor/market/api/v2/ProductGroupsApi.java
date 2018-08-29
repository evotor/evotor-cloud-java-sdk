package io.evotor.market.api.v2;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import io.evotor.market.api.v2.model.BulkTask;
import io.evotor.market.api.v2.model.GUID;
import io.evotor.market.api.v2.model.Page;
import io.evotor.market.api.v2.model.group.ProductGroup;
import io.evotor.market.api.v2.model.group.ProductGroupUpdateFields;

import java.util.Collection;
import java.util.UUID;

public interface ProductGroupsApi {

    @Scope(value = "product-group:read")
    @RequestLine("GET /stores/{store_id}/product-groups?cursor={cursor}")
    Page<ProductGroup> fetch(@Param("store_id") GUID storeId,
                             @Param("cursor") String cursor);

    @Scope(value = "product-group:read")
    @RequestLine("GET /stores/{store_id}/product-groups/{product_group_id}")
    ProductGroup fetchOne(@Param("store_id") GUID storeId,
                          @Param("product_group_id") UUID id);

    @Scope(value = "product-group:write")
    @RequestLine("POST /stores/{store_id}/product-groups")
    ProductGroup create(@Param("store_id") GUID storeId,
                        ProductGroup productGroup);

    @Headers("Content-Type: application/vnd.evotor.v2+bulk+json")
    @Scope(value = "product-group:write")
    @RequestLine("POST /stores/{store_id}/product-groups")
    BulkTask<ProductGroup> createBulk(@Param("store_id") GUID storeId,
                               Collection<ProductGroup> products);

    @RequestLine("GET /bulks/{task_id}")
    BulkTask<ProductGroup> bulkStatus(@Param("task_id") UUID taskId);

    @Scope(value = "product-group:write")
    @RequestLine("PUT /stores/{store_id}/product-groups/{product_group_id}")
    ProductGroup replace(@Param("store_id") GUID storeId,
                         @Param("product_group_id") UUID id,
                         ProductGroup productGroup);

    @Scope(value = "product-group:write")
    @RequestLine("PATCH /stores/{store_id}/product-groups/{product_group_id}")
    ProductGroup update(@Param("store_id") GUID storeId,
                        @Param("product_group_id") UUID id,
                        ProductGroupUpdateFields fields);

    @Scope(value = "product-group:write")
    @RequestLine("DELETE /stores/{store_id}/product-groups/{product_group_id}")
    void delete(@Param("store_id") GUID storeId,
                @Param("product_group_id") UUID id);

    @Scope(value = "product-group:write")
    @RequestLine("DELETE /stores/{store_id}/product-groups?id={product_group_id}")
    void delete(@Param("store_id") GUID storeId,
                @Param("product_group_id") Collection<UUID> id);

}
