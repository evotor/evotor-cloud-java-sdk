package io.evotor.market.api.v2.model.store;

import io.evotor.market.api.v2.model.AbstractResource;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Store extends AbstractResource {

    private String id;
    private String address;
    private String name;
    private String code;

}
