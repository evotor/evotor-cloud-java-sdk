package io.evotor.market.api.v2.builder;

import io.evotor.market.api.v2.model.GUID;
import io.evotor.market.api.v2.model.Page;
import io.evotor.market.api.v2.model.employee.Employee;

public interface Employees {

    Page<Employee> fetch();

    EmployeeInstance select(GUID employee);

    interface EmployeeInstance {

        Employee fetch();

    }
}
