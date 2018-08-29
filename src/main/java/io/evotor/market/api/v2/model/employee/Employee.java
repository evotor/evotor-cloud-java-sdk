package io.evotor.market.api.v2.model.employee;

import io.evotor.market.api.v2.model.AbstractResource;
import io.evotor.market.api.v2.model.GUID;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collection;

@Data
@EqualsAndHashCode(callSuper = true)
public class Employee extends AbstractResource {

    private GUID id;
    private String name;
    private String lastName;
    private Long phone;
    private String code;
    private String role;
    private Collection<GUID> stores;
    private String userId;

}
