package io.evotor.market.api.v2;

import io.evotor.market.api.v2.model.BulkTask;
import io.evotor.market.api.v2.model.GUID;
import io.evotor.market.api.v2.model.Page;
import io.evotor.market.api.v2.model.product.AnyProduct;
import io.evotor.market.api.v2.model.product.PhysicalProduct;
import io.evotor.market.api.v2.model.product.TaxType;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Iterator;
import java.util.UUID;

import static io.evotor.market.api.v2.ApiHolder.STORE;
import static io.evotor.market.api.v2.ApiHolder.api;
import static org.junit.Assert.*;

public class ProductsTests {

    private static final GUID STORE_2 = new GUID(new UUID(0L, 2L));

    @Test
    public void list_products() {
        Iterator<AnyProduct> iterator = ApiHolder.api.stores()
                .select(STORE)
                .products()
                .iterator();

        assertNotNull(iterator);
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), Matchers.instanceOf(PhysicalProduct.class));
    }

    @Test
    public void list_products_from_second_store() {
        Page<AnyProduct> page = api.stores()
                .select(STORE_2)
                .products()
                .fetch();

        assertNotNull(page);
        assertNotNull(page.getItems());
        assertNull(page.getPaging().getNextCursor());
        assertThat(page.getItems(), Matchers.hasSize(3));
    }

    @Test
    public void post_products_bulk() throws Exception {
        AnyProduct actualProduct = PhysicalProduct.builder()
                .withQuantity(new BigDecimal("42"))
                .withCostPrice(new BigDecimal("12"))
                .withPrice(new BigDecimal("10"))
                .withMeasureName("liter")
                .withTax(TaxType.VAT_18)
                .withName("name")
                .build();

        BulkTask<AnyProduct> task = ApiHolder.api.stores()
                .select(STORE_2)
                .products()
                .create(Collections.singletonList(actualProduct))
                .get();

        assertThat(task.getDetails(), Matchers.hasSize(1));

        AnyProduct expectedProduct = task.getDetails().iterator().next();
        assertEquals(expectedProduct, actualProduct);
    }
}
