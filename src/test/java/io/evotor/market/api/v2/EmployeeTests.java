package io.evotor.market.api.v2;

import io.evotor.market.api.v2.model.Page;
import io.evotor.market.api.v2.model.employee.Employee;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Collection;

import static io.evotor.market.api.v2.ApiHolder.api;
import static org.junit.Assert.*;

public class EmployeeTests {

    @Test
    public void list_employees() {
        Page<Employee> page = api.employees().fetch();

        assertNotNull(page);
        assertNull(page.getPaging().getNextCursor());

        Collection<Employee> employees = page.getItems();
        assertNotNull(employees);
        assertThat(employees, Matchers.hasSize(2));
    }
}
