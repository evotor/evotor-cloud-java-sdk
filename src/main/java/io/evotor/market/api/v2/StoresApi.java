package io.evotor.market.api.v2;

import feign.Param;
import feign.RequestLine;
import io.evotor.market.api.v2.model.Page;
import io.evotor.market.api.v2.model.store.Store;

@Scope("store:read")
public interface StoresApi {

    @RequestLine("GET /stores")
    Page<Store> fetch();

    @RequestLine("GET /stores/{store_id}")
    Store fetchOne(@Param("store_id") String store);

}
