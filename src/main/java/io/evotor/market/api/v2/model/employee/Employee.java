package io.evotor.market.api.v2.model.employee;

import io.evotor.market.api.v2.model.AbstractResource;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collection;

@Data
@EqualsAndHashCode(callSuper = true)
public class Employee extends AbstractResource {

    private String id;
    private String name;
    private String lastName;
    private Long phone;
    private String code;
    private String role;
    private Collection<String> stores;

}
