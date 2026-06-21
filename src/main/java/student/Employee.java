package student;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Abstract base class for employees.
 */
public abstract class Employee implements IEmployee {

    /** The name of the employee. */
    private String name;
    /** The ID of the employee. */
    private String id;
    /** The pay rate of the employee. */
    private double payRate;
    /** The type of the employee. */
    private String employeeType;
    /** The year-to-date earnings. */
    private double ytdEarnings;
    /** The year-to-date taxes paid. */
    private double ytdTaxesPaid;
    /** The pretax deductions. */
    private double pretaxDeductions;
    /** The tax rate applied to net pay. */
    private static final double TAX_RATE = 0.2265;

    /**
     * Constructor for Employee.
     *
     * @param name the name of the employee
     * @param id the ID of the employee
     * @param payRate the pay rate
     * @param employType the employee type
     * @param ytdEarnings the year-to-date earnings
     * @param ytdTaxesPaid the year-to-date taxes paid
     * @param pretaxDeductions the pretax deductions
     */
    public Employee(String name, String id, double payRate, String employType,
                    double ytdEarnings, double ytdTaxesPaid, double pretaxDeductions) {
        this.name = name;
        this.id = id;
        this.payRate = payRate;
        this.employeeType = employType;
        this.ytdEarnings = ytdEarnings;
        this.ytdTaxesPaid = ytdTaxesPaid;
        this.pretaxDeductions = pretaxDeductions;
    }

    /**
     * Gets the name of the employee.
     *
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the ID of the employee.
     *
     * @return the ID
     */
    public String getID() {
        return this.id;
    }

    /**
     * Gets the pay rate of the employee.
     *
     * @return the pay rate
     */
    public double getPayRate() {
        return this.payRate;
    }

    /**
     * Gets the type of the employee.
     *
     * @return the employee type
     */
    public String getEmployeeType() {
        return this.employeeType;
    }

    /**
     * Gets the year-to-date earnings.
     *
     * @return the YTD earnings
     */
    public double getYTDEarnings() {
        return this.ytdEarnings;
    }

    /**
     * Gets the year-to-date taxes paid.
     *
     * @return the YTD taxes paid
     */
    public double getYTDTaxesPaid() {
        return this.ytdTaxesPaid;
    }

    /**
     * Gets the pretax deductions.
     *
     * @return the pretax deductions
     */
    public double getPretaxDeductions() {
        return this.pretaxDeductions;
    }

    /**
     * Runs the payroll for this employee.
     *
     * @param hoursWorked the hours worked
     * @return the pay stub for the current pay period
     */
    public IPayStub runPayroll(double hoursWorked) {
        double taxes = (this.calculateGrossPay(hoursWorked) - pretaxDeductions) * TAX_RATE;
        BigDecimal taxesBD = new BigDecimal(taxes).setScale(2, RoundingMode.HALF_UP);
        double taxesRounded = taxesBD.doubleValue();

        double netPay = this.calculateGrossPay(hoursWorked) - pretaxDeductions - taxes;
        BigDecimal netPayBD = new BigDecimal(netPay).setScale(2, RoundingMode.HALF_UP);
        double netPayRounded = netPayBD.doubleValue();

        ytdTaxesPaid += taxesRounded;
        ytdEarnings += netPayRounded;

        IPayStub payStub = null;
        if (employeeType.equals("HOURLY")) {
            payStub = new PayStub(this, netPayRounded, taxesRounded);
        } else if (employeeType.equals("SALARY")) {
            payStub = new PayStub(this, netPayRounded, taxesRounded);
        }

        return payStub;
    }

    /**
     * Converts the employee to a CSV string.
     *
     * @return the CSV string
     */
    public String toCSV() {
        return employeeType + "," + name + "," + id + "," + payRate
                + "," + pretaxDeductions + "," + ytdEarnings + "," + ytdTaxesPaid;
    }

    /**
     * Calculates the gross pay for the pay period.
     *
     * @param hoursWorked the hours worked
     * @return the gross pay
     */
    public abstract double calculateGrossPay(double hoursWorked);
}
