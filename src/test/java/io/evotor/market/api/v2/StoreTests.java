package io.evotor.market.api.v2;

import io.evotor.market.api.v2.model.Page;
import io.evotor.market.api.v2.model.store.Store;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Collection;

import static io.evotor.market.api.v2.ApiHolder.STORE;
import static org.junit.Assert.*;

public class StoreTests {

    @Test
    public void list_stores() {
        Page<Store> page = ApiHolder.api.stores().fetch();
        assertNotNull(page);
        assertEquals("1234567890", page.getPaging().getNextCursor());

        Collection<Store> stores = page.getItems();
        assertNotNull(stores);
        assertThat(stores, Matchers.hasSize(3));

        Store store = stores.iterator().next();
        assertNotNull(store.getId());
        assertNull(store.getCode());
        assertEquals("Россия, Москва", store.getAddress());
        assertEquals("msk", store.getName());
    }

    @Test
    public void view_store() {
        Store store = ApiHolder.api.stores()
                .select(STORE)
                .fetch();

        assertNotNull(store.getId());
        assertNull(store.getCode());
        assertEquals("Россия, Москва", store.getAddress());
        assertEquals("msk", store.getName());
    }
}
