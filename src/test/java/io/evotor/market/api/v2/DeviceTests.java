package io.evotor.market.api.v2;

import io.evotor.market.api.v2.model.Page;
import io.evotor.market.api.v2.model.device.Device;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

public class DeviceTests {

    @Test
    public void list_devices() {
        Page<Device> page = ApiHolder.api.devices().fetch();

        assertNotNull(page);
        assertNull(page.getPaging().getNextCursor());

        Collection<Device> devices = page.getItems();
        assertNotNull(devices);
        assertThat(devices, Matchers.hasSize(4));
    }
}
