package bartek.employee;

import bartek.enums.Department;
import bartek.enums.JobTitle;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CommissionEmployee extends Employee {
    private BigDecimal commissionPercentage;
    private BigDecimal TotalSales;

    public CommissionEmployee(Long id, JobTitle title, String firstName, String lastName, LocalDate dateOfBirth, Long nationalInsuranceNumber, Department department) {
        super(id, title, firstName, lastName, dateOfBirth, nationalInsuranceNumber, department);
    }

    public CommissionEmployee(Long id, JobTitle title, String firstName, String lastName, LocalDate dateOfBirth, Long nationalInsuranceNumber, Department department, BigDecimal commissionPercentage, BigDecimal totalSales) {
        super(id, title, firstName, lastName, dateOfBirth, nationalInsuranceNumber, department);
        this.commissionPercentage = commissionPercentage;
        TotalSales = totalSales;
    }

    public CommissionEmployee() {

    }

    public BigDecimal getCommissionPercentage() {
        return commissionPercentage;
    }

    public void setCommissionPercentage(BigDecimal commissionPercentage) {
        this.commissionPercentage = commissionPercentage;
    }

    public BigDecimal getTotalSales() {
        return TotalSales;
    }

    public void setTotalSales(BigDecimal totalSales) {
        TotalSales = totalSales;
    }

    @Override
    public String toString() {
        return super.toString() + "CommissionEmployee{" +
                "commissionPercentage=" + commissionPercentage +
                ", TotalSales=" + TotalSales +
                "}\n";
    }
}
