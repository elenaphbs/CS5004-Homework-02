package student;

/**
 * Represents an hourly employee.
 */
public class HourlyEmployee extends Employee {

    /** The standard work hours before overtime. */
    private static final int STANDARD_HOURS = 40;
    /** The overtime pay multiplier. */
    private static final double OVERTIME_MULTIPLIER = 1.5;

    /**
     * Constructor for HourlyEmployee.
     *
     * @param name the name
     * @param id the ID
     * @param payRate the pay rate
     * @param employType the employee type
     * @param ytdEarnings the YTD earnings
     * @param ytdTaxesPaid the YTD taxes paid
     * @param pretaxDeductions the pretax deductions
     */
    public HourlyEmployee(String name, String id, double payRate, String employType,
                          double ytdEarnings, double ytdTaxesPaid, double pretaxDeductions) {
        super(name, id, payRate, employType, ytdEarnings, ytdTaxesPaid, pretaxDeductions);
    }

    /**
     * Calculates the gross pay for the pay period.
     *
     * @param hoursWorked the hours worked
     * @return the gross pay
     */
    public double calculateGrossPay(double hoursWorked) {
        if (hoursWorked >= 0 && hoursWorked <= STANDARD_HOURS) {
            return this.getPayRate() * hoursWorked;
        } else if (hoursWorked > STANDARD_HOURS) {
            return this.getPayRate() * STANDARD_HOURS
                    + this.getPayRate() * (hoursWorked - STANDARD_HOURS) * OVERTIME_MULTIPLIER;
        }
        return 0;
    }
}
