package io.evotor.market.api.v2.impl;

import io.evotor.market.api.v2.SuppliersApi;
import io.evotor.market.api.v2.builder.Suppliers;
import io.evotor.market.api.v2.model.Page;
import io.evotor.market.api.v2.model.supplier.Supplier;
import io.evotor.market.api.v2.model.supplier.SupplierUpdate;

import java.util.Collection;
import java.util.UUID;
import java.util.function.Function;

public class SuppliersImpl extends Impl implements Suppliers {

    SuppliersImpl(Function<Class, Object> apiProvider) {
        super(apiProvider);
    }

    @Override
    public SupplierInstance select(UUID supplier) {
        return new SupplierInstance() {
            @Override
            public Supplier fetch() {
                return get(SuppliersApi.class).fetchOne(supplier);
            }

            @Override
            public Supplier updateName(String name) {
                return get(SuppliersApi.class).updateName(supplier, new SupplierUpdate(name));
            }

            @Override
            public void delete() {
                get(SuppliersApi.class).delete(supplier);
            }
        };
    }

    @Override
    public Page<Supplier> fetch() {
        return get(SuppliersApi.class).fetch(null);
    }

    @Override
    public Supplier create(Supplier supplier) {
        return get(SuppliersApi.class).create(supplier);
    }

    @Override
    public void delete(Collection<UUID> ids) {
        get(SuppliersApi.class).delete(ids);
    }
}
