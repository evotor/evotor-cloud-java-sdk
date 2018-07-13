package io.evotor.market.api.v2.model.device;

import io.evotor.market.api.v2.model.AbstractResource;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Device extends AbstractResource {

    private String id;
    private String code;
    private String name;
    private String storeId;
    private Long timezoneOffset;
    private String imei;
    private String firmware;

}
