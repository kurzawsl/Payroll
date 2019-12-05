package bartek;

import bartek.employee.CommissionEmployee;
import bartek.employee.Employee;
import bartek.employee.HourlyEmployee;
import bartek.employee.SalariedEmployee;
import bartek.enums.Department;
import bartek.enums.EmploymentMode;
import bartek.enums.JobTitle;
import bartek.repositories.EmployeeRepository;
import bartek.repositories.EmployeeRepositoryDummyData;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args) {
        EmployeeRepository employeeRepository = new EmployeeRepositoryDummyData();
        displayMainMenu(employeeRepository);
    }

    private static void displayMainMenu(EmployeeRepository employeeRepository) {
        Scanner in = new Scanner(System.in);

        boolean quit = false;

        int menuItem;

        do {
            System.out.println("******************************");
            System.out.println("*       Payroll System       *");
            System.out.println("******************************");
            System.out.println("1. Register Employee");
            System.out.println("2. View Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Generate Pay slip");
            System.out.println("5. Exit");

            System.out.print("Choose menu item: ");

            menuItem = in.nextInt();

            switch (menuItem) {
                case 1:
                    registerEmployees(employeeRepository);
                    break;
                case 2:
                    viewEmployees(employeeRepository);
                    break;
                case 3:
                    removeEmployee(employeeRepository);
                    break;
                case 4:
                    showPayslips(employeeRepository);
                    break;

                case 5:
                    quit = true;
                    break;

                default:
                    System.out.println("Invalid choice.");

            }

        } while (!quit);

        System.out.println("Bye-bye!");
    }

    private static void showPayslips(EmployeeRepository employeeRepository) {
        Scanner in = new Scanner(System.in);

        boolean quit = false;

        int menuItem;

        do {
            System.out.println("******************************");
            System.out.println("*      Generate Pay slip     *");
            System.out.println("******************************");
            System.out.println("1. Salaried Employee");
            System.out.println("2. Hourly Employee");
            System.out.println("3. Commission Employee");
            System.out.println("4. Exit");

            System.out.print("Choose menu item: ");

            menuItem = in.nextInt();

            long emplyeeId;

            switch (menuItem) {
                case 1:
                    printSalariedEmployees(employeeRepository.getSalariedEmployees());
                    emplyeeId = choseEmployeeId();
                    printPayslip(emplyeeId);
                    pressAnyToContinue();
                    break;
                case 2:
                    printHourlyEmployees(employeeRepository.getHourlyEmployees());
                    emplyeeId = choseEmployeeId();
                    printPayslip(emplyeeId);
                    pressAnyToContinue();
                    break;
                case 3:
                    printCommissionEmployees(employeeRepository.getCommissionEmployees());
                    emplyeeId = choseEmployeeId();
                    printPayslip(emplyeeId);
                    pressAnyToContinue();
                    break;
                case 4:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice.");

            }

        } while (!quit);
    }

    private static void printPayslip(long emplyeeId) {

    }

    private static long choseEmployeeId() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Employee ID:");
        long id = in.nextInt();
        return id;
    }

    private static void removeEmployee(EmployeeRepository employeeRepository) {
        Scanner in = new Scanner(System.in);
        printEmployees(employeeRepository.getAllEmployees());
        System.out.print("Enter Employee ID to remove:");
        long id = in.nextInt();

        Employee employeeToRemove = null;

        for(Employee employee: employeeRepository.getAllEmployees()){
            if(employee.getId().equals(id)){
                employeeToRemove = employee;
            }
        }
        employeeRepository.getAllEmployees().remove(employeeToRemove);

    }

    private static void registerEmployees(EmployeeRepository employeeRepository) {
        Scanner in = new Scanner(System.in);

        boolean quit = false;

        int menuItem;

        do {
            System.out.println("******************************");
            System.out.println("*      Register Employees    *");
            System.out.println("******************************");
            System.out.println("1. Salaried Employee");
            System.out.println("2. Hourly Employee");
            System.out.println("3. Commission Employee");
            System.out.println("4. Exit");

            System.out.print("Choose menu item: ");

            menuItem = in.nextInt();

            switch (menuItem) {
                case 1:
                    registerSalaryEmployee(employeeRepository);
                    pressAnyToContinue();
                    break;
                case 2:
                    registerHourlyEmployee(employeeRepository);
                    pressAnyToContinue();
                    break;
                case 3:
                    registerCommisionEmployee(employeeRepository);
                    pressAnyToContinue();
                    break;
                case 4:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice.");

            }

        } while (!quit);
    }

    private static void registerCommisionEmployee(EmployeeRepository employeeRepository) {
        CommissionEmployee commissionEmployee = new CommissionEmployee();
        Scanner in = new Scanner(System.in);

        inputComonEmployeeData(employeeRepository, commissionEmployee, in);

        System.out.print("Commission Percentage: ");
        String commision = in.next();
        commissionEmployee.setCommissionPercentage(new BigDecimal(commision));

        System.out.print("Total Sales: ");
        String sales = in.next();
        commissionEmployee.setTotalSales(new BigDecimal(sales));

        employeeRepository.getAllEmployees().add(commissionEmployee);
    }

    private static void registerHourlyEmployee(EmployeeRepository employeeRepository) {
        HourlyEmployee hourlyEmployee = new HourlyEmployee();
        Scanner in = new Scanner(System.in);

        inputComonEmployeeData(employeeRepository, hourlyEmployee, in);

        System.out.print("Hourly rate: ");
        String hours = in.next();
        hourlyEmployee.setHourlyRate(new BigDecimal(hours));


        employeeRepository.getAllEmployees().add(hourlyEmployee);
    }

    private static void registerSalaryEmployee(EmployeeRepository employeeRepository) {
        SalariedEmployee salariedEmployee = new SalariedEmployee();
        Scanner in = new Scanner(System.in);

        inputComonEmployeeData(employeeRepository, salariedEmployee, in);

        System.out.print("Salary: ");
        int salary = in.nextInt();
        salariedEmployee.setAnnualSalary(BigDecimal.valueOf(salary));

        System.out.print("Department: ");
        for (Department department : Department.values()) {
            System.out.print(" " + department.ordinal() + " - " + department);
        }
        System.out.println();
        System.out.print("Employment mode (0 - 1): ");
        int employemntMode = in.nextInt();
        salariedEmployee.setEmploymentMode(getEmploymentModeByOrdinal(employemntMode));

        employeeRepository.getAllEmployees().add(salariedEmployee);
    }

    private static void inputComonEmployeeData(EmployeeRepository employeeRepository, Employee salariedEmployee, Scanner in) {
        salariedEmployee.setId(getSubsequentId(employeeRepository.getAllEmployees()));

        System.out.print("Title: ");
        for (JobTitle jobTitle : JobTitle.values()) {
            System.out.print(" " + jobTitle.ordinal() + " - " + jobTitle);
        }
        System.out.println();
        System.out.print("Enter Job Title (0 - 6): ");
        int titleOrdinal = in.nextInt();
        salariedEmployee.setTitle(getJobTitleByOrdinal(titleOrdinal));

        System.out.print("First Name: ");
        String firstName = in.next();
        salariedEmployee.setFirstName(firstName);

        System.out.print("Last Name: ");
        String lastName = in.next();
        salariedEmployee.setLastName(lastName);

        System.out.print("Date of Birth (format YYYY-MM-DD): ");
        String birthDate = in.next();
        salariedEmployee.setDateOfBirth(getBirthDateFromString(birthDate));

        System.out.print("National Inssurance Number: ");
        int ni = in.nextInt();
        salariedEmployee.setNationalInsuranceNumber((long) ni);

        System.out.print("Department: ");
        for (Department department : Department.values()) {
            System.out.print(" " + department.ordinal() + " - " + department);
        }
        System.out.println();
        System.out.print("Enter Department (0 - 2): ");
        int departmentOrdinal = in.nextInt();
        salariedEmployee.setDepartment(getDepartmentByOrdinal(departmentOrdinal));


    }

    private static EmploymentMode getEmploymentModeByOrdinal(int employemntMode) {
        for (EmploymentMode employmentMode : EmploymentMode.values()) {
            if (employemntMode == employmentMode.ordinal())
                return employmentMode;
        }
        return null;
    }

    private static Long getSubsequentId(List<Employee> allEmployees) {
        long max = 0;
        for (Employee employee : allEmployees) {
            if (employee.getId() > max) {
                max = employee.getId();
            }
        }

        return max + 1;
    }

    private static Department getDepartmentByOrdinal(int departmentOrdinal) {
        for (Department department : Department.values()) {
            if (departmentOrdinal == department.ordinal())
                return department;
        }
        return null;
    }

    private static LocalDate getBirthDateFromString(String birthDate) {
        return LocalDate.parse(birthDate);
    }

    private static JobTitle getJobTitleByOrdinal(int titleOrdinal) {
        for (JobTitle jobTitle : JobTitle.values()) {
            if (titleOrdinal == jobTitle.ordinal())
                return jobTitle;
        }
        return null;
    }

    private static void viewEmployees(EmployeeRepository employeeRepository) {
        Scanner in = new Scanner(System.in);

        boolean quit = false;

        int menuItem;

        do {
            System.out.println("******************************");
            System.out.println("*        View Employee       *");
            System.out.println("******************************");
            System.out.println("1. All Employees");
            System.out.println("2. Salaried Employees");
            System.out.println("3. Hourly Employees");
            System.out.println("4. Commission Employees");
            System.out.println("5. Exit");

            System.out.print("Choose menu item: ");

            menuItem = in.nextInt();

            switch (menuItem) {

                case 1:
                    printEmployees(employeeRepository.getAllEmployees());
                    pressAnyToContinue();
                    break;
                case 2:
                    printSalariedEmployees(employeeRepository.getSalariedEmployees());
                    pressAnyToContinue();
                    break;
                case 3:
                    printHourlyEmployees(employeeRepository.getHourlyEmployees());
                    pressAnyToContinue();
                    break;
                case 4:
                    printCommissionEmployees(employeeRepository.getCommissionEmployees());
                    pressAnyToContinue();
                case 5:

                    System.out.println("Exit");

                    quit = true;

                    break;

                default:
                    System.out.println("Invalid choice.");

            }

        } while (!quit);
    }

    private static void printCommissionEmployees(List<CommissionEmployee> commissionEmployees) {
        System.out
                .println("-----------------------------------------------------------------------------------------------------------------------");
        System.out
                .println("| ID |    TITLE     | FIRST NAME |   LAST NAME   | DATE OF BIRTH |     NI     |  DEPARTMENT  | COMM PRC | TOTAL SALES |");
        System.out
                .println("-----------------------------------------------------------------------------------------------------------------------");
        for (CommissionEmployee employee : commissionEmployees) {
            printStandardEmployeeData(employee);
            System.out.print(" " + employee.getCommissionPercentage() + pad(employee.getCommissionPercentage().toString(), 9) + "|");
            System.out.print(" " + employee.getTotalSales() + pad(employee.getTotalSales().toString(), 12) + "|");
            System.out.println();
        }
    }

    private static void printHourlyEmployees(List<HourlyEmployee> hourlyEmployees) {
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID |    TITLE     | FIRST NAME |   LAST NAME   | DATE OF BIRTH |     NI     |  DEPARTMENT  | HOURLY RATE |");
        System.out.println("------------------------------------------------------------------------------------------------------------");
        for (HourlyEmployee employee : hourlyEmployees) {
            printStandardEmployeeData(employee);
            System.out.print(" " + employee.getHourlyRate() + pad(employee.getHourlyRate().toString(), 12) + "|");
            System.out.println();
        }
    }

    private static void printSalariedEmployees(List<SalariedEmployee> salariedEmployees) {
        System.out
                .println("---------------------------------------------------------------------------------------------------------------------------");
        System.out
                .println("| ID |    TITLE     | FIRST NAME |   LAST NAME   | DATE OF BIRTH |     NI     |  DEPARTMENT  |  SALARY  | EMPLOYMENT MODE |");
        System.out
                .println("---------------------------------------------------------------------------------------------------------------------------");
        for (SalariedEmployee employee : salariedEmployees) {
            printStandardEmployeeData(employee);
            System.out.print(" " + employee.getAnnualSalary() + pad(employee.getAnnualSalary().toString(), 9) + "|");
            System.out.print(" " + employee.getEmploymentMode() + pad(employee.getEmploymentMode().toString(), 16) + "|");
            System.out.println();
        }
    }


    private static void printEmployees(List<Employee> allEmployees) {
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("| ID |    TITLE     | FIRST NAME |   LAST NAME   | DATE OF BIRTH |     NI     |  DEPARTMENT  |");
        System.out.println("---------------------------------------------------------------------------------------------");
        for (Employee employee : allEmployees) {
            printStandardEmployeeData(employee);
            System.out.println();
        }
    }

    private static void printStandardEmployeeData(Employee employee) {
        System.out.print("| " + employee.getId() + "  |");
        System.out.print(" " + employee.getTitle() + pad(employee.getTitle().toString(), 13) + "|");
        System.out.print(" " + employee.getFirstName() + pad(employee.getFirstName(), 11) + "|");
        System.out.print(" " + employee.getLastName() + pad(employee.getLastName(), 14) + "|");
        System.out.print(" " + employee.getDateOfBirth() + pad(employee.getDateOfBirth().toString(), 14) + "|");
        System.out.print(" " + employee.getNationalInsuranceNumber() + pad(employee.getNationalInsuranceNumber().toString(), 11) + "|");
        System.out.print(" " + employee.getDepartment() + pad(employee.getDepartment().toString(), 13) + "|");
    }

    private static String pad(String str, int length) {
        String result = "";
        for (int i = 0; i < length - str.length(); i++) {
            result += " ";
        }
        return result;
    }

    private static void pressAnyToContinue() {
        System.out.println("Press Enter key to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
