package io.evotor.market.api.v2.model.device;

import lombok.Data;

@Data
public class Device {

    private String id;
    private String code;
    private String name;
    private String storeId;
    private Long timezoneOffset;
    private String imei;
    private String firmware;

}
