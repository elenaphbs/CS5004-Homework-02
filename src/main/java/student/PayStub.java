package student;

/**
 * Represents a pay stub for an employee.
 */
public class PayStub implements IPayStub {

    /** The employee associated with this pay stub. */
    private IEmployee employee;
    /** The net pay for this pay period. */
    private double netPay;
    /** The taxes for this pay period. */
    private double taxes;

    /**
     * Constructor for PayStub.
     *
     * @param employee the employee
     * @param netPay the net pay
     * @param taxes the taxes
     */
    public PayStub(IEmployee employee, double netPay, double taxes) {
        this.employee = employee;
        this.netPay = netPay;
        this.taxes = taxes;
    }

    /**
     * Gets the pay for the current pay period.
     *
     * @return the net pay
     */
    public double getPay() {
        return this.netPay;
    }

    /**
     * Gets the taxes paid for the current pay period.
     *
     * @return the taxes paid
     */
    public double getTaxesPaid() {
        return this.taxes;
    }

    /**
     * Converts the pay stub to a CSV string.
     *
     * @return the CSV string
     */
    public String toCSV() {
        return employee.getName() + "," + netPay + "," + taxes
                + "," + employee.getYTDEarnings() + "," + employee.getYTDTaxesPaid();
    }
}
