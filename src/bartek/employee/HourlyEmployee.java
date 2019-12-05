package bartek.employee;

import bartek.enums.Department;
import bartek.enums.JobTitle;

import java.math.BigDecimal;
import java.time.LocalDate;

public class HourlyEmployee extends Employee {
    private BigDecimal hourlyRate;

    public HourlyEmployee(Long id, JobTitle title, String firstName, String lastName, LocalDate dateOfBirth, Long nationalInsuranceNumber, Department department, BigDecimal hourlyRate) {
        super(id, title, firstName, lastName, dateOfBirth, nationalInsuranceNumber, department);
        this.hourlyRate = hourlyRate;
    }

    public HourlyEmployee() {

    }

    public BigDecimal getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(BigDecimal hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public String toString() {
        return super.toString() + "HourlyEmployee{" +
                "hourlyRate=" + hourlyRate +
                "}\n";
    }
}