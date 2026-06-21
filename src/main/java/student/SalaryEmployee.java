package student;

/**
 * Represents a salary employee.
 */
public class
SalaryEmployee extends Employee {

    /** The number of pay periods per year. */
    private static final int PAY_PERIODS = 24;

    /**
     * Constructor for SalaryEmployee.
     *
     * @param name the name
     * @param id the ID
     * @param payRate the pay rate
     * @param ytdEarnings the YTD earnings
     * @param ytdTaxesPaid the YTD taxes paid
     * @param pretaxDeductions the pretax deductions
     */
    public SalaryEmployee(String name, String id, double payRate,
                          double ytdEarnings, double ytdTaxesPaid, double pretaxDeductions) {
        super(name, id, payRate, "SALARY", ytdEarnings, ytdTaxesPaid, pretaxDeductions);
    }

    /**
     * Calculates the gross pay for the pay period.
     *
     * @param hoursWorked the hours worked
     * @return the gross pay
     */
    public double calculateGrossPay(double hoursWorked) {
        if (hoursWorked >= 0) {
            return (this.getPayRate() / PAY_PERIODS);
        }
        return 0;
    }
}
