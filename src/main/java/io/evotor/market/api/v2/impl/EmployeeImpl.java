package io.evotor.market.api.v2.impl;

import io.evotor.market.api.v2.EmployeesApi;
import io.evotor.market.api.v2.builder.Employees;
import io.evotor.market.api.v2.model.GUID;
import io.evotor.market.api.v2.model.Page;
import io.evotor.market.api.v2.model.employee.Employee;

import java.util.function.Function;

class EmployeeImpl extends Impl implements Employees {

    private final GUID store;

    EmployeeImpl(Function<Class, Object> apiProvider, GUID store) {
        super(apiProvider);
        this.store = store;
    }

    @Override
    public Page<Employee> fetch() {
        return get(EmployeesApi.class).fetch(store, null);
    }

    @Override
    public EmployeeInstance select(GUID employee) {
        return new EmployeeInstance() {

            @Override
            public Employee fetch() {
                return get(EmployeesApi.class).fetchOne(employee);
            }

        };
    }
}
