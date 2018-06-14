package io.evotor.market.api.v2.builder;

import io.evotor.market.api.v2.model.Page;
import io.evotor.market.api.v2.model.device.Device;

public interface Devices {

    DeviceInstance select(String device);

    Page<Device> fetch();

    interface DeviceInstance {

        Device fetch();

        Documents documents();

    }
}
