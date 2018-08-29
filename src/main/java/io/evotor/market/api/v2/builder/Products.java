package io.evotor.market.api.v2.builder;

import io.evotor.market.api.v2.model.BulkTask;
import io.evotor.market.api.v2.model.Page;
import io.evotor.market.api.v2.model.product.AnyProduct;
import io.evotor.market.api.v2.model.product.ProductUpdateFields;
import io.evotor.market.api.v2.model.product.image.ProductImageDesc;

import java.io.File;
import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface Products extends Iterable<AnyProduct> {

    Page<AnyProduct> fetch();

    ProductInstance select(UUID productId);

    void delete(Collection<UUID> products);

    CompletableFuture<BulkTask<AnyProduct>> create(Collection<AnyProduct> products);

    AnyProduct create(AnyProduct product);

    interface ProductInstance {

        AnyProduct fetch();

        void delete();

        AnyProduct update(ProductUpdateFields fields);

        AnyProduct replace(AnyProduct product);

        ProductImages images();

    }

    interface ProductImages {

        Page<ProductImageDesc> fetch();

        ProductImageDesc upload(File imageFile);

        ProductImageInstance select(UUID imageId);

        void deleteAll();

        interface ProductImageInstance {

            ProductImageDesc findOne();

            void delete();

        }
    }
}
