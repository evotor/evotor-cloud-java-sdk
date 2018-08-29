package io.evotor.market.api.v2.impl;

import io.evotor.market.api.v2.DocumentsApi;
import io.evotor.market.api.v2.StoresApi;
import io.evotor.market.api.v2.builder.*;
import io.evotor.market.api.v2.model.Page;
import io.evotor.market.api.v2.model.store.Store;

import java.util.function.Function;

class StoresImpl extends Impl implements Stores {

    StoresImpl(Function<Class, Object> apiProvider) {
        super(apiProvider);
    }

    @Override
    public StoreInstance select(String store) {
        return new StoreInstance() {
            @Override
            public Store fetch() {
                return get(StoresApi.class).fetchOne(store);
            }

            @Override
            public Documents documents() {
                return DocumentBuilder.withStore(get(DocumentsApi.class), store);
            }

            @Override
            public Devices devices() {
                return new DevicesImpl(StoresImpl.this::get, store);
            }

            @Override
            public Employees employees() {
                return new EmployeeImpl(StoresImpl.this::get, store);
            }

            @Override
            public Products products() {
                return new ProductsImpl(StoresImpl.this::get, store);
            }

            @Override
            public ProductGroups productGroups() {
                return new ProductGroupsImpl(StoresImpl.this::get, store);
            }
        };
    }

    @Override
    public Page<Store> fetch() {
        return get(StoresApi.class).fetch();
    }
}
