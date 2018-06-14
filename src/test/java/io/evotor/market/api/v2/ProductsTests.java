package io.evotor.market.api.v2;

import io.evotor.market.api.exception.ResourceNotFoundException;
import io.evotor.market.api.v2.model.Page;
import io.evotor.market.api.v2.model.product.AnyProduct;
import io.evotor.market.api.v2.model.product.ProductGroup;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

import static io.evotor.market.api.v2.ApiHolder.*;
import static org.junit.Assert.*;

public class ProductsTests {

    @Test
    public void list_products() {
        Iterator<AnyProduct> iterator = ApiHolder.api.stores()
                .select(STORE)
                .products()
                .iterator();

        assertNotNull(iterator);
        assertFalse(iterator.hasNext());
    }

    @Test
    public void list_products_with_groups() {
        Page<AnyProduct> page = api.stores()
                .select("store_2")
                .products()
                .fetch();

        assertNotNull(page);
        assertNotNull(page.getItems());
        assertNull(page.getPaging().getNextCursor());
        assertThat(page.getItems(), Matchers.hasSize(4));

        Optional<AnyProduct> productGroupOpt = page.getItems().stream()
                .filter(p -> p instanceof ProductGroup)
                .findFirst();

        assertTrue(productGroupOpt.isPresent());
        AnyProduct product = productGroupOpt.get();
        assertEquals(DEFAULT, product.getId());
        assertEquals("ГРУППА", product.getName());
        assertNull(product.getParentId());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void post_products() {
        ApiHolder.api.stores()
                .select(STORE)
                .products()
                .create(new ArrayList<>());
    }
}
