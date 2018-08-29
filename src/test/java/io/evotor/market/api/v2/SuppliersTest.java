package io.evotor.market.api.v2;

import io.evotor.market.api.v2.model.Page;
import io.evotor.market.api.v2.model.supplier.Supplier;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Arrays;
import java.util.UUID;

import static io.evotor.market.api.v2.ApiHolder.api;
import static org.junit.Assert.*;

public class SuppliersTest {

    @Test
    public void select_suppliers() throws Exception {
        Page<Supplier> page = api.suppliers().fetch();
        assertNotNull(page);
        assertThat(page.getItems(), Matchers.hasSize(1));

        Supplier supplier = page.getItems().iterator().next();
        assertNotNull(supplier.getId());
        assertEquals("foo", supplier.getName());
    }

    @Test
    public void delete_batch() throws Exception {
        api.suppliers().delete(Arrays.asList(
                UUID.fromString("00000000-0000-0000-0000-000000000001"),
                UUID.fromString("00000000-0000-0000-0000-000000000002"))
        );
    }
}