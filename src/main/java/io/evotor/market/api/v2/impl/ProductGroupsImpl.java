package io.evotor.market.api.v2.impl;

import io.evotor.market.api.v2.ProductGroupsApi;
import io.evotor.market.api.v2.builder.ProductGroups;
import io.evotor.market.api.v2.model.BulkTask;
import io.evotor.market.api.v2.model.GUID;
import io.evotor.market.api.v2.model.Page;
import io.evotor.market.api.v2.model.group.ProductGroup;
import io.evotor.market.api.v2.model.group.ProductGroupUpdateFields;

import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

class ProductGroupsImpl extends Impl implements ProductGroups {

    private final GUID store;

    ProductGroupsImpl(Function<Class, Object> apiProvider, GUID store) {
        super(apiProvider);
        this.store = store;
    }

    @Override
    public Page<ProductGroup> fetch() {
        return get(ProductGroupsApi.class).fetch(store, null);
    }

    @Override
    public ProductGroupInstance select(UUID id) {
        return new ProductGroupInstance() {
            @Override
            public ProductGroup fetch() {
                return get(ProductGroupsApi.class).fetchOne(store, id);
            }

            @Override
            public void delete() {
                get(ProductGroupsApi.class).delete(store, id);
            }

            @Override
            public ProductGroup update(ProductGroupUpdateFields fields) {
                return get(ProductGroupsApi.class).update(store, id, fields);
            }

            @Override
            public ProductGroup replace(ProductGroup productGroup) {
                return get(ProductGroupsApi.class).replace(store, id, productGroup);
            }
        };
    }

    @Override
    public void delete(Collection<UUID> productGroups) {
        get(ProductGroupsApi.class).delete(store, productGroups);
    }

    @Override
    public CompletableFuture<BulkTask<ProductGroup>> create(Collection<ProductGroup> products) {
        BulkTask<ProductGroup> task = get(ProductGroupsApi.class).createBulk(store, products);
        return CompletableFuture.supplyAsync(
                () -> ProductGroupsImpl.this.get(ProductGroupsApi.class).bulkStatus(task.getId())
        );
    }

    @Override
    public ProductGroup create(ProductGroup productGroup) {
        return get(ProductGroupsApi.class).create(store, productGroup);
    }

    @Override
    public Iterator<ProductGroup> iterator() {
        Function<String, Page<ProductGroup>> provider =
                (nextCursor) -> {
                    ProductGroupsApi productsApi = get(ProductGroupsApi.class);
                    return nextCursor == null ?
                            productsApi.fetch(store, null) :
                            productsApi.fetch(store, nextCursor);
                };

        return new PageableIterator<>(provider);
    }
}
