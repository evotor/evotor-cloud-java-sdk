package io.evotor.market.api.v2.impl;

import io.evotor.market.api.v2.EmployeesApi;
import io.evotor.market.api.v2.builder.Employees;
import io.evotor.market.api.v2.model.Page;
import io.evotor.market.api.v2.model.employee.Employee;

import java.util.function.Function;

class EmployeeImpl extends Impl implements Employees {

    private final String store;

    EmployeeImpl(Function<Class, Object> apiProvider, String store) {
        super(apiProvider);
        this.store = store;
    }

    @Override
    public Page<Employee> fetch() {
        return get(EmployeesApi.class).fetch(store);
    }

    @Override
    public EmployeeInstance select(String employee) {
        return new EmployeeInstance() {

            @Override
            public Employee fetch() {
                return get(EmployeesApi.class).fetchOne(employee);
            }

        };
    }
}
