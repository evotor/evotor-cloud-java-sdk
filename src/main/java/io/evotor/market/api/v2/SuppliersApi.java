package io.evotor.market.api.v2;


import feign.Param;
import feign.RequestLine;
import io.evotor.market.api.v2.model.Page;
import io.evotor.market.api.v2.model.supplier.Supplier;
import io.evotor.market.api.v2.model.supplier.SupplierUpdate;

import java.util.Collection;
import java.util.UUID;

public interface SuppliersApi {

    @Scope("supplier:read")
    @RequestLine("GET /suppliers?cursor={cursor}")
    Page<Supplier> fetch(@Param("cursor") String cursor);

    @Scope("supplier:read")
    @RequestLine("GET /suppliers/{supplier_id}")
    Supplier fetchOne(@Param("supplier_id") UUID supplier);

    @Scope("supplier:write")
    @RequestLine("POST /suppliers/")
    Supplier create(Supplier supplier);

    @Scope("supplier:write")
    @RequestLine("DELETE /suppliers?id={supplier_id}")
    void delete(@Param("supplier_id") Collection<UUID> id);

    @Scope("supplier:write")
    @RequestLine("PATCH /suppliers/{supplier_id}")
    Supplier updateName(@Param("supplier_id") UUID supplier, SupplierUpdate update);

    @Scope("supplier:write")
    @RequestLine("DELETE /suppliers/{supplier_id}")
    void delete(@Param("supplier_id") UUID supplier);

}
