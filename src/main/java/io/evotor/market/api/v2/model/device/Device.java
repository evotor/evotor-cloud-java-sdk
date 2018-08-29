package io.evotor.market.api.v2.model.device;

import io.evotor.market.api.v2.model.AbstractResource;
import io.evotor.market.api.v2.model.GUID;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Device extends AbstractResource {

    private GUID id;
    private String code;
    private String name;
    private Long timezoneOffset;
    private String imei;
    private String firmware;
    private String userId;
    private GUID storeId;

}
