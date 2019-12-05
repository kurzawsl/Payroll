package bartek.repositories;

import bartek.employee.CommissionEmployee;
import bartek.employee.Employee;
import bartek.employee.HourlyEmployee;
import bartek.employee.SalariedEmployee;
import bartek.enums.Department;
import bartek.enums.EmploymentMode;
import bartek.enums.JobTitle;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryDummyData implements EmployeeRepository {

    private List<Employee> employees;

    public EmployeeRepositoryDummyData() {
        this.employees = new ArrayList<>();
        populateEmployees();
    }

    private void populateEmployees() {
        employees.add(new SalariedEmployee(1l, JobTitle.CEO, "Bartek", "Kijowski", LocalDate
                .of(1983, 1, 1), 123456789l, Department.MARKETING, EmploymentMode.FULLTIME, BigDecimal.valueOf(500000)));
        employees.add(new CommissionEmployee(2l, JobTitle.DIRECTOR, "James", "Smith", LocalDate
                .of(1979, 5, 2), 555555555l, Department.SALES, BigDecimal.valueOf(0.02), BigDecimal.valueOf(60000)));
        employees.add(new HourlyEmployee(3l, JobTitle.OFFICEWORKER, "Mark", "Kowalski", LocalDate
                .of(1995, 6, 22), 666666666l, Department.PRODUCTION, BigDecimal.valueOf(20)));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public List<SalariedEmployee> getSalariedEmployees() {
        List<SalariedEmployee> result = new ArrayList<>();
        for(Employee employee: employees){
            if(employee instanceof SalariedEmployee){
                result.add((SalariedEmployee) employee);
            }
        }
        return result;
    }

    @Override
    public List<HourlyEmployee> getHourlyEmployees() {
        List<HourlyEmployee> result = new ArrayList<>();
        for(Employee employee: employees){
            if(employee instanceof HourlyEmployee){
                result.add((HourlyEmployee) employee);
            }
        }
        return result;
    }

    @Override
    public List<CommissionEmployee> getCommissionEmployees() {
        List<CommissionEmployee> result = new ArrayList<>();
        for(Employee employee: employees){
            if(employee instanceof CommissionEmployee){
                result.add((CommissionEmployee) employee);
            }
        }
        return result;
    }
}







