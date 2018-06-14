package io.evotor.market.api.v2.builder;

import io.evotor.market.api.v2.model.Page;
import io.evotor.market.api.v2.model.supplier.Supplier;

import java.util.Collection;
import java.util.UUID;

public interface Suppliers {

    SupplierInstance select(UUID supplier);

    Page<Supplier> fetch();

    Supplier create(Supplier supplier);

    void delete(Collection<UUID> ids);

    interface SupplierInstance {

        Supplier fetch();

        Supplier updateName(String name);

        void delete();

    }
}
