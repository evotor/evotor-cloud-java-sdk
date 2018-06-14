package io.evotor.market.api.v2;

import feign.Param;
import feign.RequestLine;
import io.evotor.market.api.v2.model.Page;
import io.evotor.market.api.v2.model.device.Device;

@Scope(value = "device:read", optional = { "device.imei:read", "device.firmware:read", "device.location:read" } )
public interface DevicesApi {

    @RequestLine("GET /devices?store_id={store_id}")
    Page<Device> fetch(@Param("store_id") String store);

    @RequestLine("GET /devices/{device_id}")
    Device fetchOne(@Param("device_id") String device);

}
