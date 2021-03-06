package io.evotor.market.api.v2.impl;

import io.evotor.market.api.v2.ProductImagesApi;
import io.evotor.market.api.v2.ProductsApi;
import io.evotor.market.api.v2.builder.Products;
import io.evotor.market.api.v2.model.BulkTask;
import io.evotor.market.api.v2.model.GUID;
import io.evotor.market.api.v2.model.Page;
import io.evotor.market.api.v2.model.product.AnyProduct;
import io.evotor.market.api.v2.model.product.ProductUpdateFields;
import io.evotor.market.api.v2.model.product.image.ProductImage;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class ProductsImpl extends Impl implements Products {

    private final GUID store;

    ProductsImpl(Function<Class, Object> apiProvider, GUID store) {
        super(apiProvider);
        this.store = store;
    }

    @Override
    public Page<AnyProduct> fetch() {
        return get(ProductsApi.class).fetch(store, null);
    }

    @Override
    public ProductInstance select(UUID productId) {
        return new ProductInstance() {
            @Override
            public AnyProduct fetch() {
                return get(ProductsApi.class).fetchOne(store, productId);
            }

            @Override
            public void delete() {
                get(ProductsApi.class).delete(store, productId);
            }

            @Override
            public AnyProduct update(ProductUpdateFields fields) {
                return get(ProductsApi.class).update(store, productId, fields);
            }

            @Override
            public AnyProduct replace(AnyProduct product) {
                return get(ProductsApi.class).replace(store, productId, product);
            }

            @Override
            public ProductImages images() {
                return new ProductImages() {
                    @Override
                    public Page<ProductImage> fetch() {
                        return get(ProductImagesApi.class).fetch(store, productId);
                    }

                    @Override
                    public ProductImage upload(File imageFile) {
                        return get(ProductImagesApi.class).create(store, productId, imageFile);
                    }

                    @Override
                    public ProductImageInstance select(UUID imageId) {
                        return new ProductImageInstance() {
                            @Override
                            public ProductImage findOne() {
                                return get(ProductImagesApi.class).fetchOne(store, productId, imageId);
                            }

                            @Override
                            public void delete() {
                                get(ProductImagesApi.class).deleteOne(store, productId, imageId);
                            }
                        };
                    }

                    @Override
                    public void deleteAll() {
                        get(ProductImagesApi.class).delete(store, productId);
                    }
                };
            }
        };
    }

    @Override
    public void delete(Collection<UUID> products) {
        get(ProductsApi.class).delete(store, products);
    }

    @Override
    public CompletableFuture<BulkTask<AnyProduct>> create(Collection<AnyProduct> products) {
        BulkTask<AnyProduct> task = get(ProductsApi.class).createBulk(store, products);
        return CompletableFuture.supplyAsync(
                () -> ProductsImpl.this.get(ProductsApi.class).bulkStatus(task.getId())
        );
    }

    @Override
    public AnyProduct create(AnyProduct product) {
        return get(ProductsApi.class).create(store, product);
    }

    @Override
    public Iterator<AnyProduct> iterator() {
        Function<String, Page<AnyProduct>> provider =
                (nextCursor) -> {
                    ProductsApi productsApi = get(ProductsApi.class);
                    return nextCursor == null ?
                            productsApi.fetch(store, null) :
                            productsApi.fetch(store, nextCursor);
                };

        return new PageableIterator<>(provider);
    }
}
