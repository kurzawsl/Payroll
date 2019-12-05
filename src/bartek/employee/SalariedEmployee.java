package bartek.employee;

import bartek.enums.Department;
import bartek.enums.EmploymentMode;
import bartek.enums.JobTitle;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SalariedEmployee extends Employee {
    private EmploymentMode employmentMode;
    private BigDecimal AnnualSalary;

    public SalariedEmployee(Long id, JobTitle title, String firstName, String lastName, LocalDate dateOfBirth, Long nationalInsuranceNumber, Department department) {
        super(id, title, firstName, lastName, dateOfBirth, nationalInsuranceNumber, department);
    }

    public SalariedEmployee(Long id, JobTitle title, String firstName, String lastName, LocalDate dateOfBirth, Long nationalInsuranceNumber, Department department, EmploymentMode employmentMode, BigDecimal annualSalary) {
        super(id, title, firstName, lastName, dateOfBirth, nationalInsuranceNumber, department);
        this.employmentMode = employmentMode;
        AnnualSalary = annualSalary;
    }

    public SalariedEmployee() {
        super();
    }

    public EmploymentMode getEmploymentMode() {
        return employmentMode;
    }

    public void setEmploymentMode(EmploymentMode employmentMode) {
        this.employmentMode = employmentMode;
    }

    public BigDecimal getAnnualSalary() {
        return AnnualSalary;
    }

    public void setAnnualSalary(BigDecimal annualSalary) {
        AnnualSalary = annualSalary;
    }

    @Override
    public String toString() {
        return super.toString() + "SalariedEmployee{" +
                "employmentMode=" + employmentMode +
                ", AnnualSalary=" + AnnualSalary +
                "}\n";
    }
}