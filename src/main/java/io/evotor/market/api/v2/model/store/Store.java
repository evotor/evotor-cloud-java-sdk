package io.evotor.market.api.v2.model.store;

import io.evotor.market.api.v2.model.AbstractResource;
import io.evotor.market.api.v2.model.GUID;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Store extends AbstractResource {

    private GUID id;
    private String userId;
    private String address;
    private String name;
    private String code;

}
