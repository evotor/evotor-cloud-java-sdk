package io.evotor.market.api.v2;

import feign.Param;
import feign.RequestLine;
import io.evotor.market.api.v2.model.GUID;
import io.evotor.market.api.v2.model.Page;
import io.evotor.market.api.v2.model.employee.Employee;

@Scope("employee:read")
public interface EmployeesApi {

    @RequestLine("GET /employees?store_id={store_id}&cursor={cursor}")
    Page<Employee> fetch(
            @Param("store_id") GUID store,
            @Param("cursor") String cursor);

    @RequestLine("GET /employees/{employee_id}")
    Employee fetchOne(@Param("employee_id") GUID employee);

}
