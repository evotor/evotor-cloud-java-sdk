package io.evotor.market.api.v2.builder;

import io.evotor.market.api.v2.model.BulkTask;
import io.evotor.market.api.v2.model.Page;
import io.evotor.market.api.v2.model.group.ProductGroup;
import io.evotor.market.api.v2.model.group.ProductGroupUpdateFields;

import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface ProductGroups extends Iterable<ProductGroup> {

    Page<ProductGroup> fetch();

    ProductGroupInstance select(UUID productGroupId);

    void delete(Collection<UUID> productGroups);

    CompletableFuture<BulkTask<ProductGroup>> create(Collection<ProductGroup> productGroups);

    ProductGroup create(ProductGroup productGroup);

    interface ProductGroupInstance {

        ProductGroup fetch();

        void delete();

        ProductGroup update(ProductGroupUpdateFields fields);

        ProductGroup replace(ProductGroup productGroup);

    }
}
