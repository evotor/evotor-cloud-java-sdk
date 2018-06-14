package io.evotor.market.api.v2.impl;

import io.evotor.market.api.v2.DevicesApi;
import io.evotor.market.api.v2.DocumentsApi;
import io.evotor.market.api.v2.builder.Devices;
import io.evotor.market.api.v2.builder.Documents;
import io.evotor.market.api.v2.model.Page;
import io.evotor.market.api.v2.model.device.Device;

import java.util.function.Function;

class DevicesImpl extends Impl implements Devices {

    private final String store;

    DevicesImpl(Function<Class, Object> apiProvider, String store) {
        super(apiProvider);
        this.store = store;
    }

    @Override
    public Devices.DeviceInstance select(String device) {
        return new Devices.DeviceInstance() {
            @Override
            public Device fetch() {
                return get(DevicesApi.class).fetchOne(device);
            }

            @Override
            public Documents documents() {
                return new DocumentBuilder(get(DocumentsApi.class), store, device);
            }
        };
    }

    @Override
    public Page<Device> fetch() {
        return get(DevicesApi.class).fetch(store);
    }
}
