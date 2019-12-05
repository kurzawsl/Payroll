package bartek.repositories;

import bartek.employee.CommissionEmployee;
import bartek.employee.Employee;
import bartek.employee.HourlyEmployee;
import bartek.employee.SalariedEmployee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> getAllEmployees();

    List<SalariedEmployee> getSalariedEmployees();

    List<HourlyEmployee> getHourlyEmployees();

    List<CommissionEmployee> getCommissionEmployees();
}