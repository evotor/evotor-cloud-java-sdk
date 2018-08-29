package io.evotor.market.api.v2.builder;

import io.evotor.market.api.v2.model.Page;
import io.evotor.market.api.v2.model.store.Store;

public interface Stores {

    StoreInstance select(String store);

    Page<Store> fetch();

    interface StoreInstance {

        Store fetch();

        Documents documents();

        Devices devices();

        Employees employees();

        Products products();

        ProductGroups productGroups();

    }
}
