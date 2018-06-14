package io.evotor.market.api.v2.model.employee;

import lombok.Data;

import java.util.Collection;

@Data
public class Employee {

    private String id;
    private String name;
    private String lastName;
    private Long phone;
    private String code;
    private String role;
    private Collection<String> stores;

}
